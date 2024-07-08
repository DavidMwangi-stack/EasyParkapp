package com.david.easypark.ui.theme.screens.parking


import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Place
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.david.easypark.ui.theme.BlueGray
import com.david.easypark.uti.SharedViewModel


@Composable
fun BottomApp(navController: NavHostController) {
    val navigationController = rememberNavController()
    val context = LocalContext.current.applicationContext
    val selected = remember {
        mutableStateOf(Icons.Default.Home)
    }
    Scaffold (
        bottomBar = {
            BottomAppBar (
                containerColor = BlueGray
            ){

                //1
                IconButton(onClick = {
                    selected.value =Icons.Default.Place
                    navigationController.navigate(Bottombar.Viewparkingscreen.bottombar){
                        popUpTo(0)
                    }
                },
                    modifier = Modifier.weight(1f)
                ) {
                    Icon(Icons.Default.Place, contentDescription = null, modifier = Modifier.size(26.dp),
                        tint = if (selected.value ==Icons.Default.Place) Color.White else Color.DarkGray)

                }

                //2
                IconButton(onClick = {
                    selected.value =Icons.Default.Create
                    navigationController.navigate(Bottombar.Profilescreen.bottombar){
                        popUpTo(0)
                    }
                },
                    modifier = Modifier.weight(1f)
                ) {
                    Icon(Icons.Default.Create, contentDescription = null, modifier = Modifier.size(26.dp),
                        tint = if (selected.value ==Icons.Default.Create) Color.White else Color.DarkGray)

                }
              /*  Box (modifier = Modifier
                    .weight(1f)
                    .padding(16.dp),
                    contentAlignment = Alignment.Center
                ){
                    FloatingActionButton(onClick = { Toast.makeText(context, "Ready", Toast.LENGTH_SHORT).show()}) {
                        Icon(Icons.Default.Refresh, contentDescription = null, tint = BlueGray )
                    }

                }*/
                IconButton(onClick = {
                    selected.value =Icons.Default.Person
                    navigationController.navigate(Bottombar.Uploadscreen.bottombar){
                        popUpTo(0)
                    }
                },
                    modifier = Modifier.weight(1f)
                ) {
                    Icon(Icons.Default.Person, contentDescription = null, modifier = Modifier.size(26.dp),
                        tint = if (selected.value ==Icons.Default.Person) Color.White else Color.DarkGray)

                }

            }
        }
    ){paddingValues ->
        NavHost(navController = navigationController, startDestination = Bottombar.Viewparkingscreen.bottombar,
            modifier = Modifier.padding(paddingValues)){
            composable(Bottombar.Viewparkingscreen.bottombar){ viewparkingscreen(navController = rememberNavController())}
            composable(Bottombar.Uploadscreen.bottombar){ Uploadscreen(navController = rememberNavController(), sharedViewModel = SharedViewModel())}
            composable(Bottombar.Profilescreen.bottombar){ Profilescreen(navController = rememberNavController(), sharedViewModel = SharedViewModel()) }
        }
    }
}

@Preview
@Composable
private fun Bottomappprev() {

        BottomApp(navController = rememberNavController())


}