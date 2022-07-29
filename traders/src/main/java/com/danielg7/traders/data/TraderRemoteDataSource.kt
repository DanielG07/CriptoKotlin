package com.danielg7.traders.data

import com.danielg7.common.utils.DataState
import com.danielg7.common.utils.ErrorResponse
import com.danielg7.traders.data.remote.model.Traders

interface TraderRemoteDataSource {

    suspend fun getTraders(): DataState<List<Traders>, ErrorResponse>
}
