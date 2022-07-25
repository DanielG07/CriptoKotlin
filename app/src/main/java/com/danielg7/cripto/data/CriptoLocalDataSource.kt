package com.danielg7.cripto.data

import com.danielg7.cripto.data.remote.models.Cripto
import kotlinx.coroutines.flow.Flow

interface CriptoLocalDataSource {
    fun getCriptos(): Flow<List<Cripto>>
    suspend fun deleteCriptos()
    suspend fun insertCriptos(criptos: List<Cripto>)
}
