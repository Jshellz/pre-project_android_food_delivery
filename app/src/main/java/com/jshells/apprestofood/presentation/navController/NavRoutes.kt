package com.jshells.apprestofood.presentation.navController

import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

sealed class NavRoutes(val route: String) {
    object Home: NavRoutes(route = "home")
    object AddToCard: NavRoutes(route = "addToCard")
    object ChatWithRest: NavRoutes(route = "chatWithRest")
    object SelectedDishes: NavRoutes(route = "selectedDishes")
}

@Composable
fun NavRoutes.NRHome(navController: NavController) {
    Button(
        onClick = {
            navController.navigate(NavRoutes.Home.route)
        }
    ) { }
}

@Composable
fun NavRoutes.NRAddToCard(navController: NavController) {
    Button(
        onClick = {
            navController.navigate(NavRoutes.AddToCard.route)
        }
    ) { }
}

@Composable
fun NavRoutes.NRChatWithRest(navController: NavController) {
    Button(
        onClick = {
            navController.navigate(NavRoutes.ChatWithRest.route)
        }
    ) { }
}

@Composable
fun NavRoutes.NRSelectedDishes(navController: NavController) {
    Button(
        onClick = {
            navController.navigate(NavRoutes.SelectedDishes.route)
        }
    ) { }
}