package com.quanle.movie_sample_compose.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost


@Composable
fun AppNavigation(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = MainGraph.rootRoute
    ) {
        authGraph(navController)
        mainGraph(navController)
    }
}

