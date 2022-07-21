package com.danielg7.cripto.data.repositories

import com.danielg7.cripto.data.CriptoRemoteDataSource
import com.danielg7.cripto.data.remote.models.Payload
import com.danielg7.cripto.utils.DataState
import com.danielg7.cripto.utils.ErrorResponse
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class CriptosRepositoryImpl @Inject constructor(private val remoteDataSource: CriptoRemoteDataSource) :
    CriptosRepository {

        override fun getCriptos(): Flow<DataState<List<Payload>, ErrorResponse>> {
            return flow { emit(remoteDataSource.getCriptos()) }
        }
}
