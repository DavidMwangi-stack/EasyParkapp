package com.david.easypark.ui.theme.screens.parking

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.david.easypark.uti.SharedViewModel
import com.david.easypark.uti.UserData

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Profilescreen(navController: NavHostController,
                  sharedViewModel: SharedViewModel) {

    var number : String by remember { mutableStateOf("") }
    var area : String by remember { mutableStateOf("") }
    var timein : String by remember { mutableStateOf("") }
    var timeout : String by remember { mutableStateOf("") }
    val context = LocalContext.current

        Column(
            modifier = Modifier.fillMaxSize()
                .background(Color.White),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TopAppBar(
                title = {
                    Text(
                        text = "Booking",
                        fontSize = 25.sp,
                        fontFamily = FontFamily.Monospace,
                        color = Color.Yellow,
                        modifier = Modifier.padding(20.dp),
                        fontWeight = FontWeight.ExtraBold,
                        textDecoration = TextDecoration.Underline
                    ) },
            )
            Spacer(modifier = Modifier.height(20.dp))

                OutlinedTextField(
                    modifier = Modifier.width(300.dp).padding(8.dp),
                    value = number , onValueChange = {
                        number = it
                    },
                    label = {
                        Text(text = "Numberplate") })
            Spacer(modifier = Modifier.height(20.dp))

            OutlinedTextField(
                modifier = Modifier.width(300.dp).padding(8.dp),
                value = area , onValueChange = {
                    area = it
                },
                label = {
                    Text(text = "Building A,B,C,D,E & F") })
            Spacer(modifier = Modifier.height(20.dp))

            OutlinedTextField(
                modifier = Modifier.width(300.dp).padding(8.dp),
                value = timein, onValueChange = {
                    timein = it
                },
                label = {
                    Text(text = "TimeIn(24hrs)") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                )
            Spacer(modifier = Modifier.height(20.dp))

            OutlinedTextField(
                modifier = Modifier.width(300.dp).padding(8.dp),
                value = timeout, onValueChange = {
                    timeout = it },
                label = {
                    Text(text = "TimeOut(24hrs)") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
            Button(modifier = Modifier
                .padding(top = 50.dp)
                .width(300.dp).padding(8.dp),
                onClick = {
                    val  userData = UserData(
                        number = number,
                        area = area,
                        timein = timein,
                        timeout = timeout
                    )
                    sharedViewModel.saveData(userData = userData, context = context)
                }) {
                Text(text = "Book Now")

            }




        }
    }

@Preview
@Composable
private fun profileprev() {
    Profilescreen(navController = rememberNavController(), sharedViewModel = SharedViewModel())

}