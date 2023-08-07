package com.quanle.movie_sample_compose.ui.screen.notification

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.quanle.movie_sample_compose.R
import com.quanle.movie_sample_compose.ui.screen.components.Movie
import com.quanle.movie_sample_compose.ui.screen.components.Toolbar

@Composable
@Preview(showSystemUi = true, showBackground = true)
fun notificationScreenPreview() {
    NotificationScreen("asd", {}, {}, {})
}

@Composable
fun NotificationScreen(
    title: String,
    onBackActionClicked: () -> Unit,
    onNotificationClicked: () -> Unit,
    onOptionMenuClicked: () -> Unit
) { /** NotificationScreen with component **/

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 12.dp),
    ) {

        Toolbar(
            modifier = Modifier,
            title = title,
            primaryAction = R.drawable.ic_option,
            isMainRoute = false,
            onPrimaryActionClicked = {
                onOptionMenuClicked()
            },
            onBackActionClicked = {
                onBackActionClicked()
            }
        )

        Spacer(modifier = Modifier.height(12.dp))

        NotificationList(
            modifier = Modifier
                .height(120.dp)
                .fillMaxWidth(),
            onNotificationClicked = {
                onNotificationClicked()
            }
        )
    }

}

@Composable
fun NotificationList(
    modifier: Modifier,
    onNotificationClicked: () -> Unit
) {
    LazyColumn(
        contentPadding = PaddingValues(0.dp),
        content = {
            items(count = 20) {
                Movie(
                    modifier = modifier
                        .clickable {
                            onNotificationClicked()
                        }
                )
            }
        }
    )
}