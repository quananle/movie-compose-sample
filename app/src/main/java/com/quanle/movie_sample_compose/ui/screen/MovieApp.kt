package com.quanle.movie_sample_compose.ui.screen

import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.quanle.movie_sample_compose.navigation.AppNavigation

@Composable
fun MovieApp() {
    val navController = rememberNavController()
    AppNavigation(navController = navController)
}