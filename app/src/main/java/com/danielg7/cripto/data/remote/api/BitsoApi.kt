package com.danielg7.cripto.data.remote.api

import com.danielg7.cripto.data.remote.models.BitsoResponse
import retrofit2.Response
import retrofit2.http.GET

interface BitsoApi {

    @GET("/v3/available_books/")
    suspend fun getCriptos(): Response<BitsoResponse>
}