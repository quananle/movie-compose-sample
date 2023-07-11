package com.quanle.movie_sample_compose.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.quanle.movie_sample_compose.ui.screen.detail.DetailScreen
import com.quanle.movie_sample_compose.ui.screen.download.DownloadScreen
import com.quanle.movie_sample_compose.ui.screen.explorer.ExplorerScreen
import com.quanle.movie_sample_compose.ui.screen.home.HomeScreen
import com.quanle.movie_sample_compose.ui.screen.mylist.MyListScreen
import com.quanle.movie_sample_compose.ui.screen.profile.ProfileScreen


@Composable
fun AppNavigation(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = ScreenDestination.HomeScreen.route
    ) {

        composable(route = ScreenDestination.HomeScreen.route) {
            HomeScreen()
        }

        composable(route = ScreenDestination.DetailScreen.route) {
            DetailScreen()
        }

        composable(route = ScreenDestination.MyListScreen.route) {
            MyListScreen()
        }

        composable(route = ScreenDestination.ExplorerScreen.route) {
            ExplorerScreen()
        }

        composable(route = ScreenDestination.ProfileScreen.route) {
            ProfileScreen()
        }

        composable(route = ScreenDestination.DownloadScreen.route) {
            DownloadScreen()
        }

    }
}

sealed class ScreenDestination( val route: String) {
    object HomeScreen: ScreenDestination("HomeScreen")
    object DetailScreen: ScreenDestination("DetailScreen")
    object MyListScreen: ScreenDestination("MyListScreen")
    object DownloadScreen: ScreenDestination("DownloadScreen")
    object ExplorerScreen: ScreenDestination("ExplorerScreen")
    object ProfileScreen: ScreenDestination("ProfileScreen")

}