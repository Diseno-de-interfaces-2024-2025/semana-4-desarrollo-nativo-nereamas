package com.example.ejercicio1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.example.ejercicio1.ui.theme.Ejercicio1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Ejercicio1Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MyText(
                        name = "Android",
                        color = Color.Red,
                        textSize = 16.sp ,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun MyText(name: String, color: Color, textSize: TextUnit, modifier: Modifier = Modifier) {
    Text(
        text = name,
        color = color,
        fontSize = textSize,
        modifier = modifier
    )
}

@Preview()
@Composable
fun GreetingPreview() {
    Ejercicio1Theme {
        MyText(
            name = "Android",
            color = Color.Black,
            textSize = 16.sp,
            modifier = Modifier
        )
    }
}
@Preview()
@Composable
fun GreetingPreview2() {
    Ejercicio1Theme {
        MyText(
            name = "Android",
            color = Color.Red,
            textSize = 10.sp,
            modifier = Modifier
        )
    }
}

@Preview()
@Composable
fun GreetingPreview3() {
    Ejercicio1Theme {
        MyText(
            name = "Android",
            color = Color.Blue,
            textSize = 19.sp,
            modifier = Modifier
        )
    }
}