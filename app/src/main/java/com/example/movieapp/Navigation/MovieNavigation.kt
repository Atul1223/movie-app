package com.example.movieapp.Navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.movieapp.screens.details.DetailsScreen
import com.example.movieapp.screens.home.HomeScreen

@Composable
fun MovieNavigation() {
    val navController = rememberNavController()
    
    NavHost(
        navController = navController,
        startDestination = MovieScreens.HomeScreen.name,
    ) {

        composable(
            route = MovieScreens.HomeScreen.name
        ) {
            HomeScreen(navController = navController)
        }

        composable(
            route = MovieScreens.DetailScreen.name+"/{movieData}",
            arguments = listOf(
                navArgument(name = "movieData") {type = NavType.StringType}
            )
        ) {
            DetailsScreen(
                navController = navController,
                movieId = it.arguments?.getString("movieData")
            )
        }
    }
}