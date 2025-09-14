package com.example.moviecounter

import android.R.attr.text
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.moviecounter.ui.theme.MovieCounterTheme
import androidx.compose.material3.Button
import androidx.compose.ui.Alignment
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.material3.Card
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.material3.TextField
import androidx.compose.runtime.saveable.rememberSaveable

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PreviewProductCounter()
        }
    }
}

@Composable
fun ProductCounter(modifier: Modifier = Modifier) {
    var quantity by rememberSaveable { mutableStateOf(0) }
    var comment by remember { mutableStateOf("") }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Producto: Laptop Gaming")
        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Cantidad: $quantity")
        Spacer(modifier = Modifier.height(16.dp))

        TextField(
            value = comment,
            onValueChange = { comment = it },
            label = { Text("Comentario") }
        )
        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = { quantity++ }) {
            Text("Agregar al carrito")
        }

        Button(onClick = { /* acción del nuevo botón */ }) {
            Text(text = "Comprar")
        }

        TextField(value = "", onValueChange = {}, label = { Text("Buscar producto") })

        Card(modifier = Modifier.padding(8.dp)) {
            Text("de nuevo apra el commit para el labo4")
        }

    }
}

@Preview(showBackground = true)
@Composable
fun PreviewProductCounter() {
    ProductCounter()
}


@Composable
fun MovieCounter (modifier: Modifier = Modifier) {
    var count by rememberSaveable { mutableStateOf(0) }
    var movieName by rememberSaveable { mutableStateOf("") }
    Column (
        modifier = modifier.padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "you have added $count movies")
        Spacer(modifier = Modifier.height(16.dp))
        TextField(value = movieName, onValueChange = { movieName = it }, label = { Text("Movie name") })
        Button(onClick = {
            if (movieName.isNotEmpty()) {
                count++
                movieName= ""
            }
        }) {
            Text(text = "Add movie")
        }

    }
}

@Composable
fun PreviewMovieCounter() {
    MovieCounter()
}