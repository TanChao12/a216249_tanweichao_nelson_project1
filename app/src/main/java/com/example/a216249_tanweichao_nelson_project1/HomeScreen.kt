package com.example.a216249_tanweichao_nelson_project1

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun HomeScreen(navController: NavController, vm: GapFinderViewModel) {
    Column(modifier = Modifier.fillMaxSize().background(Color(0xFFF8F9FA)).padding(16.dp)) {
        // App Bar Mock
        Row(Modifier.fillMaxWidth(), Arrangement.SpaceBetween, Alignment.CenterVertically) {
            Icon(Icons.Default.Menu, null, tint = Color(0xFF005689))
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(Icons.Default.Notifications, null)
                Spacer(Modifier.width(12.dp))
                Surface(Modifier.size(36.dp), CircleShape, Color(0xFF00639B)) {
                    Box(contentAlignment = Alignment.Center) { Text("WC", color = Color.White, fontSize = 12.sp) }
                }
            }
        }

        Spacer(Modifier.height(20.dp))

        // Search Card
        Card(Modifier.fillMaxWidth(), shape = RoundedCornerShape(24.dp), colors = CardDefaults.cardColors(Color.White), elevation = CardDefaults.cardElevation(2.dp)) {
            Column(Modifier.padding(20.dp)) {
                Text("Opportunity Search (Wei Chao - 216249)", color = Color(0xFF005689), fontWeight = FontWeight.Bold)
                Spacer(Modifier.height(12.dp))
                Button(onClick = { navController.navigate("find") }, Modifier.fillMaxWidth().height(50.dp), colors = ButtonDefaults.buttonColors(Color(0xFF005689)), shape = RoundedCornerShape(12.dp)) {
                    Icon(Icons.Default.Search, null); Spacer(Modifier.width(8.dp)); Text("Start Analysis")
                }
                Spacer(Modifier.height(12.dp))
                Text("Ready to analyze gaps?", color = Color(0xFFE68A00), fontWeight = FontWeight.Bold)
            }
        }

        Spacer(Modifier.height(20.dp))

        // Trends Graph Card
        Card(Modifier.fillMaxWidth(), shape = RoundedCornerShape(24.dp), colors = CardDefaults.cardColors(Color.White)) {
            Column(Modifier.padding(20.dp)) {
                Row(Modifier.fillMaxWidth(), Arrangement.SpaceBetween) {
                    Column {
                        Text("Gap Score Trends", fontWeight = FontWeight.Bold, fontSize = 18.sp)
                        Text("Overall Market Readiness", color = Color.Gray, fontSize = 12.sp)
                    }
                    Text("84.2", fontSize = 28.sp, fontWeight = FontWeight.Bold, color = Color(0xFF005689))
                }
                Spacer(Modifier.height(16.dp))
                Row(Modifier.fillMaxWidth().height(60.dp), Arrangement.SpaceBetween, Alignment.Bottom) {
                    val bars = listOf(0.3f, 0.5f, 0.4f, 0.9f, 0.6f, 0.7f, 0.8f)
                    bars.forEachIndexed { i, h ->
                        Box(Modifier.width(35.dp).fillMaxHeight(h).clip(RoundedCornerShape(4.dp)).background(if (i == 3) Color(0xFFE68A00) else Color(0xFFB0C4DE)))
                    }
                }
            }
        }

        Spacer(Modifier.height(24.dp))
        Text("Recent Records", fontWeight = FontWeight.Bold, fontSize = 18.sp)

        Column(verticalArrangement = Arrangement.spacedBy(12.dp), modifier = Modifier.padding(top = 8.dp)) {
            vm.savedOpportunities.take(2).forEach { op ->
                Card(Modifier.fillMaxWidth().clickable { navController.navigate("detail/${op.id}") }, shape = RoundedCornerShape(16.dp), colors = CardDefaults.cardColors(Color.White)) {
                    Row(Modifier.height(IntrinsicSize.Min).fillMaxWidth()) {
                        Box(Modifier.fillMaxHeight().width(5.dp).background(Color(0xFF005689)))
                        Row(Modifier.padding(12.dp), verticalAlignment = Alignment.CenterVertically) {
                            Surface(Modifier.size(40.dp), CircleShape, Color(0xFFF0F4F8)) { Box(contentAlignment = Alignment.Center) { Icon(Icons.Default.LocationOn, null, tint = Color(0xFF005689)) } }
                            Column(Modifier.weight(1f).padding(start = 12.dp)) {
                                Text(op.location, fontWeight = FontWeight.Bold)
                                Text(op.category, fontSize = 12.sp, color = Color.Gray)
                            }
                            Column(horizontalAlignment = Alignment.End) {
                                Text(op.score + " Gap", fontWeight = FontWeight.Bold, color = Color(0xFF005689))
                                Text(op.timeAgo, fontSize = 10.sp, color = Color.Gray)
                            }
                        }
                    }
                }
            }
        }
    }
}