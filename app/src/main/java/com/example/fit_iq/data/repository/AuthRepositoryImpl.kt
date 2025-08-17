package com.example.fit_iq.data.repository

import com.example.fit_iq.domain.model.repository.AuthRepository


class AuthRepositoryImpl: AuthRepository {


    override suspend fun signInAnonymously(): Result<Boolean> {
        return try {
            Result.success(value = true)
        } catch (e: Exception){
            Result.failure(e)
        }
    }
}