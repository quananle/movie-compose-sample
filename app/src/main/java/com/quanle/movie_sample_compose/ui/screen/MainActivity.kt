package com.quanle.movie_sample_compose.ui.screen
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Scaffold
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.rememberNavController
import com.quanle.movie_sample_compose.R
import com.quanle.movie_sample_compose.navigation.AppNavigation
import com.quanle.movie_sample_compose.ui.screen.components.AppBottomNavigation
import com.quanle.movie_sample_compose.ui.theme.MovieSampleComposeTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val splashScreen = installSplashScreen()
        splashScreen.setOnExitAnimationListener { splashScreenView -> splashScreenView.remove()

            setContent {
                MovieSampleComposeTheme() {
                    val navController = rememberNavController()
                    Scaffold(
                        bottomBar = {
                            AppBottomNavigation(
                                modifier = Modifier.fillMaxWidth(),
                                navController = navController
                            )
                        }
                    ) { paddingValues ->
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(paddingValues)
                        ) { /** App content **/
                            AppNavigation(navController = navController)
                        }
                    }
                }
            }
        }
    }
}


