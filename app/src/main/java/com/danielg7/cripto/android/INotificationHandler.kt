package com.danielg7.cripto.android

import android.app.Notification
import android.app.NotificationManager
import android.app.PendingIntent

interface INotificationHandler {
    fun createNotification(
        title: String,
        message: String,
        isHighImportance: Boolean,
        payload: Map<String, String>?
    ): Notification.Builder?

    fun publishNotificationSummaryGroup(isHightImportance: Boolean, pendingIntent: PendingIntent?)
    fun getManager(): NotificationManager
}
