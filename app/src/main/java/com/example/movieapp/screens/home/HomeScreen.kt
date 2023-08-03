package com.example.movieapp.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.movieapp.Navigation.MovieScreens

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
fun MainContent(modifier: Modifier = Modifier, navController: NavController) {
    val itemList = listOf<String>("abc","xyz","efg")

    Column(modifier = modifier) {
        LazyColumn() {
            items(items = itemList) {
                MovieRow(movie = it) {
                    navController.navigate(route = MovieScreens.DetailScreen.name)
                }
            }
        }
    }
}

@Composable
fun MovieRow(movie: String = "Test", onItemClick: (String) -> Unit) {
    Card(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()
            .height(100.dp)
            .border(
                width = 1.dp,
                color = Color.Black,
                shape = RoundedCornerShape(corner = CornerSize(10.dp))
            )
            .clickable {
                onItemClick(movie)
            },
        shape = RoundedCornerShape(corner = CornerSize(10.dp)),
        elevation = CardDefaults.cardElevation(defaultElevation = 5.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFACFADF)),
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(5.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            Image(
                modifier = Modifier.size(100.dp),
                imageVector = Icons.Default.AccountBox,
                contentDescription = "Movie Image"
            )
            Text(text = movie)
        }
    }
}