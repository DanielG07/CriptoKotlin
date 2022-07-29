package com.danielg7.common.utils

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class ErrorResponse(
    @SerializedName("status") var status: Int?,
    @SerializedName("error_code") var errorCode: String?,
    @SerializedName("detail") var details: String?
) : Parcelable
