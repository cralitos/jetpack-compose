package com.example.navegacion.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.sp

//Funcion que nos proveera un componente para agregar
// titulos a las barras de navegacion
@Composable
fun TitleBar(name: String) {
    Text(text = name, fontSize = 25.sp, color = Color.White)
}

//Esta funcion nos proveera un boton flotante para agregar
// en el scafold de nuestra vista
@Composable
fun ActionButton() {
    FloatingActionButton(
        onClick = { /*TODO*/ },
        containerColor = Color.Red,
        contentColor = Color.White
    ) {
        Icon(
            //con esta propiedad podemos asignar un icono al boton
            imageVector = Icons.Default.Add,
            contentDescription = "Agregar"
        )
    }
}

//con esta funcion agregaremos un boton de icono en el scafold de la vista
//el parametro onClick de clase Unit nos posibilita enviar funciones que
// se pueden asignar al boton
@Composable
fun MainIconButton(icon: ImageVector, onClick:() -> Unit){
    IconButton(onClick = onClick) {
        Icon(imageVector = icon, contentDescription = null, tint = Color.White)
    }
}








