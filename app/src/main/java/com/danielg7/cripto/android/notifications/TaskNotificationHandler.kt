package com.danielg7.cripto.android.notifications

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.ContextWrapper
import android.graphics.Color
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.core.content.ContextCompat
import com.danielg7.cripto.R
import com.danielg7.cripto.ui.home.MainActivity

class TaskNotificationHandler(private val context: Context) : ContextWrapper(context),
    INotificationHandler {
    private var _manager: NotificationManager? = null
    private val notifManager get() = _manager!!

    init {
        createChannels()
    }

    private fun createChannels() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val highChannel = NotificationChannel(
                CHANNEL_HIGH_ID,
                CHANNEL_HIGH_NAME,
                NotificationManager.IMPORTANCE_HIGH
            ).apply {
                enableLights(true)
                setShowBadge(true)
                enableVibration(true)
                setSound(null, null)
                lockscreenVisibility = Notification.VISIBILITY_PUBLIC
                vibrationPattern = longArrayOf(100, 100, 200, 100)
                lightColor = Color.GREEN
            }
            val lowChannel = NotificationChannel(
                CHANNEL_LOW_ID,
                CHANNEL_LOW_NAME,
                NotificationManager.IMPORTANCE_LOW
            )
            // Register the channel with the system
            getManager().createNotificationChannel(highChannel)
            getManager().createNotificationChannel(lowChannel)
        }
    }

    private fun createNotificationWithChannel(
        title: String,
        message: String,
        channelId: String
    ): NotificationCompat.Builder? {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val pendingIntent =
                PendingIntent.getActivity(
                    this,
                    0,
                    MainActivity.getIntent(this),
                    PendingIntent.FLAG_MUTABLE
                )
            val startAction =
                NotificationCompat.Action.Builder(
                    R.drawable.ic_launcher_background,
                    "Previous",
                    pendingIntent
                ).build()

            val secondAction =
                NotificationCompat.Action.Builder(
                    R.drawable.ic_launcher_background,
                    "Next",
                    pendingIntent
                ).build()

            return NotificationCompat.Builder(applicationContext, channelId)
                .setContentTitle(title)
                .setContentText(message)
                .setContentIntent(pendingIntent)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setGroup(SUMMARY_GROUP_NAME)
                .setColor(ContextCompat.getColor(this, R.color.purple_700))
                .addAction(startAction)
                .addAction(secondAction)
                .setAutoCancel(true)
        }
        return null
    }

    override fun createNotification(
        title: String,
        message: String,
        isHighImportance: Boolean,
        payload: Map<String, String>?
    ): NotificationCompat.Builder? {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            return createNotificationWithChannel(
                title,
                message,
                if (isHighImportance) CHANNEL_HIGH_ID else CHANNEL_LOW_ID
            )
        }
        return createNotificationWithoutChannel(title, message)
    }

    private fun createNotificationWithoutChannel(
        title: String,
        message: String
    ): NotificationCompat.Builder {
        return NotificationCompat.Builder(applicationContext)
            .setContentTitle(title)
            .setContentText(message)
            .setSmallIcon(R.mipmap.ic_launcher)
            .setAutoCancel(true)
    }

    override fun publishNotificationSummaryGroup(
        isHightImportance: Boolean,
        pendingIntent: PendingIntent?
    ) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channelId = if (isHightImportance) CHANNEL_HIGH_ID else CHANNEL_LOW_ID
            val summaryNotification = Notification.Builder(applicationContext, channelId)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setColor(ContextCompat.getColor(this, R.color.teal_200))
                .setGroup(SUMMARY_GROUP_NAME)
                .setGroupSummary(true)
                .setAutoCancel(true)
            if (pendingIntent != null)
                summaryNotification.setContentIntent(pendingIntent)
            getManager().notify(SUMMARY_GROUP_ID, summaryNotification.build())
        }
    }

    override fun getManager(): NotificationManager {
        if (_manager == null)
            _manager = context.getSystemService(NOTIFICATION_SERVICE) as NotificationManager
        return notifManager
    }

    companion object {
        const val CHANNEL_HIGH_ID = "11"
        const val CHANNEL_HIGH_NAME = "TASK_CHANNEL_HIGH_NAME"
        const val CHANNEL_LOW_ID = "22"
        const val CHANNEL_LOW_NAME = "TASK_CHANNEL_LOW_NAME"
        const val SUMMARY_GROUP_ID = 2001
        const val SUMMARY_GROUP_NAME = "TASK_SUMMARY_GROUP_NAME"
    }
}
