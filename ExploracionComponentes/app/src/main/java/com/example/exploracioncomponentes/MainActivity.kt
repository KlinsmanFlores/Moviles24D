package com.example.exploracioncomponentes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.exploracioncomponentes.ui.theme.ExploracionComponentesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ExploracionComponentesTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    // Cambia aquí el componente que quieras probar
                    ComponentSelector() // Para ver todos
                    // O cambia por:
                    // MiScaffold()     // Solo Scaffold
                    // MiLazyColumn()   // Solo LazyColumn
                    // MiAlertDialog()  // Solo Dialog
                }
            }
        }
    }
}
