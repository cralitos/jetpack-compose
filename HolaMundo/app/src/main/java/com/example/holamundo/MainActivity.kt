package com.example.holamundo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Content()
        }
    }
}

/*
Modificadores
De posicionamiento = width, height
de funcionalidad = click, scroll
de apariencia = background, padding, border
de escucha = onKeyEvent
* */
val items = listOf(
    Color.Red,
    Color.Yellow,
    Color.Black,
    Color.Cyan,
    Color.DarkGray,
    Color.Magenta,
    Color.Green
)
val nombre = "Me Gusta"

@Preview(showBackground = true)
@Composable
fun Content() {
    var likes by remember { mutableStateOf(0) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center)
            .padding(horizontal = 5.dp)
    ) {
        Texto(texto = "Bienvenido")
        Space()
        Texto(texto = "Jetpack")
        Space()
        Texto(texto = "Compose")
        Space()
        LazyRow(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            items(items){ item ->
                Circulo(color = item)
                Spacer(modifier = Modifier.width(10.dp))
            }
        }
        Space()
        Row(modifier = Modifier
            .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(onClick = {
                likes++
            }) {
                Text(text = nombre)
            }
            Spacer(modifier = Modifier.width(10.dp))
            Resultado(likes = likes)
        }
    }

}
@Composable
fun Resultado(likes: Int){
    Text(text = likes.toString(), fontWeight = FontWeight.Bold, fontSize = 50.sp)
}

@Composable
fun Texto(texto: String) {
    Text(
        text = texto,
        color = Color.Red,
        fontWeight = FontWeight.Bold,
        fontSize = 40.sp,
        textAlign = TextAlign.Center,
        modifier = Modifier
            .background(Color.Black)
            .padding(horizontal = 30.dp)
            .fillMaxWidth()
            .clickable {
                println("Hola Jetpack")
            }
    )
}

@Composable
fun Circulo(color: Color) {
    Box(
        modifier = Modifier
            .size(70.dp)
            .background(color, CircleShape)
    )

}

@Composable
fun Space() {
    Spacer(modifier = Modifier.height(5.dp))
}


