package com.danielg7.cripto.di

import android.content.Context
import com.danielg7.cripto.BaseApplication
import com.danielg7.cripto.android.notifications.NotificationHandlerFactory
import com.danielg7.cripto.data.local.AppDataBase
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

    @Provides
    @Singleton
    fun provideDatabase(application: Context): AppDataBase = AppDataBase.getInstance(application)

    @Provides
    @Singleton
    fun provideNotificationHandler(
        context: Context
    ): NotificationHandlerFactory = NotificationHandlerFactory(context)
}
