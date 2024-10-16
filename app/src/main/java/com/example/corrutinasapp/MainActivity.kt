package com.example.corrutinasapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.corrutinasapp.ui.theme.CorrutinasAppTheme
import com.example.corrutinasapp.viewmodels.ItemViewModel
import com.example.corrutinasapp.viewmodels.MainViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel : ItemViewModel by viewModels()
        setContent {
            CorrutinasAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    itemsView(viewModel)
                }
            }
        }
    }
}

@Composable
fun Content(viewModel: MainViewModel) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        BotonColor()
        if(viewModel.isLoading){
            CircularProgressIndicator()
        }else{
            Text(text = viewModel.resultState)
        }
        Button(onClick = { viewModel.procesarCorrutina() }) {
            Text(text = "Proceso")
        }
    }
}

@Composable
fun BotonColor() {
    var color by remember {
        mutableStateOf(false)
    }

    Button(
        onClick = { color = !color },
        colors = ButtonDefaults.buttonColors(
            containerColor = if (color) Color.Blue else Color.Red
        )
    ) {
        Text(text = "Click")
    }
}

@Composable
fun itemsView(viewModel: ItemViewModel){
//    se invoca al viewModel usando el by
    val itemList by viewModel.lista.collectAsState()
    //invocar procesos en corrutina al lanzar la aplicacion
    LaunchedEffect(Unit){
        viewModel.procesarCorrutina()
    }
    Column {
        if(viewModel.isLoading){
                CircularProgressIndicator()
        }else{
            LazyColumn{
                items(itemList){
                    Text(text = it.name)
                }
            }
        }
    }
}