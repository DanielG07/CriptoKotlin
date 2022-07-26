package com.danielg7.cripto.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.danielg7.cripto.data.local.daos.CriptosDao
import com.danielg7.cripto.data.local.models.CriptoEntity

@Database(
    entities = [
        CriptoEntity::class
    ],
    version = 2,
    exportSchema = false
)

abstract class AppDataBase : RoomDatabase() {

    abstract fun criptoDao(): CriptosDao

    companion object {
        var TEST_MODE = false
        private val DATABASE_NAME = "criptos-database"
        private var dbInstance: AppDataBase? = null
        fun getInstance(context: Context): AppDataBase {

            if (dbInstance == null) {

                dbInstance =
                    if (TEST_MODE)
                        Room.inMemoryDatabaseBuilder(context, AppDataBase::class.java)
                            .allowMainThreadQueries().build()
                    else Room.databaseBuilder(
                        context.applicationContext, AppDataBase::class.java,
                        DATABASE_NAME
                    )
                        .fallbackToDestructiveMigration()
                        .build()
            }

            return dbInstance!!
        }
    }
}
