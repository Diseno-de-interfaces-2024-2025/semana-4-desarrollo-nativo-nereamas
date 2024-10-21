package com.example.prueba

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Preview(showBackground = true, backgroundColor = 0xFFFFFF)
@Composable
fun SuperGreeting(modifier: Modifier = Modifier){
    Greeting1("Example", modifier)
}
@Preview(showBackground = true, backgroundColor = 0xFFFFFF)
@Composable
fun SuperGreeting2(modifier: Modifier=Modifier){
    Greeting1("Example2", modifier)
}

@Composable
fun Greeting1(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}