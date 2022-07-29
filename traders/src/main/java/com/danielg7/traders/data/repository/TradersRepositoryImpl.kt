package com.danielg7.traders.data.repository

import com.danielg7.common.utils.DataState
import com.danielg7.common.utils.ErrorResponse
import com.danielg7.traders.data.TraderRemoteDataSource
import com.danielg7.traders.data.remote.model.Traders
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class TradersRepositoryImpl @Inject constructor(
    private val remoteDataSource: TraderRemoteDataSource
) : TradersRepository {

    override fun getTraders(refresh: Boolean): Flow<DataState<List<Traders>, ErrorResponse>> =
        flow {
            val response = remoteDataSource.getTraders()
            emit(response)
        }
}
