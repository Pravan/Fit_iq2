package com.example.fit_iq.di

import com.example.fit_iq.data.repository.AuthRepositoryImpl
import com.example.fit_iq.domain.model.repository.AuthRepository
import com.example.fit_iq.data.repository.DatabaseRepositoryImpl
import com.example.fit_iq.domain.model.repository.DatabaseRepository
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.Provides
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {


    @Provides
    @Singleton
    fun provideAuthRepository(): AuthRepository {
        return AuthRepositoryImpl()
    }


    @Provides
    @Singleton
    fun provideDatabaseRepository(): DatabaseRepository {
        return DatabaseRepositoryImpl()
    }
}