package com.danielg7.traders.data.remote.api

import com.danielg7.traders.data.remote.model.BitsoResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface BitsoApi {

    @GET("/v3/available_books/")
    suspend fun getTraders(@Query("book") book: String = "btc_mxn"): Response<BitsoResponse>
}
