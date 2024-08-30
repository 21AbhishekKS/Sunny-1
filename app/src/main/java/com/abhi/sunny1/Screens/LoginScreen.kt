package com.abhi.sunny1.Screens

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.abhi.sunny1.navigation.Routes
import com.abhi.sunny1.R

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp

import androidx.compose.material.icons.*
import androidx.compose.ui.platform.LocalContext

@Composable
fun LoginScreen(navHostController: NavHostController, modifier: Modifier) {

    val context = LocalContext.current

        Column(modifier) {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = Color.White
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxSize()
                ) {

                    Image(painter = painterResource(id = R.drawable.grannywtdoll), contentDescription ="" )
                    ElevatedCard(
                        colors = CardDefaults.cardColors(Color.White),
                        modifier = Modifier.padding(16.dp),
                        shape = RoundedCornerShape(12.dp),
                        elevation = CardDefaults.cardElevation(8.dp)
                    ) {
                        Column(
                            modifier = Modifier
                                .padding(16.dp)
                                .fillMaxWidth(),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(
                                text = "Welcome, Sunny!",
                                fontSize = 24.sp,
                                modifier = Modifier.padding(bottom = 16.dp),
                                textAlign = TextAlign.Center
                            )
                            Spacer(modifier = Modifier.height(8.dp))
                            var email by remember { mutableStateOf("") }
                            var password by remember { mutableStateOf("") }
                            var passwordVisible by remember { mutableStateOf(false) }

                            OutlinedTextField(

                                value = email,
                                onValueChange = { email = it },
                                label = { Text("Email") },
                                modifier = Modifier.fillMaxWidth()
                            )

                            Spacer(modifier = Modifier.height(8.dp))

                            OutlinedTextField(
                                value = password,
                                onValueChange = { password = it },
                                label = { Text("Password") },
                                visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                                trailingIcon = {
                                    IconButton(onClick = { passwordVisible = !passwordVisible }) {
                                        Icon(
                                            modifier = Modifier.size(25.dp),
                                            painter = if (passwordVisible) painterResource(id = R.drawable.visible_eye) else painterResource(id = R.drawable.invisible_eye),
                                            contentDescription = null
                                        )
                                    }
                                },
                                modifier = Modifier.fillMaxWidth()
                            )

                            Spacer(modifier = Modifier.height(16.dp))

                            Button(
                                onClick = {

                                    if(email != "" && password != ""){
                                      navHostController.navigate(Routes.BottomNav.route)
                                      }else{
                                     Toast.makeText(context , "Email and Password are required" , Toast.LENGTH_SHORT).show()
                                      }
                                  //  navHostController.navigate(Routes.BottomNav.route)
                                          },
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(vertical = 8.dp)
                            ) {
                                Text("Get Started")
                            }

                            Spacer(modifier = Modifier.height(8.dp))

                            Text("Or sign up with")

                            Spacer(modifier = Modifier.height(8.dp))

                            Column(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(vertical = 10.dp)
                                    .height(100.dp)
                                    ,
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.Center,

                            ) {
                                OutlinedButton(
                                    onClick = {},
                                    modifier = Modifier
                                        .weight(1f)
                                        .fillMaxWidth(),
                                    colors = ButtonDefaults.outlinedButtonColors(
                                        contentColor = Color.Black
                                    )
                                ) {
                                    Icon(
                                        painter = painterResource(id = R.drawable.g_icon),
                                        contentDescription = "Continue with Google"
                                    )
                                    Spacer(Modifier.size(ButtonDefaults.IconSpacing))
                                    Text("Continue with Google")
                                }

                                Spacer(Modifier.height(8.dp))

                                OutlinedButton(
                                    onClick = {},
                                    modifier = Modifier
                                        .weight(1f)
                                        .fillMaxWidth(),
                                    colors = ButtonDefaults.outlinedButtonColors(
                                        contentColor = Color.Black
                                    )
                                ) {
                                    Icon(
                                        painter = painterResource(id = R.drawable.apple_icon),
                                        contentDescription = "Continue with Apple"
                                    )
                                    Spacer(Modifier.size(ButtonDefaults.IconSpacing))
                                    Text("Continue with Apple")
                                }
                            }
                        }
                    }
                }
            }
        }
    }
