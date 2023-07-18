package com.quanle.movie_sample_compose.ui.screen.components
import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import com.quanle.movie_sample_compose.R

@Composable
fun AppBottomNavigation(
    modifier: Modifier = Modifier,
    navBackStackEntry: NavBackStackEntry?,
    onTabClicked: (String) -> Unit
) {

    val bottomNavScreens = listOf(
        AppBottomNavigationItem.HomeScreen,
        AppBottomNavigationItem.ExplorerScreen,
        AppBottomNavigationItem.MyListScreen,
        AppBottomNavigationItem.DownloadScreen,
        AppBottomNavigationItem.ProfileScreen
    )


    val currentRoute = navBackStackEntry?.destination

    BottomNavigation(
        modifier = modifier,
        elevation = 16.dp,
        backgroundColor = Color.White,
        contentColor = Color.Gray,
        content = {
            bottomNavScreens.forEach {  item ->
                currentRoute?.let { currentDestination ->
                    BottomNavigationView(
                        item = item,
                        currentDestination = currentDestination,
                        onItemClick = { route ->
                            onTabClicked(route)
                        }
                    )
                }
            }
        }
    )
}

@Composable
fun RowScope.BottomNavigationView(
    item: AppBottomNavigationItem,
    currentDestination: NavDestination?,
    onItemClick: (String) -> Unit
) {
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
                painter =  painterResource(id = item.icon),
                contentDescription = ""
            )
        },
        selectedContentColor = Color.Red,
        unselectedContentColor = Color.Gray,
        selected = currentDestination?.route == item.route,
        onClick = {
            onItemClick(item.route)
        }
    )
}

sealed class AppBottomNavigationItem(
    val name: String,
    val route: String,
    @DrawableRes val icon: Int
) {
    object HomeScreen: AppBottomNavigationItem(name = "Home", icon = R.drawable.ic_home , route = "HomeScreen")
    object MyListScreen: AppBottomNavigationItem(name = "My List", icon = R.drawable.ic_mylist, route = "MyListScreen")
    object DownloadScreen: AppBottomNavigationItem(name = "Download", icon = R.drawable.ic_download, route = "DownloadScreen")
    object ExplorerScreen: AppBottomNavigationItem(name = "Explorer", icon = R.drawable.ic_explore, route = "ExplorerScreen")
    object ProfileScreen: AppBottomNavigationItem(name = "Profile", icon = R.drawable.ic_person, route = "ProfileScreen")
}

