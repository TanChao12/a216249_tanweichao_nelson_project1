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
import androidx.compose.ui.graphics.Color
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
                        if (currentRoute in listOf("home", "find", "profile")) {
                            NavigationBar(containerColor = Color.White) {
                                val navItems = listOf(
                                    Triple("home", "HOME", Icons.Default.Home),
                                    Triple("find", "FIND", Icons.Default.Search),
                                    Triple("profile", "PROFILE", Icons.Default.Person)
                                )
                                navItems.forEach { (route, label, icon) ->
                                    NavigationBarItem(
                                        icon = { Icon(icon, null) },
                                        label = { Text(label) },
                                        selected = currentRoute == route,
                                        onClick = { navController.navigate(route) {
                                            popUpTo("home") { saveState = true }
                                            launchSingleTop = true
                                            restoreState = true
                                        }}
                                    )
                                }
                            }
                        }
                    }
                ) { innerPadding ->
                    NavHost(navController, startDestination = "home", Modifier.padding(innerPadding)) {
                        composable("home") { HomeScreen(navController, vm) }
                        composable("find") { InputScreen(navController) }
                        composable("profile") { ProfileScreen(vm) }
                        composable("analysis/{loc}/{cat}") { b ->
                            AnalysisScreen(navController, vm, b.arguments?.getString("loc")?:"", b.arguments?.getString("cat")?:"")
                        }
                        composable("detail/{id}") { b ->
                            DetailScreen(navController, vm, b.arguments?.getString("id")?.toInt() ?: 0)
                        }
                    }
                }
            }
        }
    }
}