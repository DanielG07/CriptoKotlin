package com.danielg7.cripto.android.services

import com.danielg7.cripto.BaseApplication
import com.danielg7.cripto.android.notifications.INotificationHandler
import com.danielg7.cripto.android.notifications.NotificationHandlerFactory
import com.danielg7.cripto.android.notifications.NotificationType
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class CustomMessageReceiverService : FirebaseMessagingService() {

    @Inject
    lateinit var notificationHandlerFactory: NotificationHandlerFactory

    private lateinit var notificationHandler: INotificationHandler

    override fun onMessageReceived(message: RemoteMessage) {
        super.onMessageReceived(message)

        notificationHandler = getNotificationHandler()
        sendNotification(
            message.notification?.title.orEmpty(),
            message.notification?.body.orEmpty(),
            true,
            message.data
        )
    }

    private fun sendNotification(
        messageTitle: String,
        messageBody: String,
        isHighImportance: Boolean,
        payload: Map<String, String>?
    ) {
        notificationHandler.createNotification(
            messageTitle,
            messageBody,
            isHighImportance,
            payload
        )
            ?.let {
                val notifBuilder = it.build()
                val pendingIntent = notifBuilder.contentIntent
                notificationHandler.getManager()
                    .notify(
                        ++(application as BaseApplication).taskNotificationsCounter,
                        notifBuilder
                    )
                notificationHandler.publishNotificationSummaryGroup(isHighImportance, pendingIntent)
            }
    }

    private fun getNotificationHandler(): INotificationHandler =
        notificationHandlerFactory.createNotificationHandler(NotificationType.TASK)
}
