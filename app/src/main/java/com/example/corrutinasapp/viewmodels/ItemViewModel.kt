package com.example.corrutinasapp.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.corrutinasapp.models.ItemModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.Exception

class ItemViewModel: ViewModel() {
    var itemList = mutableStateListOf(ItemModel())
        private set

    var isLoading by mutableStateOf(false)
        private set



    fun procesarCorrutina(){
        viewModelScope.launch {
            try{
                isLoading=true
                llamarApi()
            }catch (e: Exception){
                println(e.message)
            }finally {
                isLoading=false
            }
        }
    }

    //las funciones suspend solo pueden ser invocadas en corrutinas
    private suspend fun llamarApi(){
        val result = withContext(Dispatchers.IO){
            delay(5000)
            listOf(ItemModel(1,"elemento 1"),ItemModel(2,"elemento 2"),ItemModel(3,"elemento 3"),
                ItemModel(4,"elemento 4"),ItemModel(5,"elemento 5"),ItemModel(6,"elemento 6"),
                ItemModel(1,"elemento 1"),ItemModel(2,"elemento 2"),ItemModel(3,"elemento 3"),
                ItemModel(4,"elemento 4"),ItemModel(5,"elemento 5"),ItemModel(6,"elemento 6"),
                ItemModel(7,"elemento 7"),ItemModel(8,"elemento 8"),ItemModel(9,"elemento 9"),
                ItemModel(10,"elemento 10"),ItemModel(11,"elemento 11"),ItemModel(12,"elemento 12"),
                ItemModel(13,"elemento 13"),ItemModel(14,"elemento 14"),ItemModel(15,"elemento 15"),
                ItemModel(16,"elemento 16"),ItemModel(17,"elemento 17"),ItemModel(18,"elemento 18"),
                ItemModel(19,"elemento 19"),ItemModel(20,"elemento 20"),ItemModel(21,"elemento 21"),
                ItemModel(22,"elemento 22"),ItemModel(23,"elemento 23"),ItemModel(24,"elemento 24"),
                )
        }
        itemList.addAll(result)
    }
}