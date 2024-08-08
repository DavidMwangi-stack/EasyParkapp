package com.david.easypark.ui.theme.screens.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.david.easypark.R
import com.david.easypark.data.AuthViewModel
import com.david.easypark.navigation.ROUTE_REGISTER


@Composable
fun Loginscreen(navController: NavHostController){


    var email by remember { mutableStateOf(TextFieldValue("")) }
    var pass by remember { mutableStateOf(TextFieldValue("")) }
    var name by remember { mutableStateOf(TextFieldValue("")) }
    var context = LocalContext.current
    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.onboarding5),
            contentDescription = "",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.matchParentSize()
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
            //    .background(Color.White),
          ,  horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(90.dp))
            Text(
                text = "Login",
                color = Color.Yellow,
                fontSize = 30.sp,
                fontWeight = FontWeight.ExtraBold,
                fontFamily = FontFamily.Monospace
            )
            Spacer(modifier = Modifier.height(180.dp))

            OutlinedTextField(
                value = name, onValueChange = { name = it },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Person,
                        contentDescription = "Icons"
                    )
                },
                label = { Text(text = "UserName") },
                keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next),
                modifier = Modifier
                    .width(300.dp)
                    .padding(8.dp),
            )
            Spacer(modifier = Modifier.height(20.dp))

            OutlinedTextField(
                value = email, onValueChange = { email = it },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Email,
                        contentDescription = "Icons"
                    )
                },
                label = { Text(text = "Enter Email") },
                keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next),
                modifier = Modifier
                    .width(300.dp)
                    .padding(8.dp),

                )
            Spacer(modifier = Modifier.height(20.dp))

            OutlinedTextField(
                value = pass, onValueChange = { pass = it },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Lock,
                        contentDescription = "Icons"
                    )
                },
                label = { Text(text = "Enter Password") },
                visualTransformation = PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next),
                modifier = Modifier
                    .width(300.dp)
                    .padding(8.dp)
            )
            Spacer(modifier = Modifier.height(20.dp))

            Button(onClick = {
                val mylogin = AuthViewModel(navController, context)
                mylogin.login(email.text.trim(), pass.text.trim())
            }, modifier = Modifier.width(300.dp)) {
                Text(text = "Log In")
            }
            Spacer(modifier = Modifier.height(20.dp))

            Button(onClick = {
                navController.navigate(ROUTE_REGISTER)
            }, modifier = Modifier.width(300.dp)) {
                Text(text = "Don't have account? Click to Register")
            }
          //  Spacer(modifier = Modifier.height(4.dp))
          //   Text(text = "forgot password?", modifier = Modifier.clickable { })

            Spacer(modifier = Modifier.height(4.dp))


        }

    }
}

@Preview
@Composable
private fun loginprev() {
    Loginscreen(navController = rememberNavController())
}