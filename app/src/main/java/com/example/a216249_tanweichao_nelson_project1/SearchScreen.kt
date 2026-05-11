package com.example.a216249_tanweichao_nelson_project1

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Analytics
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchScreen(navController: NavController, vm: GapFinderViewModel) {
    var loc by remember { mutableStateOf("") }
    var cat by remember { mutableStateOf("") }

    Column(Modifier.fillMaxSize().padding(24.dp)) {
        Text("Identify the impact", fontSize = 28.sp, fontWeight = FontWeight.Bold)
        Text("gap in your area.", fontSize = 28.sp, fontWeight = FontWeight.Bold, color = Color(0xFF0D47A1))

        Spacer(Modifier.height(32.dp))
        OutlinedTextField(loc, { loc = it }, label = { Text("Location") }, modifier = Modifier.fillMaxWidth())
        Spacer(Modifier.height(16.dp))
        OutlinedTextField(cat, { cat = it }, label = { Text("Business Category") }, modifier = Modifier.fillMaxWidth())

        Spacer(Modifier.height(24.dp))
        Text("Popular Sectors", fontWeight = FontWeight.Bold)
        Row(Modifier.padding(top = 8.dp)) {
            AssistChip(onClick = { cat = "Healthcare" }, label = { Text("Healthcare") })
            Spacer(Modifier.width(8.dp))
            AssistChip(onClick = { cat = "Retail" }, label = { Text("Retail") })
        }

        Spacer(Modifier.weight(1f))
        Button(
            onClick = {
                if(loc.isNotBlank() && cat.isNotBlank()) {
                    vm.performAnalysis(loc, cat)
                    navController.navigate("analysis")
                }
            },
            Modifier.fillMaxWidth().height(60.dp),
            colors = ButtonDefaults.buttonColors(Color(0xFF1B5E20))
        ) {
            Icon(Icons.Default.Analytics, null)
            Text("  ANALYZE", fontWeight = FontWeight.Bold)
        }
    }
}