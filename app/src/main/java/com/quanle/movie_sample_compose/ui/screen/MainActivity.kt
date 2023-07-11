package com.quanle.movie_sample_compose.ui.screen
import android.os.Bundle
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.ui.graphics.Color
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.quanle.movie_sample_compose.R
import com.quanle.movie_sample_compose.ui.theme.MovieSampleComposeTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val splashScreen = installSplashScreen()
        splashScreen.setOnExitAnimationListener { splashScreenView ->
            splashScreenView.remove()
            setContent {
                MovieSampleComposeTheme() {
                   MovieApp()
               }
            }
        }

    }
}



