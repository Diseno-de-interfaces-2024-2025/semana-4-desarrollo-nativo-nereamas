package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        modifier = Modifier.padding(innerPadding),
                    )
                }
            }
        }
    }
}
@Composable
fun Greeting(modifier: Modifier) {
    var textUsuario by remember { mutableStateOf("") }
    var textUsuarioBueno by remember { mutableStateOf("usuario") }
    var textContraseña by remember { mutableStateOf("") }
    var textContraseñaBuena by remember { mutableStateOf("usuario") }
    var mensajeResultado by remember { mutableStateOf("") }

    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){

        TextField(
            modifier = modifier.padding(1.dp),
            value = textUsuario,
            onValueChange = { textUsuario = it },
            label = { Text("Usuario") }
        )

        TextField(
            value = textContraseña,
            onValueChange = { textContraseña = it },
            label = { Text("Contraseña") }
        )

        Text(
            modifier = modifier.padding(0.2.dp),
            text = mensajeResultado ?: "",
            color = if (mensajeResultado == "Usuario Correcto") Color.Green else Color.Red
        )

        Button(
            onClick = {

                mensajeResultado = if (textUsuario == textUsuarioBueno && textContraseña == textContraseñaBuena) {
                    "Usuario Correcto"
                } else {
                    "Usuario Incorrecto"
                }
            },
        ) {
            Text(text = "Acceder")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyApplicationTheme {
        Greeting(Modifier)
    }
}