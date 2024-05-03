package com.example.openurl

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.example.openurl.ui.theme.OpenURLTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            OpenURLTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting()
                }
            }
        }
    }
}

@Composable
fun Greeting() {
    val ytb = "https://www.java.com"
    val google = "https://www.python.org"
    val cpp = "https://www.cplusplus.com"
    val context = LocalContext.current

    val yIntent = remember{Intent(Intent.ACTION_VIEW, Uri.parse(ytb))}
    val gIntent = remember{Intent(Intent.ACTION_VIEW, Uri.parse(google))}
    val cIntent = remember{Intent(Intent.ACTION_VIEW, Uri.parse(cpp))}

    Column(Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
        Button(onClick = { context.startActivity(yIntent) }) {
            Text(text = "Java")
        }
        Button(onClick = { context.startActivity(gIntent) }) {
            Text(text = "Python")
        }
        Button(onClick = { context.startActivity(cIntent) }) {
            Text(text = "C++")
        }
    }
}
