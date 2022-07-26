package com.danielg7.cripto.data.repositories

import com.danielg7.cripto.data.CriptoLocalDataSource
import com.danielg7.cripto.data.CriptoRemoteDataSource
import com.danielg7.cripto.data.remote.models.Cripto
import com.danielg7.cripto.utils.DataState
import com.danielg7.cripto.utils.ErrorResponse
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map

class CriptosRepositoryImpl @Inject constructor(
    private val remoteDataSource: CriptoRemoteDataSource,
    private val localDataSource: CriptoLocalDataSource
) : CriptosRepository {

    override fun getCriptos(refresh: Boolean): Flow<DataState<List<Cripto>, ErrorResponse>> =

        when (refresh) {
            true ->
                flow {
                    val response = remoteDataSource.getCriptos()
                    when (response) {
                        is DataState.Success ->
                            localDataSource.insertCriptos(response.data)
                    }
                    emit(response)
                }
            false -> {
                localDataSource.getCriptos()
                    .map { DataState.Success(it) }
            }
        }
}
