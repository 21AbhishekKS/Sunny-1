package com.abhi.sunny1.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.abhi.sunny1.Screens.DashBoard
import com.abhi.sunny1.Screens.EditProfile
import com.abhi.sunny1.Screens.LoginScreen
import com.abhi.sunny1.Screens.PaymentScreen
import com.abhi.sunny1.Screens.ProfileScreen


@RequiresApi(Build.VERSION_CODES.N)
@Composable
fun NavGraph(navHostController: NavHostController, padding: Modifier){

    NavHost(navController = navHostController , startDestination = Routes.LoginScreen.route ){

        composable(Routes.LoginScreen.route){
            LoginScreen(navHostController , padding)
        }
        composable(Routes.DashBoard.route){
            DashBoard(navHostController , padding)
        }
        composable(Routes.EditProfile.route){
        EditProfile(navHostController , padding)
        }
        composable(Routes.MoodMonitorScreen.route){
          //  MoodMoiterScreen()
        }
        composable(Routes.PaymentScreen.route){
            PaymentScreen(padding)
        }
        composable(Routes.ProfileScreen.route){
            ProfileScreen(navHostController , padding)
        }
        composable(Routes.BottomNav.route){
        BottomNav(navHostController , padding)
        }

    }
}