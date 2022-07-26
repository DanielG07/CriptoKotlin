package com.danielg7.cripto.data.local.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.danielg7.cripto.data.local.models.CriptoEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface CriptosDao {
    @Query("SELECT * FROM criptos")
    fun getCriptos(): Flow<List<CriptoEntity>>

    @Query("DELETE FROM criptos")
    suspend fun deleteJobs()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertJobs(cripto: List<CriptoEntity>)
}
