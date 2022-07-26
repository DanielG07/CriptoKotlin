package com.danielg7.cripto.android.notifications

import android.content.Context

class NotificationHandlerFactory(private val context: Context) {
    fun createNotificationHandler(
        notificationType: NotificationType
    ): INotificationHandler {
        return TaskNotificationHandler(context)
    }
}
enum class NotificationType {
    TASK,
    LOCATION,
    NEXT_JOB
}
