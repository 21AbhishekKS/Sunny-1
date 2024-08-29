package com.abhi.sunny1.model

import androidx.compose.ui.graphics.vector.ImageVector

data class BottomNavItem(

    val route : String ,
    val title :String,
    val selectedIcon : ImageVector,
    val unSelectedIcon : ImageVector,
    val hasNews : Boolean = false,
    val badgeCount : Int  ?= null

)
