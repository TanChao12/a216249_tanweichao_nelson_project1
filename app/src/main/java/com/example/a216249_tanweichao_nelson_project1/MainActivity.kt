package com.example.a216249_tanweichao_nelson_project1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                val navController = rememberNavController()
                val vm: GapFinderViewModel = viewModel()
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentRoute = navBackStackEntry?.destination?.route

                Scaffold(
                    bottomBar = {
                        if (currentRoute != "landing" && currentRoute != null) {
                            NavigationBar {
                                val navItems = listOf(
                                    Triple("dashboard", "Dashboard", Icons.Default.GridView),
                                    Triple("search", "Search", Icons.Default.Search),
                                    Triple("network", "Network", Icons.Default.Groups),
                                    Triple("profile", "Profile", Icons.Default.Person)
                                )
                                navItems.forEach { (route, label, icon) ->
                                    NavigationBarItem(
                                        icon = { Icon(icon, null) },
                                        label = { Text(label) },
                                        selected = currentRoute == route,
                                        onClick = { navController.navigate(route) {
                                            popUpTo("dashboard") { saveState = true }
                                            launchSingleTop = true
                                        }}
                                    )
                                }
                            }
                        }
                    }
                ) { innerPadding ->
                    NavHost(navController, "landing", Modifier.padding(innerPadding)) {
                        composable("landing") { LandingScreen(navController) }
                        composable("dashboard") { DashboardScreen(navController, vm) }
                        composable("search") { SearchScreen(navController, vm) }
                        composable("analysis") { AnalysisResultScreen(navController, vm) }
                        composable("network") { NetworkScreen() }
                        composable("profile") { ProfileScreen(vm) }
                    }
                }
            }
        }
    }
}