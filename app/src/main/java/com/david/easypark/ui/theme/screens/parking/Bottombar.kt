package com.david.easypark.ui.theme.screens.parking

sealed class Bottombar (val bottombar: String){

    data object Uploadscreen :Bottombar("Booking")
    data object Viewparkingscreen:Bottombar("View parking")
    data object Profilescreen:Bottombar("Profile")
}