package com.example.ejercicio4

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.expandHorizontally
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontVariation.weight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ejercicio4.ui.theme.Ejercicio4Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Ejercicio4Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(modifier: Modifier = Modifier) {
    var textNombre by remember { mutableStateOf("") }
    var textEmail by remember { mutableStateOf("") }
    var textDireccion by remember { mutableStateOf("") }
    var textPais by remember { mutableStateOf("") }

    var updatedNombre by remember { mutableStateOf("") }
    var updatedEmail by remember { mutableStateOf("") }
    var updatedDireccion by remember { mutableStateOf("") }
    var updatedPais by remember { mutableStateOf("") }

    Column(modifier = modifier.fillMaxSize().verticalScroll(rememberScrollState()))  {
        Box(
            Modifier
                .fillMaxWidth()
                .background(Color.Blue),
            contentAlignment = Alignment.Center,
        ) {
            Text(
                text = "Screen",
                color = Color.White,
                textAlign = TextAlign.Center,
                fontSize = 30.sp,
                modifier = modifier.padding(1.dp),
            )
        }

        Box(
            Modifier
                .fillMaxWidth()
                .background(Color.Gray),
        ) {
            LazyRow(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(10.dp),
                contentPadding = PaddingValues(vertical = 5.dp, horizontal = 1.dp)
            ) {
                items(10) {
                    Box(
                        modifier = Modifier
                            .clip(shape = CircleShape)
                            .background(color = Color.DarkGray)
                            .size(60.dp)
                    )
                }
            }
        }

        Row(
            modifier = Modifier.padding(horizontal = 27.dp, vertical = 27.dp),
            horizontalArrangement = Arrangement.spacedBy(20.dp),
        ) {
            Box(
                Modifier
                    .clip(shape = RoundedCornerShape(10.dp))
                    .height(200.dp)
                    .width(170.dp)
                    .background(color = Color.Cyan)
            )
            Box(
                Modifier
                    .height(200.dp)
                    .verticalScroll(rememberScrollState())
            ) {
                Text(
                    text = "Lorem ipsum dolor sit amet consectetur adipiscing elit Lorem ipsum dolor sit amet consectetur adipiscing elit Lorem ipsum dolor sit amet consectetur adipiscing elit Lorem ipsum dolor sit amet consectetur adipiscing elit Lorem ipsum dolor sit amet consectetur adipiscing elit Lorem ipsum dolor sit amet consectetur adipiscing elit Lorem ipsum dolor sit amet consectetur adipiscing elit Lorem ipsum dolor sit amet consectetur adipiscing elit Lorem ipsum dolor sit amet consectetur adipiscing elit Lorem ipsum dolor sit amet consectetur adipiscing elit "
                )
            }
        }

        Box(
            Modifier
                .fillMaxWidth(),
            contentAlignment = Alignment.Center,
        ) {
            Text(
                text = "Formulario",
                textAlign = TextAlign.Center,
                fontSize = 40.sp,
            )
        }

        Row(
            modifier = Modifier.padding(horizontal = 27.dp, vertical = 27.dp),
            horizontalArrangement = Arrangement.spacedBy(20.dp),
        ) {
            Column(
                Modifier.padding(1.dp).weight(1f)

            ) {
                TextField(
                    value = textNombre,
                    onValueChange = { textNombre = it },
                    label = { Text("Nombre") },
                )
                TextField(
                    value = textEmail,
                    onValueChange = { textEmail = it },
                    label = { Text("Email") }
                )
                TextField(
                    value = textDireccion,
                    onValueChange = { textDireccion = it },
                    label = { Text("Dirección") }
                )
                TextField(
                    value = textPais,
                    onValueChange = { textPais = it },
                    label = { Text("País") }
                )
            }

            Column( Modifier.weight(1f).padding(1.dp)) {
                Text(
                    text = updatedNombre,
                    modifier = Modifier.padding(15.dp)
                )
                Text(
                    text = updatedEmail,
                    modifier = Modifier.padding(15.dp)
                )
                Text(
                    text = updatedDireccion,
                    modifier = Modifier.padding(15.dp)
                )
                Text(
                    text = updatedPais,
                    modifier = Modifier.padding(15.dp)
                )
            }
        }

        Box(
            Modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            Button(onClick = {
                updatedNombre = textNombre
                updatedEmail = textEmail
                updatedDireccion = textDireccion
                updatedPais = textPais
            }) {
                Text(text = "Actualizar")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Ejercicio4Theme {
        Greeting()
    }
}