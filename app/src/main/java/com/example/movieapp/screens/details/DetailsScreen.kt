package com.example.movieapp.screens.details

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailsScreen(
    navController: NavController,
    movieData: String?
) {
    Scaffold(

        topBar = {
            TopAppBar(
                navigationIcon = {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Go back",
                        modifier = Modifier.clickable {
                            navController.popBackStack()
                        }
                    )
                },
                title = {
                    Text(text = movieData.toString())
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = Color(0xFF7C73C0)
                )
            )
        }
    ) {
        Details(movieId = movieData.toString(), modifier = Modifier.padding(paddingValues = it))
    }
}

@Composable
fun Details(modifier: Modifier = Modifier, movieId: String) {
    Text(
        modifier = modifier,
        text = movieId
    )
}