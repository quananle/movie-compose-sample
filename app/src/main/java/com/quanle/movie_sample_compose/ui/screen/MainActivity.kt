package com.quanle.movie_sample_compose.ui.screen
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.quanle.movie_sample_compose.navigation.AppNavigation
import com.quanle.movie_sample_compose.ui.screen.components.AppBottomNavigation
import com.quanle.movie_sample_compose.ui.screen.components.AppBottomNavigationItem
import com.quanle.movie_sample_compose.ui.theme.MovieSampleComposeTheme
import dagger.hilt.android.AndroidEntryPoint
import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.navigation.NavDestination
import androidx.navigation.NavGraph
import com.quanle.movie_sample_compose.navigation.MainGraph
import com.quanle.movie_sample_compose.utils.wtf

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val splashScreen = installSplashScreen()
        splashScreen.setOnExitAnimationListener { splashScreenView ->
            splashScreenView.remove()

            setContent {
                MovieSampleComposeTheme() {
                    val navController = rememberNavController()
                    val navBackStackEntry = navController.currentBackStackEntryAsState()

                    val startDestinationGraph = navBackStackEntry.value?.destination?.parent?.startDestinationRoute
                    val destination = navBackStackEntry.value?.destination?.route
                    Scaffold(
                        bottomBar = {
                            if (startDestinationGraph == destination) {
                                AppBottomNavigation(
                                    modifier = Modifier.fillMaxWidth(),
                                    navBackStackEntry = navBackStackEntry.value,
                                    onTabClicked = { route ->
                                        navController.navigate(
                                            route = route,
                                            builder = {
                                                // Pop up to the start destination of the graph to
                                                // avoid building up a large stack of destinations
                                                // on the back stack as users select items
                                                popUpTo(navController.graph.findStartDestination().id) {
                                                    saveState = true
                                                }
                                                // Avoid multiple copies of the same destination when
                                                // re-selecting the same item
                                                launchSingleTop = true
                                            }
                                        )
                                    }
                                )
                            }
                        }
                    ) { paddingValues ->
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(paddingValues)
                        ) {
                            /** App content **/
                            AppNavigation(navController = navController)
                        }
                    }
                }
            }
        }
    }
}