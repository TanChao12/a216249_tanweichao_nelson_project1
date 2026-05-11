package com.example.a216249_tanweichao_nelson_project1

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.AutoAwesome
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun LandingScreen(navController: NavController) {
    Column(Modifier.fillMaxSize().padding(24.dp)) {
        Box(Modifier.fillMaxWidth().height(260.dp).background(Color(0xFFE8F5E9), RoundedCornerShape(24.dp)), contentAlignment = Alignment.Center) {
            Icon(Icons.Default.AutoAwesome, null, Modifier.size(80.dp), tint = Color(0xFF2E7D32))
        }
        Spacer(Modifier.height(32.dp))
        Text("Empathetic Intelligence", color = Color(0xFF2E7D32), fontWeight = FontWeight.Bold)
        Text("Identifying Underserved Opportunities for Global Impact.", fontSize = 30.sp, fontWeight = FontWeight.ExtraBold, lineHeight = 36.sp)
        Spacer(Modifier.height(16.dp))
        Text("GapFinder bridges the divide between data and community needs, empowering you to drive SDGs.", color = Color.Gray)
        Spacer(Modifier.weight(1f))
        Button(
            onClick = { navController.navigate("dashboard") },
            Modifier.fillMaxWidth().height(60.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF1B5E20)),
            shape = RoundedCornerShape(16.dp)
        ) {
            Text("Get Started", fontSize = 18.sp)
            Icon(Icons.Default.ArrowForward, null, Modifier.padding(start = 8.dp))
        }
    }
}