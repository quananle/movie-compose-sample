package com.quanle.movie_sample_compose.ui.screen.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.quanle.movie_sample_compose.R
import com.quanle.movie_sample_compose.utils.wtf

@Composable
fun AppBottomNavigation(modifier: Modifier = Modifier, tabSelected: Int, onTabSelected: (Int) -> Unit) {

    BottomNavigation(
        modifier = modifier,
        backgroundColor = Color.White,
        contentColor = Color.Gray,
        content = {

            screens.forEachIndexed { index, item ->

                BottomNavigationItem(
                    label = {
                        Text(
                            text = item.name,
                            fontSize = 10.sp,
                            maxLines = 1
                        )
                    },
                    icon = {
                        Icon(
                            painterResource(id = item.icon),
                            contentDescription = ""
                        )
                    },
                    selectedContentColor = Color.Red,
                    unselectedContentColor = Color.Gray,
                    selected = tabSelected == index,
                    onClick = {
                        onTabSelected(index)
                    })
            }
        }
    )
}

@Composable
@Preview
fun previewBottomNav() {

}

val screens = listOf(
    Screen(
        name = "Home",
        icon = R.drawable.ic_home
    ),

    Screen(
        name = "Explore",
        icon = R.drawable.ic_explore
    ),

    Screen(
        name = "My List",
        icon = R.drawable.ic_mylist
    ),

    Screen(
        name = "Download",
        icon = R.drawable.ic_download
    ),

    Screen(
        name = "Profile",
        icon = R.drawable.ic_person
    )
)
data class Screen(
    val name: String,
    @DrawableRes
    val icon: Int
)

