package com.abhi.sunny1.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.DateRange
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.abhi.sunny1.Screens.DashBoard
import com.abhi.sunny1.Screens.EditProfile
import com.abhi.sunny1.Screens.MoodMonitorScreen
import com.abhi.sunny1.Screens.PaymentScreen
import com.abhi.sunny1.Screens.ProfileScreen
import com.abhi.sunny1.model.BottomNavItem


@RequiresApi(Build.VERSION_CODES.N)
@Composable
fun BottomNav(navHostController: NavHostController, padding: Modifier){

    val navController1 = rememberNavController()

    Scaffold(bottomBar = { MyBottomBar(navController1) }) { innerPadding ->

        NavHost(navController = navController1 , startDestination = Routes.DashBoard.route ,
            modifier = Modifier.padding(innerPadding)){
            composable(Routes.DashBoard.route){
                DashBoard(navController1, padding)
            }
            composable(Routes.EditProfile.route){
               EditProfile(navController1, padding)
            }
            composable(Routes.MoodMonitorScreen.route){
                MoodMonitorScreen(navController1 , padding)
            }
            composable(Routes.PaymentScreen.route){
                PaymentScreen(padding)
            }
            composable(Routes.ProfileScreen.route){
                ProfileScreen(navHostController, padding)
            }


        }

    }
}

@Composable
fun MyBottomBar(navController1: NavHostController) {

    val backStackEntry = navController1.currentBackStackEntryAsState()

    val list = listOf(
        BottomNavItem(
            "DashBoard",
            "Home",
            Icons.Filled.Home,
            Icons.Outlined.Home
        ),

        BottomNavItem(
            "MoodMonitorScreen",
            "Mood",
            Icons.Filled.DateRange,
            Icons.Outlined.DateRange
        ),
    
    BottomNavItem(
            "PaymentScreen",
            "Payment",
            Icons.Filled.Info,
            Icons.Outlined.Info
        ),
    BottomNavItem(
            "ProfileScreen",
            "Profile",
            Icons.Filled.AccountCircle,
            Icons.Outlined.AccountCircle
        )
    )


    BottomAppBar(containerColor = Color.White, contentColor = Color.White){
        list.forEach{
            val selected = it.route == backStackEntry.value?.destination?.route

            NavigationBarItem(
                colors = NavigationBarItemDefaults.colors(
                    indicatorColor =  Color(84, 75, 100, 255),
                ),
                selected = selected,
                onClick = { navController1.navigate(it.route){
                    popUpTo(navController1.graph.findStartDestination().id){
                        saveState = true
                    }
                    launchSingleTop = true
                } },
                icon = { Icon(
                    imageVector = it.selectedIcon,
                    contentDescription = it.title,
                    tint = if (selected) Color.White else Color.Black // Set icon color based on selection
                )},
                label = { Text(text = it.title, color = Color.Black)})
        }
    }


}
