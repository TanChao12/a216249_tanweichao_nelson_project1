package com.example.a216249_tanweichao_nelson_project1

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Mail
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun NetworkScreen() {
    Column(Modifier.fillMaxSize().padding(16.dp)) {
        Text("Community Network", fontSize = 26.sp, fontWeight = FontWeight.Bold)
        Text("Connecting local impact leaders.", color = Color.Gray)
        Spacer(Modifier.height(24.dp))

        val partners = listOf("Sarah Jenkins" to "SDG 1: No Poverty", "Marcus Chen" to "SDG 2: Zero Hunger", "GreenPath Alliance" to "SDG 13: Climate Action")

        partners.forEach { (name, sdg) ->
            Card(Modifier.fillMaxWidth().padding(bottom = 12.dp)) {
                Row(Modifier.padding(16.dp), verticalAlignment = Alignment.CenterVertically) {
                    Surface(Modifier.size(50.dp), shape = CircleShape, color = Color.LightGray) {}
                    Column(Modifier.padding(start = 16.dp).weight(1f)) {
                        Text(name, fontWeight = FontWeight.Bold)
                        Text(sdg, color = Color(0xFF2E7D32), fontSize = 12.sp)
                    }
                    IconButton(onClick = {}) { Icon(Icons.Default.Mail, null, tint = Color(0xFF1B5E20)) }
                }
            }
        }
    }
}