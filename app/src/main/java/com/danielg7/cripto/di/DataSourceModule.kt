package com.danielg7.cripto.di

import com.danielg7.cripto.data.CriptoRemoteDataSource
import com.danielg7.cripto.data.CriptoRemoteDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
@Suppress("unused")
abstract class DataSourceModule {

    @Binds
    abstract fun bindCriptosRemoteDataSource(
        dataSource: CriptoRemoteDataSourceImpl
    ): CriptoRemoteDataSource
}