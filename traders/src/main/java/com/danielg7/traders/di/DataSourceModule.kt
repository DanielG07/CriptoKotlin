package com.danielg7.traders.di

import com.danielg7.traders.data.TraderRemoteDataSource
import com.danielg7.traders.data.TraderRemoteDataSourcerImpl
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
        dataSource: TraderRemoteDataSourcerImpl
    ): TraderRemoteDataSource
}
