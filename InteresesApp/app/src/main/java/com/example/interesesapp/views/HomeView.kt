package com.example.interesesapp.views


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.interesesapp.components.Alert
import com.example.interesesapp.components.MainButton
import com.example.interesesapp.components.MainTextField
import com.example.interesesapp.components.ShowInfoCards
import com.example.interesesapp.components.SpaceH
import java.math.BigDecimal
import java.math.RoundingMode


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeView() {
    Scaffold(topBar = {
        CenterAlignedTopAppBar(
            //ponemos un titulo a nuestra topBar
            title = { Text(text = "Calculadora Prestamos", color = Color.White) },
            colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                containerColor = MaterialTheme.colorScheme.primary
            )
        )
    }) {

        ContentHomeView(it)
    }
}

@Composable
fun ContentHomeView(paddingValues: PaddingValues) {
    Column(
        modifier = Modifier
            .padding(paddingValues)
            .padding(10.dp)
            .fillMaxSize(),
        //verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        //declaramos las variables con la que haremos el calculo
        //recuerda que mutableStateOf sirve para manejar el estado
        // de las variables en tiempo de ejecucion
        var montoPrestamo by remember { mutableStateOf("") }
        var cantCuotas by remember { mutableStateOf("") }
        var tasa by remember { mutableStateOf("") }
        var montoInteres by remember { mutableStateOf(0.0) }
        var montoCuota by remember { mutableStateOf(0.0) }
        //esta variable sera usada para mostrar un mensaje de alerta
        var showAlert by remember { mutableStateOf(false) }

        //invocamos la funcion para incluir las card con la informacion
        ShowInfoCards(
            titleInteres = "Total:",
            montoInteres = montoInteres,
            titleMonto = "Cuota:",
            monto = montoCuota
        )

        //declaramos los campos de texto con los que ingresaremos la informacion
        //la variable "it" es como se declara por defecto el valor capturado por el textField
        MainTextField(value = montoPrestamo, onValueChange = { montoPrestamo = it }, label = "Prestamo")
        SpaceH()
        MainTextField(value = cantCuotas, onValueChange = { cantCuotas = it }, label = "Cuotas")
        SpaceH(10.dp)
        MainTextField(value = tasa, onValueChange = { tasa = it }, label = "Tasa")
        SpaceH(10.dp)
        //Creamos un boton para realizar los calculos
        MainButton(text = "Calcular") {
            //validamos que los campos no esten vacios
            if(montoPrestamo != "" && cantCuotas != ""){
                //invocamos la funcion creada para calcular el total a pagar
                montoInteres = calcularTotal(montoPrestamo.toDouble(), cantCuotas.toInt(), tasa.toDouble())

                montoCuota = calcularCuota(montoPrestamo.toDouble(), cantCuotas.toInt(), tasa.toDouble() )
            }else{//si los campos estan vacios cambiamos nuestra bandera
                // para mostrar el mensaje de alerta
                showAlert = true
            }
        }
        SpaceH()

        //Agregamos un campo para limpiar los campos
        MainButton(text = "Limpiar", color = Color.Red) {
            montoPrestamo = ""
            cantCuotas = ""
            tasa = ""
            montoInteres = 0.0
            montoCuota = 0.0
        }

        //mostramos el mensaje de alerta si la bandera es verdadera
        if (showAlert){
            Alert(title = "Alerta",
                message = "Ingresa los datos",
                confirmText = "Aceptar",
                //Al hacer click en aceptar, cambiamos el valor de la bandera
                onConfirmClick = { showAlert = false }) { }
        }

    }
}

fun calcularTotal(montoPrestamo:Double, cantCuotas:Int, tasaInteresAnual: Double): Double{
    val res = cantCuotas * calcularCuota(montoPrestamo, cantCuotas,tasaInteresAnual )
    return BigDecimal(res).setScale(2, RoundingMode.HALF_UP).toDouble()
}

fun calcularCuota(montoPrestamo:Double, cantCuotas:Int, tasaInteresAnual: Double): Double {

    // Convierte la tasa de interés anual a tasa periódica mensual
    val tasaInteresMensual = tasaInteresAnual / 12 / 100

    // Calcula la cuota nivelada utilizando la fórmula
    val cuota = montoPrestamo * tasaInteresMensual * Math.pow(1 + tasaInteresMensual, cantCuotas.toDouble()) /
            (Math.pow(1 + tasaInteresMensual, cantCuotas.toDouble()) - 1)
// Redondea el resultado a 2 decimales utilizando BigDecimal
    val cuotaRedondeada = BigDecimal(cuota).setScale(2, RoundingMode.HALF_UP).toDouble()

    return cuotaRedondeada
    return cuota
}


