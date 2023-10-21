package com.example.corrutinasapp.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.concurrent.thread

class MainViewModel: ViewModel() {
    var resultState by mutableStateOf("")

    fun procesarCorrutina(){
        viewModelScope.launch {
            val result = withContext(Dispatchers.IO){
                delay(5000)
                "completed"
            }
            resultState = result
        }
    }
    fun procesar(){
        Thread.sleep(5000)
        resultState="Completado"
    }
}