package com.example.movieapp.screens.home


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.example.movieapp.Navigation.MovieScreens
import com.example.movieapp.model.Movie
import com.example.movieapp.model.getMovies
import com.example.movieapp.widgets.MovieRow

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(containerColor = Color(0xFF7C73C0)),
                title = {
                    Text(text = "Movie App")
                },

                )
        },){
        MainContent(Modifier.padding(bottom = it.calculateBottomPadding(), top = it.calculateTopPadding()), navController= navController)
    }
}

@Composable
fun MainContent(modifier: Modifier = Modifier, navController: NavController, movieList: List<Movie> = getMovies()) {

    Column(modifier = modifier) {
        LazyColumn() {
            items(items = movieList) {
                MovieRow(movie = it) {
                    navController.navigate(
                        route = MovieScreens.DetailScreen.name+"/$it", //passing arguments to the details screen
                    )
                }
            }
        }
    }
}

