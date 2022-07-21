package com.danielg7.cripto.utils

import android.R.attr
import android.util.Log
import com.google.firebase.crashlytics.ktx.crashlytics
import com.google.firebase.ktx.Firebase
import timber.log.Timber

class ReleaseTree : Timber.Tree() {
    protected override fun log(priority: Int, tag: String?, message: String, throwable: Throwable?) {
        if (priority == Log.VERBOSE || priority == Log.DEBUG) {
            return
        }

        val t = throwable ?: Exception(message)

        // Crashlytics
        Firebase.crashlytics.setCustomKey(CRASHLYTICS_KEY_PRIORITY, attr.priority)
        Firebase.crashlytics.setCustomKey(CRASHLYTICS_KEY_TAG, attr.tag)
        Firebase.crashlytics.setCustomKey(CRASHLYTICS_KEY_MESSAGE, message)
        Firebase.crashlytics.recordException(t)

        // Firebase Crash Reporting
        // Firebase Crash Reporting
        Firebase.crashlytics.log("${attr.priority} ${attr.tag} $message")
    }

    companion object {
        private const val CRASHLYTICS_KEY_PRIORITY = "priority"
        private const val CRASHLYTICS_KEY_TAG = "tag"
        private const val CRASHLYTICS_KEY_MESSAGE = "message"
    }
}
