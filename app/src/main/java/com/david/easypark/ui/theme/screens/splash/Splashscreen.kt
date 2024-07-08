package com.david.easypark.ui.theme.screens.splash

import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
import com.david.easypark.navigation.ROUTE_ABOUT
import kotlinx.coroutines.delay


@Composable
fun SplashScreen(navController: NavHostController) {
        Column(
        modifier = Modifier.fillMaxSize()
            .background(Color.White)
            ,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
            val scale = remember {
                Animatable(0f)
            }
            Spacer(modifier = Modifier.height(400.dp))

            Text(
                color = Color.Black,
                fontStyle = FontStyle.Normal,
                fontSize = 50.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 25.dp),
                text = buildAnnotatedString {
                    append ("Easy")
                    withStyle(style = SpanStyle(
                        fontWeight = FontWeight.Bold,
                        color = Color.Yellow)
                    ) {
                        append("Park")
                    }

                }
            )

            // AnimationEffect
            LaunchedEffect(key1 = true) {
                scale.animateTo(
                    targetValue = 0.7f,
                    animationSpec = tween(
                        durationMillis = 800,
                        easing = {
                            OvershootInterpolator(4f).getInterpolation(it)
                        })
                )
                delay(1000L)
                navController.navigate(ROUTE_ABOUT)
            }

            // Image
           /* Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.width(300.dp).padding(8.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.booking1),
                    contentDescription = "Logo",
                    modifier = Modifier.scale(scale.value)
                        .size(500.dp).width(100.dp).height(100.dp)
                )
            }*/
        }   }

@Preview
@Composable
private fun spalshpre() {
    SplashScreen(navController = rememberNavController())
}
