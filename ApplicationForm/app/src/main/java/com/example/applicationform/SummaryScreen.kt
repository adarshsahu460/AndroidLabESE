package com.example.applicationform

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun Summary(navController: NavController,details: Details){
    Column(Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center){
        Text(text = "Your name :${details.name}")
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "Your college : ${details.college}")
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "Your college : ${details.email}")
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "Your gender : ${details.gender}")
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "Your age: ${details.age}")
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "Your Birthdate: ${details.mDate}")
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { navController.navigateUp() }) {
            Text(text = "Go back To the Registration Screen")
        }
    }
}