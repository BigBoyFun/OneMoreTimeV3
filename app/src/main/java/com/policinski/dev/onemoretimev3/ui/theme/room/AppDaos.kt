package com.policinski.dev.onemoretimev3.ui.theme.room

import androidx.compose.runtime.MutableState
import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface AppDaos {
    @Query("SELECT * FROM product")
    fun getAllData(): List<ProductEntity>

    @Insert
    suspend fun addNewProduct(product: ProductEntity)

    @Query("DELETE FROM product")
    suspend fun clearData()
}