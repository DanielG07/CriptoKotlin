package com.danielg7.cripto.data

import com.danielg7.common.utils.DataState
import com.danielg7.common.utils.ErrorResponse
import com.danielg7.cripto.data.remote.models.Cripto

interface CriptoRemoteDataSource {

    suspend fun getCriptos(): DataState<List<Cripto>, ErrorResponse>
}
