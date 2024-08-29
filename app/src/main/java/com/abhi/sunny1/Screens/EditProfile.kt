package com.abhi.sunny1.Screens

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
@Composable
fun EditProfile(navHostController: NavHostController, modifier: Modifier) {
    Column(modifier) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color(0xFFEFF2F7))
                .padding(16.dp)
        ) {
            SectionWithDropdown(
                title = "Voice Selection",
                description = "Select from a variety of voices to personalize your companion bot’s speech.",
                options = listOf("AWS-Poly-Anne", "AWS-Poly-Matthew", "Google-Voice")
            )
            Spacer(modifier = Modifier.height(16.dp))
            SectionWithDropdown(
                title = "AI Model Selection",
                description = "Easily change the AI model powering your companion bot to better suit your needs.",
                options = listOf("ChatGPT-3.5Turbo", "GPT-4", "BERT")
            )
            Spacer(modifier = Modifier.height(16.dp))
            SectionWithDropdown(
                title = "Personality Selection",
                description = "Personalize your companion bot by selecting a personality type that best matches your preferences.",
                options = listOf("Friendly", "Professional", "Witty")
            )
            Spacer(modifier = Modifier.height(32.dp))

            // Data Reset Button
            Button(
                onClick = { /* Handle Data Reset */ },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF3B6AD3)
                )
            ) {
                Text(text = "Data Reset", color = Color.White, fontSize = 16.sp)
            }
        }
    }

}


@Composable
fun SectionWithDropdown(title: String, description: String, options: List<String>) {
    var expanded by remember { mutableStateOf(false) }
    var selectedOption by remember { mutableStateOf(options.first()) }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        colors = CardDefaults.cardColors(Color.White),

    ) {
        Column(modifier = Modifier.padding(16.dp)
        , verticalArrangement = Arrangement.Center) {
            Text(text = title, fontWeight = FontWeight.Bold, fontSize = 18.sp)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = description, fontSize = 14.sp, color = Color.Gray)
            Spacer(modifier = Modifier.height(16.dp))
            Box(
                modifier = Modifier
                    .padding(12.dp)
                    .height(40.dp)
                    .fillMaxWidth()
                    .background(Color.White)
                    .clickable { expanded = !expanded }

                    .background(
                        color = Color.White,
                        shape = RoundedCornerShape(8.dp)
                    )
                    .border(1.dp, color = Color.DarkGray, RoundedCornerShape(5.dp))
            ) {
                Row(Modifier.fillMaxWidth()
                    .padding(10.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween) {
                    Text(text = selectedOption )
                    Icon(imageVector = Icons.Default.ArrowDropDown, contentDescription = "" )
                }

                DropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false }
                ) {
                    options.forEach { option ->
                        DropdownMenuItem(
                            text = { Text(text = option)} ,
                            onClick = {
                            selectedOption = option
                            expanded = false
                        }) 
                    }
                }
            }
        }
    }
}