package com.david.easypark.ui.theme.screens.parking

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.david.easypark.R

@Composable
fun viewparkingscreen(navController: NavHostController) {
    val imageId = arrayOf(
        R.drawable.parking1,
        R.drawable.parking2,
        R.drawable.parking3,
        R.drawable.parking4,
        R.drawable.parking5,
        R.drawable.parking6
    )

    val names = arrayOf(
        "Building A",
        "Building B",
        "Building C",
        "Building D",
        "Building E",
        "Building F"
    )


    val descriptions = arrayOf(
        "This parking space has three entrances/exits, over 800 parking stalls, and easy access to 500+ small businesses and the waterfront. We offer daily and monthly parking on a first-come, first-served basis.",
        "With parking available for over 4,000 vehicles across our venues, including Long Beach Arena, Convention Center, Terrace Theater, and Beverly O’Neill Theater, your journey to a great time starts here. Count on our clear directions for a hassle-free arrival, and for specific events, choose reserved parking to ensure a seamless experience from start to finish.",
        "Conveniently located near many Washington, DC attractions, including the National Mall, the Washington Monument, the White House, Smithsonian Museums including the National Museum of African American History and Culture, the Warner and National Theaters and many other DC attractions. Our underground garage is safe, secure, and open 24 hours a day",
        "Whether you’re looking for hourly, daily or monthly parking, with 2,000 spaces and a prime location we can accommodate your needs.You can access the parking garage at the following 3 entrances:\n" +
                "\n" +
                "(1) 13 ½ Street and Pennsylvania Avenue\n" +
                "(2) located on either side of the building on 14th Street between Constitution Avenue and Pennsylvania Avenue",
        "We encourage valet parking on weekdays at our four drop-off points on the La Jolla medical campus. It is a convenient way to make it to your appointment on time.",
        "There are multiple parking garages to serve patients and visitors at Barnes-Jewish Hospital on the Washington University Medical Campus. Because of the size of the hospital, you will want to park in the garage nearest the area you will be visiting or receiving care. Our off-campus locations offer convenient parking lots directly attached to the facilities.",
    )

    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "Mainscreen") {
        composable(route = "Mainscreen") {
            Mainscreen(imageId, names, descriptions, navController)
        }
        composable(route = "Detailscreen/{index}",
            arguments = listOf(
                navArgument(name = "index") {
                    type = NavType.IntType
                }
            )
        ) { index->
            Detailscreen(
                photos = imageId,
                names = names,
                descriptions = descriptions,
                itemIndex = index.arguments?.getInt("index")

            )
        }

    }

}




@Preview
@Composable
private fun viewparkingprev() {
    viewparkingscreen(navController = rememberNavController())

}