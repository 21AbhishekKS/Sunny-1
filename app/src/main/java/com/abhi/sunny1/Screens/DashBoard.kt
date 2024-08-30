package com.abhi.sunny1.Screens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.* // For layout management
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.abhi.sunny1.R

@Composable
fun DashBoard(navHostController: NavHostController, modifier: Modifier) {
    val verticalScroll = rememberScrollState()

    Column(modifier.verticalScroll(verticalScroll)) {

        Surface(
            modifier = Modifier.fillMaxSize(),
            color = Color(0xFFEFF2F7)
        ) {

            Column {
                // Dashboard Header
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(.3f)
                        //.padding(16.dp)
                        .background(Color.White)
                ) {


                    Text(
                        text = "Dashboard",
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding( 8.dp)
                    )
                    Text(
                        text = "Below is a summary of your loved ones",
                        fontSize = 14.sp,
                        color = Color.Gray,
                        modifier = Modifier.padding(8.dp)
                    )

                    // Current Usage Card
                    ElevatedCard(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp),
                        shape = RoundedCornerShape(8.dp),
                        colors = CardDefaults.cardColors(Color.White),
                        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
                    ) {
                        Column(
                            modifier = Modifier.padding(16.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(
                                text = "250 minutes",
                                fontSize = 32.sp,
                                fontWeight = FontWeight.Bold
                            )
                            Text(text = "Current Usage", fontSize = 14.sp, color = Color.Gray)
                        }
                    }
                }



                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp)
                ) {

                    // Current Status Card
                    ElevatedCard(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp),
                        shape = RoundedCornerShape(8.dp),
                        colors = CardDefaults.cardColors(Color.White),
                        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Column {
                                Text(text = "Current Status", fontSize = 18.sp, fontWeight = FontWeight.Bold)
                                Text(
                                    text = "An overview of your mood",
                                    fontSize = 14.sp,
                                    color = Color.LightGray
                                )
                            }
                            IconButton(onClick = { /* Handle click */ }) {
                                Icon(Icons.Default.ArrowForward, contentDescription = null)
                            }
                        }

                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Column {
                                Text(text = "45 days", fontSize = 24.sp, fontWeight = FontWeight.Bold)
                                Text(text = "Log", fontSize = 14.sp, color = Color.Gray)
                            }
                            Column(horizontalAlignment = Alignment.End) {
                                Text(text = "12", fontSize = 24.sp, fontWeight = FontWeight.Bold)
                                Text(text = "Total Number of Charges", fontSize = 14.sp, color = Color.Gray)
                            }
                        }
                    }

                    // Log and Charges Row
                    ElevatedCard(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp),
                        shape = RoundedCornerShape(8.dp)
                    ) {



                    }

                    // Recent Activity Card with Graph (Placeholder)
                    ElevatedCard(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp),
                        shape = RoundedCornerShape(8.dp),
                        colors = CardDefaults.cardColors(Color.White),
                        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
                    ) {
                        Column(
                            modifier = Modifier.padding(16.dp)
                        ) {
                            Text(text = "Recent Activity", fontSize = 18.sp, fontWeight = FontWeight.Bold)
                            Text(
                                text = "Below is an overview of tasks & activity completed",
                                fontSize = 14.sp,
                                color = Color.Gray
                            )
                            Spacer(modifier = Modifier.height(16.dp))

                            // Placeholder for Graph
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(200.dp)
                                    .padding(top = 8.dp),
                                contentAlignment = Alignment.Center
                            ) {
                               // Text(text = "Graph Placeholder", color = Color.Gray)
                                Image(painter = painterResource(id = R.drawable.graph), modifier = Modifier.width(400.dp).height(200.dp), contentDescription = "" )
                            }

                            // Legend for Mood
                            //Row(
                            //                                modifier = Modifier
                            //                                    .fillMaxWidth()
                            //                                    .padding(top = 16.dp),
                            //                                horizontalArrangement = Arrangement.SpaceEvenly
                            //                            ) {
                            //                                LegendItem(color = Color.Blue, label = "Happy")
                            //                                LegendItem(color = Color.Green, label = "Sad")
                            //                                LegendItem(color = Color.Magenta, label = "Enthusiastic")
                            //                            }
                        }

                    }
                }


            }

        }

}}


@Composable
fun LegendItem(color: Color, label: String) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Box(
            modifier = Modifier
                .size(8.dp)
                .padding(end = 4.dp)
                .background(color = color)
        )
        Text(text = label, fontSize = 12.sp, color = Color.Gray)
    }
}