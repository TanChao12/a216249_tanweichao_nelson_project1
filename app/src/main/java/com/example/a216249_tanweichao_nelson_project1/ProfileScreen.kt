package com.example.a216249_tanweichao_nelson_project1

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ProfileScreen(vm: GapFinderViewModel) {
    Column(Modifier.fillMaxSize().padding(24.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        Icon(Icons.Default.Person, null, Modifier.size(100.dp), tint = Color(0xFF005689))
        Text("Nelson Tan Wei Chao", fontSize = 22.sp, fontWeight = FontWeight.Bold)
        Text("Matric No: 216249", color = Color.Gray)
        Spacer(Modifier.height(40.dp))
        Card(Modifier.fillMaxWidth()) {
            Column(Modifier.padding(20.dp)) {
                Text("Application Usage Stats", fontWeight = FontWeight.Bold)
                Divider(Modifier.padding(vertical = 8.dp))
                Text("Total Gaps Analyzed: ${vm.savedOpportunities.size}")
                Text("Current SDG Target: SDG 8")
                Text("App Version: 1.0.0 Stable")
            }
        }
    }
}