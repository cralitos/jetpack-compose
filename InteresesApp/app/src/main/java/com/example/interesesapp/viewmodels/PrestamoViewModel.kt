package com.example.interesesapp.viewmodels

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.interesesapp.models.PrestamoState
import java.math.BigDecimal
import java.math.RoundingMode

//las clases viewmodel heredan el constructor viewModel
//para que android maneje el ciclo de vida del viewModel
class PrestamoViewModel : ViewModel() {

    //se declara una variable PrestamoState mutable, ya que sus valores
    //se muestran en la vista
    var state by mutableStateOf(PrestamoState())
        private set

    //con esta funcion cambiaremos el campo showalert el cual controla el cuadro de dialogo
    //luego asignaremos esta funcion al boton de confirmacion del dialogo
    fun confirmDialog(){
        //copiamos el estado para cambiar el campo alert
        state = state.copy(showAlert = false)
    }

    fun limpiar(){
        //para modificar el valor del estado es necesario invocar a la funcion copy
        state = state.copy(
            montoPrestamo = "",
            cantCuotas = "",
            tasa = "",
            montoInteres = 0.0,
            montoCuota = 0.0
        )
    }


    //creamos una funcion para cambiar los valores desde la vista
    //esta funcion se asignara a cada campo de texto de la vista
    fun onValue(value: String, campo: String) {
        Log.i("chdez", campo)
        Log.i("chdez",value)
        //When es una estructura condicional similiar al switch - case
        when (campo) {
            //los campos del state son constantes, por lo que para cambiar
            //dicho valor es necesario utilizar el metodo copy
            "montoPrestamo" -> state = state.copy(montoPrestamo = value)
            "cuotas" -> state = state.copy(cantCuotas = value)
            "tasa" -> state = state.copy(tasa = value)
        }
    }

    //funcion para calcuar el total
    private fun calcularTotal(
        montoPrestamo: Double,         cantCuotas: Int,        tasaInteresAnual: Double
    ): Double {
        val res = cantCuotas * calcularCuota(montoPrestamo, cantCuotas, tasaInteresAnual)
        return BigDecimal(res).setScale(2, RoundingMode.HALF_UP).toDouble()
    }

    //funcion para calcular las cuotas
    private fun calcularCuota(
        montoPrestamo: Double,         cantCuotas: Int,        tasaInteresAnual: Double
    ): Double {

        val tasaInteresMensual = tasaInteresAnual / 12 / 100

        val cuota = montoPrestamo * tasaInteresMensual * Math.pow(
            1 + tasaInteresMensual,
            cantCuotas.toDouble()
        ) / (Math.pow(1 + tasaInteresMensual, cantCuotas.toDouble()) - 1)

        val cuotaRedondeada = BigDecimal(cuota).setScale(2, RoundingMode.HALF_UP).toDouble()

        return cuotaRedondeada
    }


    fun calcular(){
        //declaramos cada variable asociada al estado
        val montoPrestamo = state.montoPrestamo
        val cantCuotas = state.cantCuotas
        val tasa = state.tasa
        if (montoPrestamo!="" && cantCuotas!="" && tasa!= ""){
            //para modificar el estado del modelo se requiere utilizar el metodo copy
            state = state.copy(
                montoCuota = calcularCuota(montoPrestamo.toDouble(), cantCuotas.toInt(), tasa.toDouble()),
                montoInteres = calcularTotal(montoPrestamo.toDouble(), cantCuotas.toInt(), tasa.toDouble())
            )
        }else{
            state = state.copy(showAlert = true)
        }
    }
}