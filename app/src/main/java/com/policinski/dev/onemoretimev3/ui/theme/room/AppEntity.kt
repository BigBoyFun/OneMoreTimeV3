package com.policinski.dev.onemoretimev3.ui.theme.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "product")
data class ProductEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "favorite") val favorite: Boolean,
    @ColumnInfo(name = "weight") val weight: Double,
    @ColumnInfo(name = "kcal") val kcal: Double,
    @ColumnInfo(name = "pro") val pro: Double,
    @ColumnInfo(name = "fat") val fat: Double,
    @ColumnInfo(name = "car") val car: Double
)