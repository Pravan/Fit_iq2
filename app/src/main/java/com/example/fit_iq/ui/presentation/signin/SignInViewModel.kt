package com.example.fit_iq.ui.presentation.signin

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fit_iq.domain.model.repository.AuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

@HiltViewModel
class SignInViewModel @Inject constructor (
    private val authRepository: AuthRepository
)
    :ViewModel() {


   private val _state = MutableStateFlow(SignInState())
    val state = _state.asStateFlow()


    fun onEvent(event: SignInEvent){
        when(event) {
            is SignInEvent.SignInAnonymous -> {
                signInAnonymously()
            }
            is SignInEvent.SignInWithGoogle -> {

            }
        }
    }

    private fun signInAnonymously(){
        viewModelScope.launch {
            authRepository.signInAnonymously()

                .onSuccess {

                }
                .onFailure {

                }
        }
    }

}