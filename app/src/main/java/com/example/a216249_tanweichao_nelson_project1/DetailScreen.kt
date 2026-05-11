package com.example.a216249_tanweichao_nelson_project1

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(navController: NavController, vm: GapFinderViewModel, id: Int) {
    val op = vm.savedOpportunities.find { it.id == id }
    Scaffold(topBar = { TopAppBar(title = { Text("Detail Report") }, navigationIcon = { IconButton(onClick = { navController.popBackStack() }) { Icon(Icons.Default.ArrowBack, null) } }) }) { padding ->
        Column(Modifier.padding(padding).padding(24.dp)) {
            Text(op?.category ?: "N/A", fontSize = 28.sp, fontWeight = FontWeight.ExtraBold)
            Text(op?.location ?: "N/A", color = Color.Gray)
            Divider(Modifier.padding(vertical = 16.dp))
            Text("Gap Score: ${op?.score}", color = Color(0xFF005689), fontWeight = FontWeight.Bold, fontSize = 22.sp)
            Spacer(Modifier.height(16.dp))
            Text("AI Analysis Summary:", fontWeight = FontWeight.Bold)
            Text(op?.analysis ?: "")
            Spacer(Modifier.height(16.dp))
            Text("Social Impact:", fontWeight = FontWeight.Bold)
            Text(op?.sdgImpact ?: "")
        }
    }
}