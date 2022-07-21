package com.danielg7.cripto.data

import com.danielg7.cripto.data.remote.models.Payload
import com.danielg7.cripto.utils.DataState
import com.danielg7.cripto.utils.ErrorResponse

interface CriptoRemoteDataSource {

    suspend fun getCriptos(): DataState<List<Payload>, ErrorResponse>
}