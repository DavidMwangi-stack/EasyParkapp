package com.david.easypark.ui.theme.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.david.easypark.R
import com.david.easypark.navigation.ROUTE_LOGIN
import com.david.easypark.navigation.ROUTE_REGISTER


@Composable
fun Homescreen(navController: NavHostController) {
    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.onboarding5),
            contentDescription = "",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.matchParentSize()
        )

        Column(
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
            //  .background(color = Color.Black)
        ) {

            Spacer(modifier = Modifier.height(100.dp))
            Text(
                color = Color.White,
                fontStyle = FontStyle.Normal,
                fontSize = 50.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 25.dp),
                text = buildAnnotatedString {
                    append ("Easy")
                    withStyle(style = SpanStyle(
                        fontWeight = FontWeight.Bold,
                        color = Color.Yellow)) {
                        append("Park")
                    }

                }
            )

            Spacer(modifier = Modifier.height(10.dp))
            Text(
                    color = Color.White,
                    fontStyle = FontStyle.Normal,
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(bottom = 25.dp),
                text = buildAnnotatedString {
                  append ("Find the right parking\n")
                    withStyle(style = SpanStyle(
                     fontWeight = FontWeight.Bold,
                        color = Color.Yellow)) {
                        append("at your own convenience")
                    }

                }
            )
            Spacer(modifier = Modifier.height(80.dp))
            Button(
                onClick = {
                    navController.navigate(ROUTE_LOGIN)

                },
                modifier = Modifier
                    .width(300.dp)
            ) {
                Text(text = "Login page")

            }

            Spacer(modifier = Modifier.height(20.dp))
            Button(
                onClick = {
                    navController.navigate(ROUTE_REGISTER)

                },
                modifier = Modifier
                    .width(300.dp)
            ) {
                Text(text = "Register page")

            }
            Spacer(modifier = Modifier.height(25.dp))
            /*    Image(
                painter = painterResource(id = R.drawable.loading2),
                contentDescription = "logo",
                modifier = Modifier
                    .size(
                        500.dp
                    )
                    .padding(10.dp)
            )*/

        }
    }
}
@Preview
@Composable
private fun Homepre() {
    Homescreen(navController = rememberNavController())
}
