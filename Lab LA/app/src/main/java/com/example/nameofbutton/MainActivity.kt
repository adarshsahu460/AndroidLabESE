package com.example.nameofbutton

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.nameofbutton.ui.theme.NameOfButtonTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NameOfButtonTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column(verticalArrangement = Arrangement.SpaceBetween) {
                        Row(horizontalArrangement = Arrangement.SpaceBetween) {
                            Box(Modifier.weight(1f)){
                                Button(onClick = { /*TODO*/ }) {
                                    Text(text = "Button 1")
                                }
                            }
                                Button(onClick = { /*TODO*/ }) {
                                    Text(text = "Button 2")
                                }
                        }
                        Row(horizontalArrangement = Arrangement.SpaceBetween) {
                            Box(Modifier.weight(1f)){
                                Button(onClick = { /*TODO*/ }) {
                                    Text(text = "Button 1")
                                }
                            }
                            Box(Modifier.weight(1f)){
                                Button(onClick = { /*TODO*/ }) {
                                    Text(text = "Button 2")
                                }
                            }
                            Button(onClick = { /*TODO*/ }) {
                                Text(text = "Button 2")
                            }
                        }
                        Row(horizontalArrangement = Arrangement.SpaceBetween) {
                            Box(Modifier.weight(1f)){
                                Button(onClick = { /*TODO*/ }) {
                                    Text(text = "Button 1")
                                }
                            }
                            Button(onClick = { /*TODO*/ }) {
                                Text(text = "Button 2")
                            }
                        }
                    }
                }
            }
        }
    }
}
