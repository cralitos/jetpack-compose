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
import androidx.lifecycle.ViewModel
import com.example.interesesapp.components.Alert
import com.example.interesesapp.components.MainButton
import com.example.interesesapp.components.MainTextField
import com.example.interesesapp.components.ShowInfoCards
import com.example.interesesapp.components.SpaceH
import com.example.interesesapp.viewmodels.PrestamoViewModel
import java.math.BigDecimal
import java.math.RoundingMode


@OptIn(ExperimentalMaterial3Api::class)
@Composable
//agregamos el viewModel al constructor de la vista
fun HomeView(viewModel: PrestamoViewModel) {
    Scaffold(topBar = {
        CenterAlignedTopAppBar(
            //ponemos un titulo a nuestra topBar
            title = { Text(text = "Calculadora Prestamos", color = Color.White) },
            colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                containerColor = MaterialTheme.colorScheme.primary
            )
        )
    }) {
//enviamos el viewModel a la funcion de contenido para que
// pueda utilizar la logica del viewmodel
        ContentHomeView(it, viewModel)
    }
}

@Composable
//agregamos el viewModel a la funcion que construye la vista
fun ContentHomeView(paddingValues: PaddingValues, viewModel: PrestamoViewModel) {
    Column(
        modifier = Modifier
            .padding(paddingValues)
            .padding(10.dp)
            .fillMaxSize(),
        //verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        //obtenemos el estado del modelo que declaramos en el viewmodel
        val state = viewModel.state
        //invocamos la funcion para incluir las card con la informacion
        ShowInfoCards(
            titleInteres = "Total:",
            //la informacion a mostrar en los card esta contenida en el model
            montoInteres = state.montoInteres,
            titleMonto = "Cuota:",
            monto = state.montoCuota
        )

        MainTextField(value = state.montoPrestamo,
            //invocamos la funcion onValue declarada en el viewModel
            onValueChange = { viewModel.onValue(value = it, campo ="montoPrestamo") }, label = "Prestamo")
        SpaceH()
        MainTextField(value = state.cantCuotas,
            onValueChange = { viewModel.onValue(value = it, campo ="cuotas") }, label = "Cuotas")
        SpaceH(10.dp)
        MainTextField(value = state.tasa,
            onValueChange = { viewModel.onValue(value = it, campo ="tasa") }, label = "Tasa")
        SpaceH(10.dp)

        //Creamos un boton para realizar los calculos
        MainButton(text = "Calcular") {
            //invocamos la funcion calcular definida en el viewmodel
            viewModel.calcular()
        }
        SpaceH()

        //Agregamos un campo para limpiar los campos
        MainButton(text = "Limpiar", color = Color.Red) {
//            se invoca la funcion declarada en el view model
            viewModel.limpiar()
        }

        //mostramos el mensaje de alerta si la bandera es verdadera
        //tomamos el valor del model a traves del viewmodel
        if (viewModel.state.showAlert){
            Alert(title = "Alerta",
                message = "Ingresa los datos",
                confirmText = "Aceptar",
                //Al hacer click en aceptar, invoca la funcion del viewModel
                onConfirmClick = { viewModel.confirmDialog() }) { }
        }

    }
}

