package hoods.com.loginui

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.center
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import hoods.com.loginui.ui.SignUpState
import hoods.com.loginui.ui.theme.Gold
import hoods.com.loginui.ui.theme.LoginUITheme
import kotlin.math.log

@Composable
fun LoginHomeScreen() {
    LoginPageScreen()
}


@Composable
fun LoginPageScreen() {
    Surface(
        color = MaterialTheme.colors.primaryVariant,
        contentColor = MaterialTheme.colors.onSurface,
    ) {
        val (username, onUserNameChange) = remember {
            mutableStateOf("")
        }
        val (password, onPasswordChange) = remember {
            mutableStateOf("")
        }
        val (checked, onCheckedChange) = remember {
            mutableStateOf(false)
        }
        Column {

            Text(
                text = "Login",
                style = MaterialTheme.typography.h6,
                modifier = Modifier.padding(16.dp),
            )
            Spacer(modifier = Modifier.size(16.dp))
            OutlinedTextField(
                value = username,
                onValueChange = onUserNameChange,
                label = { Text(text = "UserName") },
                leadingIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_baseline_person_24),
                        contentDescription = null
                    )
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                shape = MaterialTheme.shapes.medium
            )
            Spacer(modifier = Modifier.size(16.dp))
            OutlinedTextField(
                value = password,
                onValueChange = onPasswordChange,
                label = { Text(text = "Password") },
                leadingIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_baseline_lock_24),
                        contentDescription = null
                    )
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                keyboardOptions = KeyboardOptions(keyboardType =KeyboardType.Password),
                visualTransformation = PasswordVisualTransformation(),
                shape = MaterialTheme.shapes.medium
            )
            Spacer(modifier = Modifier.size(16.dp))
            Row(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row {
                    Checkbox(checked = checked, onCheckedChange = onCheckedChange)
                    Spacer(modifier = Modifier.size(4.dp))
                    Text(text = "Remember me")
                }

                TextButton(
                    onClick = { /*TODO*/ },
                ) {
                    Text(text = "Forgot Password")
                }

            }

            Spacer(modifier = Modifier.size(16.dp))
            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                shape = MaterialTheme.shapes.medium
            ) {
                Text(text = "Login")
            }
        }
        Row(
            modifier = Modifier
                .fillMaxSize()
                .wrapContentSize(align = Alignment.BottomCenter)
        ) {
            Text(text = "Don't have an Account?")
            TextButton(
                onClick = { /*TODO*/ },
            ) {
                Text(text = "Sign Up")
            }


        }


    }


}


@Composable
fun SignUpPageScreen() {
    val signUpState = SignUpState()
    Surface(
        color = MaterialTheme.colors.primaryVariant,
        contentColor = MaterialTheme.colors.onSurface,
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            Text(
                text = "Sign Up",
                style = MaterialTheme.typography.h6,
                modifier = Modifier.padding(16.dp),
            )
            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)) {
                OutlinedTextField(
                    value = signUpState.firstName,
                    onValueChange = {
                        signUpState.firstNameChenged(newValue = it)
                        Log.i("SignUp", "SignUpPageScreen: $it")
                    },
                    modifier = Modifier.weight(1f),
                    shape = MaterialTheme.shapes.medium,
                    label = { Text(text = "First Name") }
                )
                Log.i("SignUp", "SignUpPageScreen: ${signUpState.firstName}")
                Spacer(modifier = Modifier.size(8.dp))
                OutlinedTextField(
                    value = signUpState.lastName,
                    onValueChange = { signUpState.lastNameChange(it) },
                    modifier = Modifier.weight(1f),
                    shape = MaterialTheme.shapes.medium,
                    label = { Text(text = "Last Name") }
                )

            }
            OutlinedTextField(
                value = signUpState.emailAddress,
                onValueChange = { signUpState.emailAddressChange(it) },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                shape = MaterialTheme.shapes.medium,
                label = { Text(text = "Email Address") }
            )
            Spacer(modifier = Modifier.size(8.dp))
            OutlinedTextField(
                value = signUpState.password,
                onValueChange = { signUpState.password(it) },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                shape = MaterialTheme.shapes.medium,
                label = { Text(text = "Password") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                visualTransformation = PasswordVisualTransformation()
            )
            OutlinedTextField(
                value = signUpState.confirmPassword,
                onValueChange = { signUpState.confirmPasswordChange(it) },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                shape = MaterialTheme.shapes.medium,
                label = { Text(text = "Confirm Password") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                visualTransformation = PasswordVisualTransformation()
            )
            Spacer(modifier = Modifier.size(8.dp))
            Row(modifier = Modifier.padding(horizontal = 16.dp)) {
                Checkbox(
                    checked = signUpState.checked,
                    onCheckedChange = { signUpState.checkedChange(it) }
                )
                Spacer(modifier = Modifier.size(4.dp))
                Text(text = "Agree with privacy policy")
            }
            Spacer(modifier = Modifier.size(8.dp))
            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                shape = MaterialTheme.shapes.medium
            ) {
                Text(text = "Sign Up")

            }



            Row(modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .wrapContentSize(align = Alignment.BottomCenter)) {

                Text(text = "Already have an account?")
                Spacer(modifier = Modifier.size(8.dp))
                Text(
                    text = "Sign In",
                    modifier = Modifier.clickable {

                    },
                    color = MaterialTheme.colors.primary
                )


            }


        }


    }


}







@Composable
fun PasswordTextFieldComponent(
    labelValue: String, painterResource: Painter,
    onTextSelected: (String) -> Unit,
    errorStatus: Boolean = false
) {

    val localFocusManager = LocalFocusManager.current
    val password = remember {
        mutableStateOf("")
    }

    val passwordVisible = remember {
        mutableStateOf(false)
    }

    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth(),
        label = { Text(text = labelValue) },

        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Password,
            imeAction = ImeAction.Done
        ),
        singleLine = true,
        keyboardActions = KeyboardActions {
            localFocusManager.clearFocus()
        },
        maxLines = 1,
        value = password.value,
        onValueChange = {
            password.value = it
            onTextSelected(it)
        },
        leadingIcon = {
            Icon(painter = painterResource, contentDescription = "")
        },
        trailingIcon = {

            val iconImage = if (passwordVisible.value) {
                Icons.Filled.Visibility
            } else {
                Icons.Filled.VisibilityOff
            }

            val description = if (passwordVisible.value) {
                stringResource(id = R.string.hide_password)
            } else {
                stringResource(id = R.string.show_password)
            }

            IconButton(onClick = { passwordVisible.value = !passwordVisible.value }) {
                Icon(imageVector = iconImage, contentDescription = description)
            }

        },
        visualTransformation = if (passwordVisible.value) VisualTransformation.None else PasswordVisualTransformation(),
        isError = !errorStatus
    )
}





