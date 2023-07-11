package com.quanle.movie_sample_compose.ui.screen
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Scaffold
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.rememberNavController
import com.quanle.movie_sample_compose.navigation.AppNavigation
import com.quanle.movie_sample_compose.navigation.ScreenDestination
import com.quanle.movie_sample_compose.ui.screen.components.AppBottomNavigation
import com.quanle.movie_sample_compose.ui.screen.components.Screen
import com.quanle.movie_sample_compose.ui.theme.MovieSampleComposeTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val splashScreen = installSplashScreen()
        splashScreen.setOnExitAnimationListener { splashScreenView ->
            splashScreenView.remove()
            setContent {
                MovieSampleComposeTheme() {
                    Box(modifier = Modifier.fillMaxSize()) {
                        val navController = rememberNavController()
                        var bottomTabSelected by remember { mutableStateOf(0)}
                        Scaffold(
                            bottomBar = {
                                AppBottomNavigation(
                                    modifier = Modifier
                                        .clip(shape = RoundedCornerShape(
                                            topEnd = 16.dp,
                                            topStart = 16.dp
                                        )),
                                    tabSelected = bottomTabSelected
                                ) { onTabSelected ->
                                    bottomTabSelected = onTabSelected
                                }
                            }
                        ) { paddingValues ->
                            Box(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(paddingValues)
                            ) { /** App content **/
                                AppNavigation(navController = navController)
                                // TODO: Make app navigation clear & clean 
                                when (bottomTabSelected) {
                                    0-> navController.navigate(ScreenDestination.HomeScreen.route)
                                    1-> navController.navigate(ScreenDestination.ExplorerScreen.route)
                                    2-> navController.navigate(ScreenDestination.MyListScreen.route)
                                    3-> navController.navigate(ScreenDestination.DownloadScreen.route)
                                    4-> navController.navigate(ScreenDestination.ProfileScreen.route)
                                    else -> Unit
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}



