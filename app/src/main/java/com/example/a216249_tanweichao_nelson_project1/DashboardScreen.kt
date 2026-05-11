package com.example.a216249_tanweichao_nelson_project1

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun DashboardScreen(navController: NavController, vm: GapFinderViewModel) {
    Column(Modifier.fillMaxSize().verticalScroll(rememberScrollState()).padding(16.dp)) {
        Text("GapFinder", fontSize = 22.sp, fontWeight = FontWeight.Bold, color = Color(0xFF1B5E20))
        Spacer(Modifier.height(24.dp))

        Card(Modifier.fillMaxWidth(), shape = RoundedCornerShape(24.dp), colors = CardDefaults.cardColors(Color(0xFFF9F9F9))) {
            Column(Modifier.padding(24.dp), horizontalAlignment = Alignment.CenterHorizontally) {
                Box(contentAlignment = Alignment.Center) {
                    CircularProgressIndicator(0.85f, Modifier.size(120.dp), color = Color(0xFF2E7D32), strokeWidth = 10.dp)
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text("85", fontSize = 28.sp, fontWeight = FontWeight.Bold)
                        Text("SCORE", fontSize = 10.sp, color = Color.Gray)
                    }
                }
                Text("Overall Opportunity Score", fontWeight = FontWeight.Bold, modifier = Modifier.padding(top = 16.dp))
                Text("Current location shows high potential for sustainable retail development.", fontSize = 12.sp, color = Color.Gray)
            }
        }

        Spacer(Modifier.height(24.dp))
        Text("Market Trends", fontWeight = FontWeight.Bold)
        Row(Modifier.fillMaxWidth().height(120.dp), Arrangement.SpaceBetween, Alignment.Bottom) {
            val bars = listOf(0.4f, 0.5f, 0.3f, 0.7f, 0.9f, 0.8f)
            bars.forEachIndexed { i, h ->
                Box(Modifier.width(40.dp).fillMaxHeight(h).clip(RoundedCornerShape(8.dp)).background(if(i == 4) Color(0xFF0D47A1) else Color(0xFFBBDEFB)))
            }
        }
        Spacer(Modifier.height(30.dp))
        Button(onClick = { navController.navigate("search") }, Modifier.fillMaxWidth().height(56.dp), colors = ButtonDefaults.buttonColors(Color(0xFF1B5E20))) {
            Text("Start Search")
        }
    }
}