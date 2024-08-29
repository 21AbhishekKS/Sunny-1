package com.abhi.sunny1.navigation

sealed class Routes(val route : String) {

    object LoginScreen : Routes("LoginScreen")
    object DashBoard : Routes("DashBoard")
    object EditProfile : Routes("EditProfile")
    object MoodMonitorScreen : Routes("MoodMonitorScreen")
    object PaymentScreen : Routes("PaymentScreen")
    object BottomNav : Routes("BottomNav")

    object ProfileScreen : Routes("ProfileScreen")

}