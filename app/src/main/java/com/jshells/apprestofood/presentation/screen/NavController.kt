package com.jshells.apprestofood.presentation.screen

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddBox
import androidx.compose.material.icons.filled.ChatBubble
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.jshells.apprestofood.presentation.navController.NavRoutes

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Controller() {
    val navController = rememberNavController()
    val screens = listOf(
        NavRoutes.Home,
        NavRoutes.AddToCard,
        NavRoutes.ChatWithRest,
        NavRoutes.SelectedDishes,
    )
    Scaffold(
        bottomBar = {
            NavigationBar {
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentRoute = navBackStackEntry?.destination?.route

                screens.forEach { screen ->
                    NavigationBarItem(
                        selected = currentRoute == screen.route,
                        onClick = {
                            navController.navigate(screen.route) {
                                popUpTo(navController.graph.findStartDestination().id) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        },
                        icon = {
                            Icon(imageVector = when (screen) {
                                NavRoutes.Home -> Icons.Default.Home
                                NavRoutes.AddToCard -> Icons.Default.AddBox
                                NavRoutes.ChatWithRest -> Icons.Default.ChatBubble
                                NavRoutes.SelectedDishes -> Icons.Default.Favorite
                            },
                                contentDescription = null
                            )
                        },
                        modifier = Modifier,
                        enabled = true,
                        label = {
                            Text(
                                text = when (screen) {
                                    NavRoutes.Home -> "Home"
                                    NavRoutes.AddToCard -> "Card"
                                    NavRoutes.ChatWithRest -> "Chat"
                                    NavRoutes.SelectedDishes -> "Dishes"
                                }
                            )
                        },
                        alwaysShowLabel = true,
                        colors = NavigationBarItemDefaults.colors(
                            selectedIconColor = MaterialTheme.colorScheme.primary,
                            selectedTextColor = MaterialTheme.colorScheme.primary,
                            unselectedIconColor = MaterialTheme.colorScheme.onSurfaceVariant,
                            unselectedTextColor = MaterialTheme.colorScheme.onSurfaceVariant,
                            indicatorColor = MaterialTheme.colorScheme.surface,
                            disabledIconColor = Color.Red,
                            disabledTextColor = Color.White,
                },
            }
        }
    ) { paddingValues ->
        NavHost(
            navController = navController,
            startDestination = NavRoutes.Home.route,
            modifier = Modifier.padding(paddingValues)
        ) {
            composable(NavRoutes.Home.route) { MainScreen() }
            composable(NavRoutes.AddToCard.route) { PaymentScreen() }
            composable(NavRoutes.ChatWithRest.route) { OrderScreen() }
            composable(NavRoutes.SelectedDishes.route) { FavoriteScreen() }
        }
    }
}







