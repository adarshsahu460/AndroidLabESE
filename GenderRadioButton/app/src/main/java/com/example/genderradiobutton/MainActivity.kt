package com.example.genderradiobutton

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.genderradiobutton.ui.theme.GenderRadioButtonTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GenderRadioButtonTheme {
                // A surface container using the 'background' color from the theme
                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    val selectedGender = remember{mutableStateOf("")}
                    Text("Select Gender")
                    Row {
                        RadioButton(selected = selectedGender.value=="Male", onClick = { selectedGender.value="Male" })
                        Text("Male", modifier = Modifier.padding(top = 12.dp))
                        RadioButton(selected = selectedGender.value=="Female", onClick = { selectedGender.value="Female"})
                        Text("Female", modifier = Modifier.padding(top = 12.dp))
                    }
                    if(selectedGender.value=="Male") Image(painter = painterResource(id = R.drawable.male), contentDescription = "")
                    else if(selectedGender.value=="Female")Image(painter = painterResource(id = R.drawable.female), contentDescription = "")
                }
            }
        }
    }
}
