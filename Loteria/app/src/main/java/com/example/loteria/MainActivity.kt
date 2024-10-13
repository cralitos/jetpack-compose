package com.example.loteria

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.loteria.ui.theme.LoteriaTheme
import com.example.loteria.viewModels.ContadorViewModel
import com.example.loteria.viewModels.LoteriaViewModel
import com.example.loteria.views.Contador
import com.example.loteria.views.LoteriaView

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //val viewModel : ContadorViewModel by viewModels()
        val viewModel : LoteriaViewModel by viewModels()
        setContent {
            LoteriaTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                   // Contador(viewModel = viewModel)
                    LoteriaView(viewModel = viewModel)
                }
            }
        }
    }
}

