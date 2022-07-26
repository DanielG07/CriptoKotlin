package com.danielg7.cripto.data.local.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import com.danielg7.cripto.data.remote.models.Cripto

@Entity(
    tableName = "criptos",
    indices = [Index("book")]
)
data class CriptoEntity(
    @PrimaryKey() val book: String,
    @ColumnInfo(name = "minimum_price") val minimum_price: Double,
    @ColumnInfo(name = "maximum_price") val maximum_price: Double,
    @ColumnInfo(name = "minimum_amount") val minimum_amount: Double,
    @ColumnInfo(name = "maximum_amount") val maximum_amount: Double,
    @ColumnInfo(name = "minimum_value") val minimum_value: Double,
    @ColumnInfo(name = "maximum_value") val maximum_value: Double,
    @ColumnInfo(name = "tick_size") val tick_size: Double,
    @ColumnInfo(name = "default_chart") val default_chart: String
)

fun CriptoEntity.mapToDomain() = Cripto(
    book = book,
    minimum_price = minimum_price,
    maximum_price = maximum_price,
    minimum_amount = minimum_amount,
    maximum_amount = maximum_amount,
    minimum_value = minimum_value,
    maximum_value = maximum_value,
    tick_size = tick_size,
    default_chart = default_chart,
    fees = null
)

fun List<CriptoEntity>.mapToDomain() = map { it.mapToDomain() }
