package com.david.easypark

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.core.view.WindowCompat
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.david.easypark.navigation.AppNavHost
import com.david.easypark.ui.theme.EasyParkTheme
import com.david.easypark.uti.SharedViewModel
import com.google.firebase.auth.FirebaseAuth


private lateinit var auth: FirebaseAuth


class MainActivity : ComponentActivity() {

    private  lateinit var navController: NavHostController
    private  val  sharedViewModel : SharedViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window,false)
        setContent {
            EasyParkTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) { navController = rememberNavController()
                    AppNavHost(navController = navController,
                        sharedViewModel = sharedViewModel)
                }
            }
        }
    }
}
