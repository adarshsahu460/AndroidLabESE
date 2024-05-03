package com.example.bintohex

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.bintohex.ui.theme.BinToHexTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BinToHexTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    DropdownExample()
                }
            }
        }
    }
}

//@Composable
//fun Greeting(name: String, modifier: Modifier = Modifier) {
//    var isHexSelected by remember { mutableStateOf(true) }
//
//    var expanded by remember { mutableStateOf(false) }
//    val items = listOf("Hex", "Decimal")
//
//    Column {
//        Box(
//            modifier = Modifier
//                .padding(16.dp)
//                .clickable(onClick = { expanded = true })
//        ) {
//            Text(text = if (isHexSelected) "Hex" else "Decimal")
//            Icon(
//                painter = painterResource(id = R.drawable.baseline_arrow_drop_down_24),
//                contentDescription = "Dropdown Icon"
//            )
//        }
//        DropdownMenu(
//            expanded = expanded,
//            onDismissRequest = { expanded = false }
//        ) {
//            items.forEach { item ->
//                DropdownMenuItem(onClick = {
//                    isHexSelected = item == "Hex"
//                    expanded = false
//                }) {
//                    Text(text = item)
//                }
//            }
//        }
//    }
//}

@Composable
fun DropdownExample() {
    var isHexSelected by remember { mutableStateOf(true) }
    var expanded by remember { mutableStateOf(false) }
    var selectedIndex by remember { mutableStateOf(0) }
    val (number, setNumber) = remember { mutableStateOf(TextFieldValue()) }

    val items = listOf("Hex", "Decimal")

    Column {
        Row(horizontalArrangement = Arrangement.Center, modifier = Modifier.fillMaxWidth()){
            TextField(value = number, onValueChange = {setNumber(it)})
        }
        Row(
            modifier = Modifier
                .padding(top = 16.dp)
                .clickable { expanded = true }
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text("Convert to: ")
            Text(text = items[selectedIndex])
            Icon(
                painter = painterResource(id = R.drawable.baseline_arrow_drop_down_24),
                contentDescription = "Dropdown Icon"
            )
        }

        if (expanded) {
            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                items.forEachIndexed { index, item ->
                    Text(
                        modifier = Modifier.clickable {
                            selectedIndex = index
                            isHexSelected = index == 0
                            expanded = false
                        },
                        text = item
                    )
                }
            }
        }
        Row(modifier = Modifier.fillMaxWidth(),horizontalArrangement = Arrangement.Center){
            Column{
                Button(onClick = { /*TODO*/ }) {
                    Text(text = "Convert")
                }
                if(selectedIndex==0) Text(text = "Answer ${decimalToHex(number.text.toIntOrNull()?:0)}")
                else Text(text = "Answer ${hexToDecimal(number.text)}")
            }
        }
    }
}
fun decimalToHex(decimal: Int): String {
    return decimal.toString(16).toUpperCase()
}
fun hexToDecimal(hex: String): Int {
    return hex.toIntOrNull(16) ?: 0
}
