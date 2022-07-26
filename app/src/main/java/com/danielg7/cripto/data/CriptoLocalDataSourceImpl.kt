package com.danielg7.cripto.data

import com.danielg7.cripto.data.local.AppDataBase
import com.danielg7.cripto.data.local.models.mapToDomain
import com.danielg7.cripto.data.remote.models.Cripto
import com.danielg7.cripto.data.remote.models.mapToEntity
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class CriptoLocalDataSourceImpl @Inject constructor(private val dataBase: AppDataBase) :
    CriptoLocalDataSource {
    override fun getCriptos(): Flow<List<Cripto>> {
        return dataBase.criptoDao().getCriptos().map { it.mapToDomain() }
    }

    override suspend fun deleteCriptos() {
        dataBase.criptoDao().deleteJobs()
    }

    override suspend fun insertCriptos(criptos: List<Cripto>) {
        dataBase.criptoDao().insertJobs(criptos.mapToEntity())
    }
}
