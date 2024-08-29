package com.abhi.sunny1.Screens

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.abhi.sunny1.R
import com.abhi.sunny1.navigation.Routes
import com.abhi.sunny1.utils.ProfileOptionsCard

@Composable
fun ProfileScreen(navHostController: NavHostController, modifier: Modifier) {
    val verticalScroll = rememberScrollState()

    Column(Modifier.verticalScroll(verticalScroll)) {
        // Image with round shape
        Column(
            Modifier.fillMaxWidth()
                .background(Color.White),
                    horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.user),
                contentDescription = "Profile Picture",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(100.dp)
                    .clip(CircleShape)
            )
            Spacer(modifier = Modifier.height(8.dp))
            // Text under image
            Text(text = "Hello World!", fontSize = 20.sp)
        }




        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color(0xFFEFF2F7))
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {


            Spacer(modifier = Modifier.height(16.dp))

            // Cards


            ProfileOptionsCard("Payment Options", id=R.drawable.dollar_icon, {
                //navHostController.navigate(Routes.PaymentScreen.route)
            })
            ProfileOptionsCard("Country", id=R.drawable.country_icon, {})
            ProfileOptionsCard("Notification Settings", id=R.drawable.img, {})
            ProfileOptionsCard("Edit Profile", id=R.drawable.profile_icon, {
                navHostController.navigate(Routes.EditProfile.route)
            })
            ProfileOptionsCard("Support", id=R.drawable.support_icon, {})
            Text(text = "General")
            ProfileOptionsCard("Terms of Service", id=R.drawable.terms_icon, {})
            ProfileOptionsCard("Invite Friends", id=R.drawable.invite_icon, {})
        }
    }
   }