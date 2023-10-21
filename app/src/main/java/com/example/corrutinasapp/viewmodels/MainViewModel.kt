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
import java.lang.Exception
import kotlin.concurrent.thread

class MainViewModel: ViewModel() {
    var resultState by mutableStateOf("")
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
            "completed"
        }
        resultState = result
    }
    fun procesar(){
        Thread.sleep(5000)
        resultState="Completado"
    }
}