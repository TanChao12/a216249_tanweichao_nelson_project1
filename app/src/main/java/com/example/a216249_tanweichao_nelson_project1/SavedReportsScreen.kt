package com.example.a216249_tanweichao_nelson_project1

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.BusinessCenter
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
fun SavedReportsScreen(navController: NavController, vm: GapFinderViewModel) {
    Scaffold(topBar = { TopAppBar(title = { Text("Saved Reports") }) }) { padding ->
        if (vm.savedOpportunities.isEmpty()) {
            Box(Modifier.fillMaxSize().padding(padding), contentAlignment = Alignment.Center) {
                Text("No reports saved yet. Start at Home.", color = Color.Gray)
            }
        } else {
            LazyColumn(Modifier.padding(padding).fillMaxSize()) {
                items(vm.savedOpportunities) { item ->
                    ListItem(
                        headlineContent = { Text(item.category, fontWeight = FontWeight.Bold) },
                        supportingContent = { Text(item.location) },
                        leadingContent = { Icon(Icons.Default.BusinessCenter, null, tint = Color(0xFF1976D2)) },
                        trailingContent = { Text(item.score, fontWeight = FontWeight.Bold, color = Color(0xFF2E7D32)) },
                        modifier = Modifier.clickable { navController.navigate("detail/${item.id}") }
                    )
                    Divider()
                }
            }
        }
    }
}