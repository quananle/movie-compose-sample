package com.quanle.movie_sample_compose.ui.screen.discover

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.quanle.movie_sample_compose.R
import com.quanle.movie_sample_compose.ui.screen.components.MovieCard
import com.quanle.movie_sample_compose.ui.screen.components.Toolbar

@Composable
@Preview
fun DiscoverPreview() {
    DiscoverScreen(
        title = "aha",
        onBackActionClicked = {

        },
        onDetailMovieClicked = {

        },
        onSearchClicked = {

        }
    )
}

@Composable
fun DiscoverScreen(
    title: String,
    onBackActionClicked: () -> Unit,
    onDetailMovieClicked: (String) -> Unit,
    onSearchClicked: () -> Unit
) { /** DiscoverScreen with component **/

    Column(
        modifier = Modifier.fillMaxSize()
    ) {

        Toolbar(
            modifier = Modifier
                .padding(12.dp),
            title = title,
            primaryAction = R.drawable.ic_search,
            onPrimaryActionClicked = {
                onSearchClicked()
            },
            isMainRoute = false,
            onBackActionClicked = {
                onBackActionClicked()
            }
        )

        DiscoverListMovie(
            modifier = Modifier,
            onDetailMovieClicked = { positionItemClicked ->
                onDetailMovieClicked("Item tai vi tri $positionItemClicked")
            }
        )
    }
}

@Composable
fun DiscoverListMovie(
    modifier: Modifier = Modifier,
    onDetailMovieClicked: (Int) -> Unit
) {

    LazyVerticalGrid(
        modifier = modifier,
        columns = GridCells.Adaptive(150.dp),
        contentPadding = PaddingValues(
            horizontal = 12.dp,
            vertical = 12.dp
        ),
        content =  {
            items(count = 10) { position ->
                MovieCard(
                    modifier = Modifier
                        .height(250.dp)
                        .padding(horizontal = 4.dp, vertical = 4.dp)
                        .clickable {
                            onDetailMovieClicked(position)
                        }
                )
            }
        }
    )
}