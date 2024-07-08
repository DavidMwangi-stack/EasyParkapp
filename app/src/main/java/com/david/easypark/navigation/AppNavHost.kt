package com.david.easypark.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.david.easypark.ui.theme.screens.about.OnBoardingScreen
import com.david.easypark.ui.theme.screens.home.Homescreen
import com.david.easypark.ui.theme.screens.login.Loginscreen
import com.david.easypark.ui.theme.screens.parking.BottomApp
import com.david.easypark.ui.theme.screens.parking.Profilescreen
import com.david.easypark.ui.theme.screens.parking.Uploadscreen
import com.david.easypark.ui.theme.screens.parking.viewparkingscreen
import com.david.easypark.ui.theme.screens.register.RegisterScreen
import com.david.easypark.ui.theme.screens.splash.SplashScreen
import com.david.easypark.uti.SharedViewModel


@Composable
fun AppNavHost(modifier: Modifier =Modifier, navController: NavHostController = rememberNavController(),sharedViewModel: SharedViewModel, startDestination:String= ROUTE_SPLASH) {

    NavHost(navController = navController, modifier=modifier, startDestination = startDestination ) {
        composable(ROUTE_LOGIN) {
            Loginscreen(navController)
        }
        composable(ROUTE_REGISTER) {
            RegisterScreen(navController)
        }

        composable(ROUTE_HOME) {
            Homescreen(navController)
        }
     //   composable(ROUTE_UPDATE+"/{id}") { passedData->
      //    UpdateParkingScreen(navController,passedData.arguments?.getString("id")!!)
     //  }
     //   composable(ROUTE_BOOKING) {
      //      Bookingscreen(navController)
      //  }
        composable(ROUTE_SPLASH){
          SplashScreen(navController)
        }
        composable(ROUTE_UPLOAD){
            Uploadscreen(navController, sharedViewModel = SharedViewModel())
        }

        composable(ROUTE_ABOUT){
            OnBoardingScreen(navController)
        }
        composable(ROUTE_PARKING){
            viewparkingscreen(navController)
        }
        composable(ROUTE_START){
            BottomApp(navController)
        }
        composable(ROUTE_PROFILE){
            Profilescreen(navController, sharedViewModel = SharedViewModel())
        }

    }

}
