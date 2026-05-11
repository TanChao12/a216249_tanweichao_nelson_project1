package com.example.a216249_tanweichao_nelson_project1

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ProfileScreen(vm: GapFinderViewModel) {
    // FIX: Add 'horizontalAlignment =' before Alignment.CenterHorizontally
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            imageVector = Icons.Default.Person,
            contentDescription = "Profile",
            modifier = Modifier.size(100.dp)
        )
        Text("Nelson Tan Wei Chao", fontSize = 24.sp)
        Text("Matric No: 216249", color = Color.Gray)

        Spacer(modifier = Modifier.height(40.dp))

        Card(modifier = Modifier.fillMaxWidth()) {
            Column(modifier = Modifier.padding(20.dp)) {
                Text("Project Portfolio: GapFinder")
                Text("SDG Focus: Goal 1 & 8")
                Text("Analyses Performed: ${vm.savedOpportunities.size}")
            }
        }
    }
}