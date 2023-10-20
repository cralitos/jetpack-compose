package com.example.botonesdemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.botonesdemo.components.BotonIcono
import com.example.botonesdemo.components.BotonNormal
import com.example.botonesdemo.components.BotonNormal2
import com.example.botonesdemo.components.BotonOutline
import com.example.botonesdemo.components.BotonSwitch
import com.example.botonesdemo.components.BotonTexto
import com.example.botonesdemo.components.DarkMode
import com.example.botonesdemo.components.FloatingAction
import com.example.botonesdemo.components.Space
import com.example.botonesdemo.ui.theme.BotonesDemoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
//            se declara una constante la cual podra cambiar su valor
//            desde los componentes de la activity
            val darkMode = remember { mutableStateOf(false) }
//            a la funcion Theme le establecemos el atributo de tema oscuro,
//            relacionado a la constante declarada, la cual cambiara su valor
//            al presionar el boton
            BotonesDemoTheme(darkTheme = darkMode.value) {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
//                  se invoca a la funcion composable creada, la cual contiene
//                  todos los componentes creados en la clase Botones.kt
                    Content(darkMode)
                }
            }
        }
    }
}

//Creamos la funcion Content la cual invoca a cada una de las funciones composables
// del archivo Botones.kt, se envia como parametro un campo mutable booleano
@Composable
fun Content(darkMode: MutableState<Boolean>) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentSize(Alignment.Center),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        BotonNormal()
        Space()
        BotonNormal2()
        Space()
        BotonTexto()
        Space()
        BotonOutline()
        Space()
        BotonIcono()
        Space()
        BotonSwitch()
        Space()
//      al boton dark mode le enviamos como argumento el parametro recibido en la funcion
        DarkMode(darkMode = darkMode)
        Space()
        FloatingAction()
    }
}