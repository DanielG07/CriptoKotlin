package com.danielg7.traders.data.repository

import com.danielg7.common.utils.DataState
import com.danielg7.common.utils.ErrorResponse
import com.danielg7.traders.data.remote.model.Traders
import kotlinx.coroutines.flow.Flow

/**
 * @author Daniel
 * @since 1.3.8
 */

interface TradersRepository {
    /**
     * @see
     */
    fun getTraders(refresh: Boolean): Flow<DataState<List<Traders>, ErrorResponse>>
}
