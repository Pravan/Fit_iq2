package com.example.fit_iq.domain.model.repository

interface AuthRepository {
    suspend fun signInAnonymously(): Result<Boolean>
}