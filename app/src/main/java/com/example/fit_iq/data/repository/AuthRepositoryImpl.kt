package com.example.fit_iq.data.repository

import com.example.fit_iq.domain.model.repository.AuthRepository
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.tasks.await

class AuthRepositoryImpl : AuthRepository {

    val firebaseAuth = FirebaseAuth.getInstance()

    override suspend fun signInAnonymously(): Result<Boolean> {
        return try {
            firebaseAuth.signInAnonymously().await()

            Result.success(true)
        } catch (e: Exception) {

            Result.failure(e)
        }
    }
}


