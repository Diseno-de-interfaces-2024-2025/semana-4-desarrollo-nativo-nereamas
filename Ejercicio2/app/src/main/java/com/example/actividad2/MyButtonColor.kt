package com.example.actividad2


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.actividad2.ui.theme.Actividad2Theme

class MyButtonColor : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Actividad2Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    CambiarBoton(
                        modifier = Modifier.padding(innerPadding),
                        colorFondo = Color.Cyan,
                    )
                }
            }
        }
    }
}

@Composable
fun CambiarBoton(colorFondo: Color, modifier: Modifier) {
    var pulsado by remember { mutableStateOf(false) }
    Button(
        onClick = {pulsado = !pulsado},
        colors = ButtonDefaults.buttonColors(
            containerColor = if (pulsado) colorFondo else Color.DarkGray
        ),
        border = BorderStroke(
            width = if (pulsado) 3.dp else 1.dp,
            color = Color.Black,
        ),
        shape = if (pulsado) RoundedCornerShape(4.dp) else RoundedCornerShape((16.dp)),
        modifier = modifier,
    ) {
        Text(
            text = if (pulsado) "Has cambiado el texto" else "pulsa aqui",
            color = if (pulsado) Color.Black else Color.White,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun CambiarBotongPreview1() {
    Actividad2Theme {
        CambiarBoton(
            colorFondo = Color.Cyan,
            modifier = Modifier,
        )
    }
}