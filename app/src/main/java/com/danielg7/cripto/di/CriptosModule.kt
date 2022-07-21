package com.danielg7.cripto.di

import android.content.Context
import com.danielg7.cripto.BaseApplication
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class CriptosModule {

    @Singleton
    @Provides
    fun provideApplicationContext(@ApplicationContext app: Context): Context {
        return (app as BaseApplication).applicationContext
    }
}
