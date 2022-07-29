package com.danielg7.traders.di

import com.danielg7.traders.data.repository.TradersRepository
import com.danielg7.traders.data.repository.TradersRepositoryImpl
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
        repository: TradersRepositoryImpl
    ): TradersRepository
}
