package com.example.interesesapp.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

//Creamos una funcion para mostrar informacion utilizando las tarjetas
@Composable
fun ShowInfoCards(titleInteres: String, montoInteres: Double, titleMonto: String, monto: Double){
    Row(modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        //utilizamos la funcion creada, enviando los paramametros para mostrar la informacion
        //del interes
        InfoCard(title = titleInteres, info = montoInteres,
            modifier = Modifier
                .padding(start = 30.dp)
                .weight(1f) //el peso sirve para asignar un tamaño relativo a otros componentes
        )
        //utilizamos la funcion creada, enviando los paramametros para mostrar la informacion
        //de las cuotas
        SpaceW(10.dp)
        InfoCard(title = titleMonto, info = monto,
            modifier = Modifier
                .padding(end = 30.dp)
                .weight(1f)//el peso sirve para asignar un tamaño relativo a otros componentes
        )
    }
}

//creamos una tarjeta para mostrar informacion en la tarjeta
@Composable
fun InfoCard(title: String, info: Double, modifier: Modifier = Modifier){
    //Las tarjetas sirven para mostrar contenido relacionado a un tema
    // y hacer enfasis en dicha informacion
    Card(
        modifier = modifier,
        colors = CardDefaults.cardColors(
            containerColor = Color.LightGray
        )
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(16.dp)
        ) {
            Text(text = title, color = Color.Black, fontSize = 20.sp)
            Text(text = "|Q$info", color = Color.Black, fontSize = 20.sp)
        }
    }
}
