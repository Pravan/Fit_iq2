package com.example.fit_iq.ui.presentation.signin

import android.content.Context

sealed class SignInEvent {
    data class SignInWithGoogle(val context: Context):SignInEvent()
    data object SignInAnonymous: SignInEvent()
}