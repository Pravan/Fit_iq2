package com.example.fit_iq.domain.model.repository

interface AuthRepository {
    abstract val FirebaseAuth: Any

    suspend fun signInAnonymously(): Result<Boolean>
}