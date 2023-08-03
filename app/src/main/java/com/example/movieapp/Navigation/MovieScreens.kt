package com.example.movieapp.Navigation

import java.lang.IllegalArgumentException

enum class MovieScreens {

    HomeScreen,
    DetailScreen;

    companion object {
        fun fromRoute(route: String?): MovieScreens {
            return when(route?.substringBefore("/")) {
                HomeScreen.name -> HomeScreen
                DetailScreen.name -> DetailScreen
                null -> HomeScreen
                else -> throw IllegalArgumentException("Route $route not found")
            }
        }
    }
}