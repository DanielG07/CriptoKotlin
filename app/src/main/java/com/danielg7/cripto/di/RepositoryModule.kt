package com.danielg7.cripto.di

import com.danielg7.cripto.data.repositories.CriptosRepository
import com.danielg7.cripto.data.repositories.CriptosRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
@Suppress("unused")
abstract class RepositoryModule {

    @Binds
    abstract fun bindCriptosRepository(
        repository: CriptosRepositoryImpl
    ): CriptosRepository
}
