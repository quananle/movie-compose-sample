package com.quanle.movie_sample_compose.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.quanle.movie_sample_compose.ui.screen.components.AppBottomNavigationItem
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
        startDestination = "Main"
    ) {
        authGraph()
        mainGraph()
    }
}

fun NavGraphBuilder.mainGraph() {
    navigation(
        startDestination = AppBottomNavigationItem.HomeScreen.route,
        route = "Main"
    ) {

        composable(
            route = AppBottomNavigationItem.HomeScreen.route,
            content = {
                HomeScreen()
            }
        )

        composable(
            route = AppBottomNavigationItem.ExplorerScreen.route,
            content = {
                ExplorerScreen()
            }
        )

        composable(
            route = AppBottomNavigationItem.MyListScreen.route,
            content = {
                MyListScreen()
            }
        )

        composable(
            route = AppBottomNavigationItem.DownloadScreen.route,
            content = {
                DownloadScreen()
            }
        )

        composable(
            route = AppBottomNavigationItem.ProfileScreen.route,
            content = {
                ProfileScreen()
            }
        )

    }
}

fun NavGraphBuilder.authGraph() {

}

