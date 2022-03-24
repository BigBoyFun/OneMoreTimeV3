package com.policinski.dev.onemoretimev3.ui.theme.room

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData

class AppRepository(private val appDao: AppDaos){

    val readAllData: MutableState<List<ProductEntity>> = mutableStateOf(appDao.getAllData())

    suspend fun addNewProduct(product: ProductEntity){
        appDao.addNewProduct(product)
    }

    suspend fun clearDataBase(){
        appDao.clearData()
    }
}