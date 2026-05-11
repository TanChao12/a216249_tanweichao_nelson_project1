package com.example.a216249_tanweichao_nelson_project1

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
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
fun AnalysisResultScreen(navController: NavController, vm: GapFinderViewModel) {
    val res = vm.currentAnalysis.value
    Column(Modifier.fillMaxSize().verticalScroll(rememberScrollState()).padding(16.dp)) {
        Text("OPPORTUNITY ANALYSIS", fontSize = 12.sp, color = Color.Gray)
        Text("${res?.location} Market Insights", fontSize = 24.sp, fontWeight = FontWeight.Bold)

        Spacer(Modifier.height(20.dp))
        Card(Modifier.fillMaxWidth()) {
            Column(Modifier.padding(20.dp)) {
                Text("✨ Suitable For You", color = Color(0xFF2E7D32), fontWeight = FontWeight.Bold)
                Text(res?.insightTitle ?: "", fontSize = 22.sp, fontWeight = FontWeight.Bold)
                Text(res?.insightDesc ?: "", color = Color.Gray)
                Spacer(Modifier.height(16.dp))
                Box(Modifier.fillMaxWidth().height(180.dp).background(Color(0xFFF0F0F0))) // Image Placeholder
            }
        }

        Spacer(Modifier.height(16.dp))
        Card(Modifier.fillMaxWidth()) {
            Row(Modifier.padding(20.dp), verticalAlignment = Alignment.CenterVertically) {
                CircularProgressIndicator(res?.impact?.toFloat()?.div(100f) ?: 0.9f, Modifier.size(60.dp), color = Color(0xFF1B5E20))
                Column(Modifier.padding(start = 16.dp)) {
                    Text("Social Impact", fontWeight = FontWeight.Bold)
                    Text("${res?.impact}% Score", color = Color.Gray)
                }
            }
        }

        Spacer(Modifier.height(24.dp))
        Button(onClick = { navController.navigate("network") }, Modifier.fillMaxWidth().height(56.dp), colors = ButtonDefaults.buttonColors(Color(0xFF1B5E20))) {
            Text("Collaborate")
        }
    }
}