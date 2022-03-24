package com.policinski.dev.onemoretimev3.ui.theme.room

import android.app.Application
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AppViewModel(application: Application): AndroidViewModel(application) {

    var allData: MutableState<List<ProductEntity>> = mutableStateOf(listOf())
    private val repository: AppRepository

    init {
        val appDao = AppDataBase.getDataBase(application).productDao()
        repository = AppRepository(appDao)
        allData = repository.readAllData
    }

    fun addNewProduct(product: ProductEntity) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addNewProduct(product)
        }
    }

    fun clearDataBase(){
        viewModelScope.launch(Dispatchers.IO) {
            repository.clearDataBase()
        }
    }
}