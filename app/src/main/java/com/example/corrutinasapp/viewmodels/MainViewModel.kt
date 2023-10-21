package com.example.corrutinasapp.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import kotlin.concurrent.thread

class MainViewModel: ViewModel() {
    var resultState by mutableStateOf("")

    fun procesar(){
        Thread.sleep(5000)
        resultState="Completado"
    }
}