package com.example.myapplication.Navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.myapplication.DetailsScreen
import com.example.myapplication.HomeScreen
@Composable
fun NavGraph(navController: NavHostController){
    NavHost(
        navController = navController, startDestination = Screens.home.route
    ) {
        composable(route = Screens.home.route) {
            HomeScreen(navController = navController)
        }
        composable(
            route = Screens.detail.route+"/{itemId}",
//            "details/{itemId}",
            arguments = listOf(navArgument("itemId") { type = NavType.IntType })
        ) { backStackEntry ->
            val itemId = backStackEntry.arguments?.getInt("itemId") ?: -1
            DetailsScreen(navController, itemId)
        }
    }
}