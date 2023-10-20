package com.example.navegacion.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

//Este componentes lo utilizaremos para crear textos a los titulos de cada vista
//con las mismas propiedades
@Composable
fun TitleView(name: String){
    Text(text = name, fontSize = 40.sp, fontWeight = FontWeight.Bold, color = Color.Black)
}

//Creamos una funcion para crear spacers de un mismo tamaño
@Composable
fun Space(){
    Spacer(modifier = Modifier.height(10.dp))
}

//Creamos una funcion que nos proporcione un boton  para cada una de las vistas
//el parametro onClick de clase Unit: sirve para enviar funciones que se asignan
// de accion al boton al hacer click
@Composable
fun MainButton(name:String, backColor: Color, color: Color, onClick:() -> Unit){
    Button(onClick = onClick, colors = ButtonDefaults.buttonColors(
        contentColor = color,
        containerColor = backColor
    ) ) {
        Text(text = name)
    }
}




















