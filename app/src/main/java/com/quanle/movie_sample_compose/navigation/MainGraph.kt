package com.quanle.movie_sample_compose.navigation

import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.quanle.movie_sample_compose.ui.screen.discover.DiscoverScreen
import com.quanle.movie_sample_compose.ui.screen.download.DownloadScreen
import com.quanle.movie_sample_compose.ui.screen.explorer.ExplorerScreen
import com.quanle.movie_sample_compose.ui.screen.home.HomeScreen
import com.quanle.movie_sample_compose.ui.screen.moviedetail.DetailScreen
import com.quanle.movie_sample_compose.ui.screen.mylist.MyListScreen
import com.quanle.movie_sample_compose.ui.screen.notification.NotificationScreen
import com.quanle.movie_sample_compose.ui.screen.profile.ProfileScreen
import com.quanle.movie_sample_compose.utils.wtf

object MainGraph {
    const val rootRoute = "MainGraph"

    //tab
    const val HomeRoute = "HomeGraph"
    const val ExplorerRoute = "ExplorerGraph"
    const val MyListRoute = "MyListGraph"
    const val DownloadRoute = "DownloadGraph"
    const val ProfileRoute = "ProfileGraph"

    object CommonDestination {
        const val DetailMovie = "DetailMovie"
    }

    object HomeGraph {
        const val Home = "HomeScreen"
        const val DiscoverMovie = "DiscoverMovie"
        const val SearchMovie = "SearchMovie"
        const val Notification = "Notification"
    }

    object ExplorerGraph {
        const val Explorer = "ExplorerScreen"
        const val FilterBottomSheet = "FilterBottomSheet"
    }

    object MyListGraph {
        const val MyList = "MyListScreen"
    }

    object DownloadGraph {
        const val Download = "DownloadScreen"
    }

    object ProfileGraph {
        const val Profile = "ProfileScreen"
    }

}

fun NavGraphBuilder.mainGraph(
    navController: NavController
) {
    navigation(
        startDestination = MainGraph.HomeRoute,
        route = MainGraph.rootRoute
    ) {

        homeGraph(navController)

        explorerGraph(navController)

        myListGraph(navController)

        downloadGraph(navController)

        profileGraph(navController)

        composable(
            route = MainGraph.CommonDestination.DetailMovie,
            content = {
                DetailScreen()
            }
        )
    }
}

fun NavGraphBuilder.homeGraph(
    navController: NavController
) {

    navigation(
        route = MainGraph.HomeRoute,
        startDestination = MainGraph.HomeGraph.Home
    ) {
        composable(
            route = MainGraph.HomeGraph.Home,
            content = {

                HomeScreen(
                    modifier = Modifier,
                    onClickedDetailMovie = {
                        navController.navigate(
                            route = MainGraph.CommonDestination.DetailMovie
                        )
                    },
                    onClickedDiscoverMovie = {
                        navController.navigate(
                            route = MainGraph.HomeGraph.DiscoverMovie
                        )
                    },
                    onClickedNotification = {
                        navController.navigate(
                            route = MainGraph.HomeGraph.Notification
                        )
                    },
                    onClickedSearch = {
                        navController.navigate(
                            route = MainGraph.ExplorerRoute
                        )
                    }
                )
            }
        )

        composable(
            route = MainGraph.HomeGraph.DiscoverMovie,
            content = {
                DiscoverScreen(
                    title = "Top 10 Movies This Week",
                    onBackActionClicked = { navController.popBackStack() },
                    onSearchClicked = {
                        navController.popBackStack()
                        navController.navigate(route = MainGraph.ExplorerRoute,)
                    },
                    onDetailMovieClicked = {
                        wtf { it }
                    }
                )
            }
        )

        composable(
            route = MainGraph.HomeGraph.Notification,
            content = {
                NotificationScreen(
                    title = "Notification",
                    onBackActionClicked = { navController.popBackStack() },
                    onOptionMenuClicked = {

                    },
                    onNotificationClicked = {
                        navController.navigate(
                            route = MainGraph.CommonDestination.DetailMovie
                        )
                    }
                )
            }
        )

    }
}

fun NavGraphBuilder.explorerGraph(
    navController: NavController
) {
    navigation(
        route = MainGraph.ExplorerRoute,
        startDestination = MainGraph.ExplorerGraph.Explorer
    ) {

        composable(
            route = MainGraph.ExplorerGraph.Explorer,
            content = {

                ExplorerScreen(
                    onMovieClicked = {
                        navController.navigate(
                            route = MainGraph.CommonDestination.DetailMovie,
                        )
                    }
                )
            }
        )

        composable(
            route = MainGraph.ExplorerGraph.FilterBottomSheet,
            content = {
                DetailScreen()
            }
        )
    }
}

fun NavGraphBuilder.myListGraph(
    navController: NavController
) {
    navigation(
        route = MainGraph.MyListRoute,
        startDestination = MainGraph.MyListGraph.MyList
    ) {

        composable(
            route = MainGraph.MyListGraph.MyList,
            content = {
                MyListScreen()
            }
        )

    }
}

fun NavGraphBuilder.downloadGraph(
    navController: NavController
) {
    navigation(
        route = MainGraph.DownloadRoute,
        startDestination = MainGraph.DownloadGraph.Download
    ) {

        composable(
            route = MainGraph.DownloadGraph.Download,
            content = {
                DownloadScreen()
            }
        )

    }
}


fun NavGraphBuilder.profileGraph(
    navController: NavController
) {
    navigation(
        route = MainGraph.ProfileRoute,
        startDestination = MainGraph.ProfileGraph.Profile
    ) {

//        navController.currentBackStack.value.forEach {
//            wtf { "${it.destination.route}" }
//        }
        composable(
            route = MainGraph.ProfileGraph.Profile,
            content = {
                ProfileScreen(
                    onClicked = {
                        navController.navigate(
                            route = MainGraph.CommonDestination.DetailMovie
                        )
                    }
                )
            }
        )

    }
}