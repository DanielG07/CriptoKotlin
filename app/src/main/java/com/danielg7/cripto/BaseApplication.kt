package com.danielg7.cripto

import android.app.Application
import com.danielg7.cripto.utils.ReleaseTree
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber.*
import timber.log.Timber.Forest.plant

@HiltAndroidApp
class BaseApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG) plant(DebugTree()) else plant(ReleaseTree())
    }
}
