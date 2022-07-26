package com.danielg7.cripto.android.notifications

import android.app.NotificationManager
import android.app.PendingIntent
import androidx.core.app.NotificationCompat

interface INotificationHandler {
    fun createNotification(
        title: String,
        message: String,
        isHighImportance: Boolean,
        payload: Map<String, String>?
    ): NotificationCompat.Builder?

    fun publishNotificationSummaryGroup(isHightImportance: Boolean, pendingIntent: PendingIntent?)
    fun getManager(): NotificationManager
}
