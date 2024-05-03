package com.example.implementscrollablelist

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.implementscrollablelist.ui.theme.ImplementScrollableListTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ImplementScrollableListTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ProgrammingLanguageList()
                }
            }
        }
    }
}

@Composable
fun ProgrammingLanguageList() {
    val context = LocalContext.current
    val coroutineScope = rememberCoroutineScope()
    val languages = listOf("Java", "Kotlin", "Python", "JavaScript", "Swift","C++","Dart","Rust","Go")
    LazyColumn(Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
        items(languages.size) { index ->
            val language = languages[index]
            Text(
                text = language,
                modifier = Modifier.clickable {
                    coroutineScope.launch {
                        showToast(context,language)
                    }
                }.padding(8.dp)
            )
        }
    }
}
fun showToast(context: Context, message: String) {
    Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
}
