package com.danielg7.cripto.utils

import android.content.Context
import android.content.res.Resources
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import timber.log.Timber

/**
 * Determines if there's internet connection
 *
 * @return true when there's connection, false otherwise
 */
fun Context.hasInternetConnection(): Boolean {
    val cm = this.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val netInfo = cm.activeNetwork
    if (netInfo != null) {
        val netCap = cm.getNetworkCapabilities(netInfo)
        if (netCap != null) {
            return (netCap.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) ||
                    netCap.hasTransport(NetworkCapabilities.TRANSPORT_WIFI))
        }
    }
    Timber.d("No internet error")
    return false
}

fun Context.getStringByIdName(idName: String?): String? {
    val res: Resources = getResources()
    return res.getString(res.getIdentifier(idName, "string", getPackageName()))
}
