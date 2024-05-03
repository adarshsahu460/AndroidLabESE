package com.example.applicationform

import android.app.DatePickerDialog
import android.os.Parcelable
import android.widget.DatePicker
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import kotlinx.parcelize.Parcelize
import java.util.Calendar
import java.util.Date


@Composable
fun Register(navController: NavController) {
    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var gender by remember { mutableStateOf("") }
    var age by remember { mutableStateOf(18) }
    var agreementChecked by remember { mutableStateOf(false) }
    val expanded = remember{ mutableStateOf(false) }
    val mContext = LocalContext.current
    val mYear: Int
    val mMonth: Int
    val mDay: Int
    val mCalendar = Calendar.getInstance()
    mYear = mCalendar.get(Calendar.YEAR)
    mMonth = mCalendar.get(Calendar.MONTH)
    mDay = mCalendar.get(Calendar.DAY_OF_MONTH)
    val mDate = remember { mutableStateOf("") }
    val check = remember{ mutableStateOf(false) }
    mCalendar.time = Date()
    val college = remember{ mutableStateOf("Select College") }
    val mDatePickerDialog = DatePickerDialog(
        mContext,
        { _: DatePicker, mYear: Int, mMonth: Int, mDayOfMonth: Int ->
            mDate.value = "$mDayOfMonth/${mMonth+1}/$mYear"
            check.value = true
        }, mYear, mMonth, mDay
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Name") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
            keyboardActions = KeyboardActions(onNext = { /* Handle action */ })
        )
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
            keyboardActions = KeyboardActions(onNext = { /* Handle action */ })
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text("Gender")
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceAround) {
            Row{
                RadioButton(
                    selected = gender == "Male",
                    onClick = { gender = "Male" },
                    modifier = Modifier.padding(end = 8.dp),
                )
                Text("Male", modifier = Modifier.padding(vertical = 12.dp))
            }
            Row{
                RadioButton(
                    selected = gender == "Female",
                    onClick = { gender = "Female" },
                    modifier = Modifier.padding(start = 8.dp)
                )
                Text("Female", modifier = Modifier.padding(vertical = 12.dp))
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = college.value,
            Modifier
                .clickable { expanded.value = !expanded.value }
                .padding(8.dp))
        Spacer(modifier = Modifier.height(8.dp))
        Column (Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally)  {
            DropdownMenu(expanded = expanded.value, onDismissRequest = {expanded.value = false}) {
                DropdownMenuItem(text = { Text(text = "Walchand College Of Engineering") }, onClick = { college.value= "Walchand College Of Engineering";expanded.value = false})
                DropdownMenuItem(text = { Text(text = "WillingDon College") }, onClick = { college.value= "WillingDon College";expanded.value = false})
                DropdownMenuItem(text = { Text(text = "IIT Bombay") }, onClick = { college.value="IIT Bombay" ;expanded.value = false})
                DropdownMenuItem(text = { Text(text = "IIT Delhi") }, onClick = { college.value="IIT Delhi" ;expanded.value = false})
                DropdownMenuItem(text = { Text(text = "NIT Trichy") }, onClick = { college.value="NIT Trichy" ;expanded.value = false})
                DropdownMenuItem(text = { Text(text = "IIIT Hyderabad") }, onClick = { college.value="IIIT Hyderabad" ;expanded.value = false})
            }
        }
        Button(onClick = {
            mDatePickerDialog.show()
        }) {
            Text(text = "Pick Birth Date")
        }
        Text(text = mDate.value)
        Text("Age")
        Slider(
            value = age.toFloat(),
            onValueChange = { value ->
                age = value.toInt()
            },
            valueRange = 0f..100f,
            steps = 100,
            modifier = Modifier.fillMaxWidth()
        )
        Text(age.toString())
        Spacer(modifier = Modifier.height(16.dp))
        Spacer(modifier = Modifier.height(16.dp))
        Row(verticalAlignment = Alignment.CenterVertically) {
            Checkbox(
                checked = agreementChecked,
                onCheckedChange = { agreementChecked = it },
                modifier = Modifier.padding(end = 8.dp)
            )
            Text("I agree to terms and conditions")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = {
                navController.currentBackStackEntry?.savedStateHandle?.set("value",Details(name,gender,email,age,college.value,mDate.value))
                navController.navigate("show")
            },
            enabled = agreementChecked && name.isNotBlank() && email.isNotBlank() && gender.isNotBlank()
        ) {
            Text("Submit")
        }
    }
}

@Parcelize
data class Details(
    val name:String,val gender:String,val email:String,val age:Int,val college:String,val mDate:String
):Parcelable

