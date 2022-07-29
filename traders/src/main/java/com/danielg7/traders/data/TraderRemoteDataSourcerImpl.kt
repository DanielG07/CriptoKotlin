package com.danielg7.traders.data

import com.danielg7.common.utils.DataState
import com.danielg7.common.utils.ErrorResponse
import com.danielg7.traders.data.remote.api.BitsoApi
import com.danielg7.traders.data.remote.model.Traders
import javax.inject.Inject
import timber.log.Timber

class TraderRemoteDataSourcerImpl @Inject constructor(private val api: BitsoApi) :
    TraderRemoteDataSource {
    override suspend fun getTraders(): DataState<List<Traders>, ErrorResponse> {
        val response = api.getTraders()

        try {
            if (response.isSuccessful) {

                val traders: List<Traders>? = response.body()?.traders
                if (traders != null) {

                    return DataState.Success(data = traders)
                } else {
                    return DataState.Error(
                        error = ErrorResponse(
                            status = 500,
                            errorCode = "com.danielg7.traders.data.remote.model.Traders are null",
                            details = "com.danielg7.traders.data.remote.model.Traders null details"
                        )
                    )
                }
            } else {
                return DataState.Error(
                    error = ErrorResponse(
                        status = 500,
                        errorCode = "com.danielg7.traders.data.remote.model.Traders request failed",
                        details = "com.danielg7.traders.data.remote.model.Traders request failed details"
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
