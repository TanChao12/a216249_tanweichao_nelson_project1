package com.example.a216249_tanweichao_nelson_project1

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InputScreen(navController: NavController) {
    var loc by remember { mutableStateOf("") }
    var cat by remember { mutableStateOf("") }
    var locExp by remember { mutableStateOf(false) }
    var catExp by remember { mutableStateOf(false) }

    val locations = listOf("Bangi", "Kajang", "Cyberjaya", "Kuala Lumpur", "Pekan")
    val categories = listOf("Retail Gaps", "Digital Services", "Healthcare", "Education")

    Column(Modifier.fillMaxSize().padding(24.dp)) {
        Text("Market Intelligence Form", style = MaterialTheme.typography.headlineSmall, fontWeight = FontWeight.Bold)
        Spacer(Modifier.height(24.dp))

        ExposedDropdownMenuBox(expanded = locExp, onExpandedChange = { locExp = it }) {
            OutlinedTextField(value = loc, onValueChange = { loc = it; locExp = true }, label = { Text("Enter City or Region") }, modifier = Modifier.fillMaxWidth().menuAnchor(), trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(locExp) })
            ExposedDropdownMenu(expanded = locExp, onDismissRequest = { locExp = false }) {
                locations.filter { it.contains(loc, true) }.forEach { item ->
                    DropdownMenuItem(text = { Text(item) }, onClick = { loc = item; locExp = false })
                }
            }
        }

        Spacer(Modifier.height(16.dp))

        ExposedDropdownMenuBox(expanded = catExp, onExpandedChange = { catExp = it }) {
            OutlinedTextField(value = cat, onValueChange = {}, readOnly = true, label = { Text("Business Sector") }, modifier = Modifier.fillMaxWidth().menuAnchor(), trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(catExp) })
            ExposedDropdownMenu(expanded = catExp, onDismissRequest = { catExp = false }) {
                categories.forEach { item ->
                    DropdownMenuItem(text = { Text(item) }, onClick = { cat = item; catExp = false })
                }
            }
        }

        Spacer(Modifier.height(40.dp))
        Button(onClick = { navController.navigate("analysis/$loc/$cat") }, Modifier.fillMaxWidth().height(56.dp), enabled = loc.isNotBlank() && cat.isNotBlank()) {
            Text("Analyze Gap")
        }
    }
}