package com.danielg7.cripto.data.repositories

import com.danielg7.cripto.data.remote.models.Cripto
import com.danielg7.cripto.utils.DataState
import com.danielg7.cripto.utils.ErrorResponse
import kotlinx.coroutines.flow.Flow

/**
 * @author Daniel
 * @since 1.3.8
 */

interface CriptosRepository {
    /**
     * @see getCriptos
     */
    fun getCriptos(refresh: Boolean): Flow<DataState<List<Cripto>, ErrorResponse>>
}
