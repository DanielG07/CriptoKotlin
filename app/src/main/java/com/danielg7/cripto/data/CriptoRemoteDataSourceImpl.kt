package com.danielg7.cripto.data

import com.danielg7.cripto.data.remote.api.BitsoApi
import com.danielg7.cripto.data.remote.models.Cripto
import com.danielg7.cripto.utils.DataState
import com.danielg7.cripto.utils.ErrorResponse
import javax.inject.Inject
import timber.log.Timber

class CriptoRemoteDataSourceImpl @Inject constructor(private val api: BitsoApi) :
    CriptoRemoteDataSource {

    override suspend fun getCriptos(): DataState<List<Cripto>, ErrorResponse> {

        val response = api.getCriptos()

        try {

            if (response.isSuccessful) {

                val criptos: List<Cripto>? = response.body()?.payload
                if (criptos != null) {

                    return DataState.Success(data = criptos)
                } else {
                    return DataState.Error(
                        error = ErrorResponse(
                            status = 500,
                            errorCode = "Criptos are null",
                            details = "Criptos null details"
                        )
                    )
                }
            } else {
                return DataState.Error(
                    error = ErrorResponse(
                        status = 500,
                        errorCode = "Criptos request failed",
                        details = "Criptos request failed details"
                    )
                )
            }
        } catch (e: Exception) {
            Timber.e(e)
            return DataState.Error(
                error = ErrorResponse(
                    status = 500,
                    errorCode = "Another error code",
                    details = "Error details"
                )
            )
        }
    }
}
