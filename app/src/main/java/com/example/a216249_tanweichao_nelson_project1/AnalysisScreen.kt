package com.example.a216249_tanweichao_nelson_project1

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AnalysisScreen(navController: NavController, vm: GapFinderViewModel, loc: String, cat: String) {
    Scaffold(
        topBar = { TopAppBar(title = { Text("AI Results") }, navigationIcon = { IconButton(onClick = { navController.popBackStack() }) { Icon(Icons.Default.ArrowBack, null) } }) }
    ) { padding ->
        Column(Modifier.padding(padding).padding(24.dp), horizontalAlignment = Alignment.CenterHorizontally) {
            Card(Modifier.fillMaxWidth(), colors = CardDefaults.cardColors(Color(0xFFE8F5E9))) {
                Column(Modifier.padding(24.dp)) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(Icons.Default.CheckCircle, null, tint = Color(0xFF2E7D32))
                        Spacer(Modifier.width(8.dp))
                        Text("Success: Potential Identified", fontWeight = FontWeight.Bold, color = Color(0xFF2E7D32))
                    }
                    Spacer(Modifier.height(16.dp))
                    Text("Target: $cat in $loc")
                    Spacer(Modifier.height(8.dp))
                    Text("Intelligence suggests high demand for services in this specific region.")
                }
            }
            Spacer(Modifier.height(40.dp))
            Button(onClick = {
                vm.addOpportunity(loc, cat)
                navController.navigate("home") { popUpTo("home") { inclusive = true } }
            }, Modifier.fillMaxWidth().height(56.dp)) {
                Text("Save and View Records")
            }
        }
    }
}