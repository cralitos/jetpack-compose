package com.example.botonesdemo.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun BotonNormal() {
    //la propiedad enabled habilita o deshabilita el boton
    Button(onClick = { /*TODO*/ }, enabled = false) {
        Text(text = "Mi Boton", fontSize = 30.sp)
    }
}

@Composable
fun BotonNormal2() {
    Button(
        //la clase ButtonDefaults cambia las propiedades de color del boton
        onClick = { /*TODO*/ }, colors = ButtonDefaults.buttonColors(
            //container color le cambia el color de fondo al boton
            containerColor = Color.Red
        )
    ) {
        Text(text = "Mi Boton", fontSize = 30.sp)
    }
}

@Composable
fun BotonTexto() {
//    la clase TextButon crea un texto con funcionalidad de boton
    TextButton(onClick = { /*TODO*/ }) {
        Text(text = "Mi Boton", fontSize = 30.sp)
    }
}

@Composable
fun BotonOutline() {
//    la clase OutlineButton creará un boton remarcado por un borde y sin relleno
    OutlinedButton(onClick = { /*TODO*/ }, border = BorderStroke(3.dp, Color.Blue)) {
        Text(text = "Mi Boton", fontSize = 30.sp)
    }
}

@Composable
fun BotonIcono() {
//    la clase IconButton nos provee un icono con funciones de boton
    IconButton(onClick = { /*TODO*/ }) {
        Icon(
//            La clase Icons contiene un conjunto de iconos por defecto
//            en este ejemplo utilizamos el icono de Home
            Icons.Filled.Home,
            contentDescription = "Icono",
//            el atributo tint cambia el color del icono utilizado
            tint = Color.Red,
//            La clase modifier nos provee las funcionalidades de cambiar la
//            apariencia de nuestros componentes
            modifier = Modifier.size(50.dp)
        )
    }
}

@Composable
fun BotonSwitch() {
//    mutableStateOf es el manejador de estado de las variables en tiempo de ejecucion
//    se utiliza en conjunto con remember para manipular el estado de las variables
    var switched by remember { mutableStateOf(false) }
    Switch(
//        se establece el valor de checker y onCheckedChange relacionado con la variable declarada
        checked = switched, onCheckedChange = { switched = it },
        colors = SwitchDefaults.colors(
//            se modifica el color del switch cuando esta checkado
            checkedThumbColor = Color.Red,
//            modifica el valor de fondo del switch cuando esta checkado
            checkedTrackColor = Color.Green,
            //            se modifica el color del switch cuando esta checkado
            uncheckedThumbColor = Color.Blue,
//            modifica el valor de fondo del switch cuando no esta checkado
            uncheckedTrackColor = Color.Magenta
        )
    )
}

//este boton recibe como parametro  darkMode
// que será modificado en tiempo de ejecucion
@Composable
fun DarkMode(darkMode: MutableState<Boolean>) {
//    al presionar el boton se le cambia de valor al parametro darkMode
    Button(onClick = { darkMode.value = !darkMode.value }) {
//    Los botones pueden contener iconos y texto al mismo tiempo
        Icon(imageVector = Icons.Default.Star, contentDescription = "DarkMode")
//    se agrega un Spacer para separar el icono del texto
        Spacer(modifier = Modifier.width(5.dp))
//    texto del boton
        Text(text = "Dark Mode", fontSize = 30.sp)
    }
}

//Boton Flotante
@Composable
fun FloatingAction() {
    FloatingActionButton(
        onClick = { /*TODO*/ },
//        cambia el color del fondo del boton
        containerColor = Color.Blue,
//        cambia el color del contenido
        contentColor = Color.White
    ) {
        Icon(
//         se agrega el icono de Add contenido en los iconos por defecto
            Icons.Filled.Add,
            contentDescription = "",
//         Modifier cambia el tamaño del icono
            modifier = Modifier.size(30.dp)
        )
    }
}

@Composable
fun Space() {
    Spacer(modifier = Modifier.height(10.dp))
}