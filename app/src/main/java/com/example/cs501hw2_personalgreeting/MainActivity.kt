package com.example.cs501hw2_personalgreeting

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cs501hw2_personalgreeting.ui.theme.Cs501hw2_personalGreetingTheme
import java.text.SimpleDateFormat
import java.util.Date
import java.time.LocalTime
import kotlin.random.Random



class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Cs501hw2_personalGreetingTheme {
                Scaffold( modifier = Modifier.fillMaxSize() ) {
                    Greeting()
                }
            }
        }
    }
}


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun Greeting() {
    var name by remember { mutableStateOf(" ") }
    var randomGreeting by remember { mutableStateOf("") }
    var timedGreeting by remember { mutableStateOf("")}

    Column(modifier = Modifier.fillMaxSize().padding(30.dp)){
        OutlinedTextField(
            value = name,
            onValueChange = {name = it},
            label = {Text("Enter your name")}
        )

        Button(

            onClick = {
            randomGreeting = "Hello, $name!"

            timedGreeting = getTimeOfDay()
        }
        ){
            Text("Generate Greetings")
        }
        Text(
            text = randomGreeting,
        )
        Text(
            text = timedGreeting,
        )

    }

}

@RequiresApi(Build.VERSION_CODES.O) // code from chatgpt
fun getTimeOfDay(): String {
    val greetings = listOf(
        "Hello!",
        "Hi there!",
        "Good day!",
        "Greetings!",
        "Hey!",
        "Howdy!",
        "Hi!",
        "What's up?",
        "Good to see you!",
        "Salutations!"
    )

    val randomIndex = Random.nextInt(greetings.size)

    val currentTime = LocalTime.now()

    return when {
        currentTime.isBefore(LocalTime.of(12, 0)) -> greetings[randomIndex] + " Good Morning."
        currentTime.isBefore(LocalTime.of(17, 0)) -> greetings[randomIndex] + " Good Afternoon."
        else -> greetings[randomIndex] + " Good Evening."
    }
}




@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Cs501hw2_personalGreetingTheme {
        Greeting()
    }
}