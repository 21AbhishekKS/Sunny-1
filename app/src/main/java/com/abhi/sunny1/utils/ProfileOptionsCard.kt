package com.abhi.sunny1.utils

import android.service.autofill.OnClickAction
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
 fun ProfileOptionsCard(title : String , id : Int , onClickAction: ()-> Unit){
 Card(
  modifier = Modifier
   .fillMaxWidth()
   .padding(vertical = 6.dp),
  shape = RoundedCornerShape(8.dp),
  elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
  colors = CardDefaults.cardColors(Color.White),
  onClick = onClickAction
 ) {
  Row(
   Modifier
    .fillMaxWidth()
    .padding(2.dp)
    .padding(end = 10.dp),
   horizontalArrangement = Arrangement.SpaceBetween,
   verticalAlignment = Alignment.CenterVertically) {

   Row( Modifier
    // .fillMaxWidth()
    .padding(5.dp),
    horizontalArrangement = Arrangement.SpaceBetween,
    verticalAlignment = Alignment.CenterVertically) {
    Icon(painter = painterResource(id = id ) ,contentDescription = "" , Modifier.size(25.dp) )
    Text(
     text = title,
     modifier = Modifier.padding(16.dp)
    )
   }

   Icon(imageVector = Icons.Filled.ArrowForward, contentDescription = "" )
  }


 }
 }