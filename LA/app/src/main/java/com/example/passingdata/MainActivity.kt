package com.example.passingdata

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.passingdata.ui.theme.PassingDataTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PassingDataTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = "a"){
                        composable(route = "a"){
                            Greeting{
                                navController.currentBackStackEntry?.savedStateHandle?.set("selected",it)
                                navController.navigate("b")
                            }
                        }
                        composable(route = "b"){
                            val selected = navController.previousBackStackEntry?.savedStateHandle?.get<String>("selected")
                            MainMenu(str = selected?:"")
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(callback:(String)->Unit) {
    Column(Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
        Button(onClick = { callback("Java") }) {
            Text(text = "Java")
        }
        Button(onClick = { callback("Python") }) {
            Text(text = "Python")
        }
        Button(onClick = { callback("C++") }) {
            Text(text = "C++")
        }
        Button(onClick = { callback("JS") }) {
            Text(text = "JavaScript")
        }
    }
}

@Composable
fun MainMenu(str:String){
    Column(verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "Language : $str")
        Spacer(modifier = Modifier.height(64.dp))
        if(str=="Java")  Image(painter = painterResource(id = R.drawable.java), contentDescription = "")
        if(str=="Python")  Image(painter = painterResource(id = R.drawable.python), contentDescription = "")
        if(str=="C++")  Image(painter = painterResource(id = R.drawable.c), contentDescription = "")
        if(str=="JS")  Image(painter = painterResource(id = R.drawable.js), contentDescription = "")
    }
}