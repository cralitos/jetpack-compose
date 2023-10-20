package com.example.navegacion.views

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.example.navegacion.components.ActionButton
import com.example.navegacion.components.MainButton
import com.example.navegacion.components.Space
import com.example.navegacion.components.TitleBar
import com.example.navegacion.components.TitleView

//esta funcion genera los elementos necesarios para crear una pantalla
// recibe como argumento un NavController el cual administra la
// navegacion entre pantallas
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeView(navController: NavController) {
    //Scaffold es un componente provee una estructura para agrupar varios
    // componentes material y construir tu pantalla
    Scaffold(
        //agrega una barra de navegacion en la parte superior de la pantalla
        topBar = {
            CenterAlignedTopAppBar(
                title = { TitleBar(name = "Home View") },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = Color.Red
                )
            )
        },
        //agrega un boton flotante en la pantalla
        floatingActionButton = {
            ActionButton()
        }
    ) {
        //agrega los componentes que nuestra funcion ContentHomeView nos provee
        ContentHomeView(navController)
    }
}

//esta funcion organizara los elementos que conforman nuestra pantalla
// recibe como argumento el navController el cual servira para navegar
// de una pantalla a otra con un click de boton
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ContentHomeView(navController: NavController) {
    //declaramos dos variables la cual enviaremos de una vista a otra
    val id = 123
    var opcional by remember { mutableStateOf("") }
    //ogranizamos nuestros componentes en una columna
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TitleView(name = "Home View")
        Space()
        //Campo de texto para capturar datos del por medio del teclado
        TextField(
            value = opcional,
            onValueChange = { opcional = it },
            label = { Text(text = "Opcional") }
        )
        MainButton(name = "Detail view", backColor = Color.Red, color = Color.White) {
            //esta accion navega de esta pantalla hacia la pantalla de detalles,
            //enviando los valores de id y opcional
            navController.navigate("Detail/${id}/?${opcional}")
        }
    }
}