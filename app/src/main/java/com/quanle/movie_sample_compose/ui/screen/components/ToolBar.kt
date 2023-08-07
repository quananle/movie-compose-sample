package com.quanle.movie_sample_compose.ui.screen.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.quanle.movie_sample_compose.R

// TODO: Configure this throughout the entire app, not just on a single screen

@Preview
@Composable
fun toolbarPreview() {
    Toolbar(
        modifier = Modifier,
        isMainRoute = false,
        title = "Configure this throughout the entire app",
        primaryAction = R.drawable.ic_search,

    )

}

@Composable
fun Toolbar(
    modifier: Modifier,
    title: String? = null,
    isMainRoute: Boolean = true,
    onBackActionClicked: (() -> Unit)? = null,
    onPrimaryActionClicked: (() -> Unit)? = null,
    onSecondaryActionClicked: (() -> Unit)? = null,
    @DrawableRes primaryAction: Int? = null,
    @DrawableRes secondaryAction: Int? = null
) {
    
    Row (
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {

        if (isMainRoute) {
            Image(
                painter = painterResource(id = R.drawable.app_icon),
                contentDescription = "App Icon",
                modifier = Modifier.size(40.dp)
            )
        } else {
            Image(
                painter = painterResource(id = R.drawable.ic_back),
                contentDescription = "App Icon",
                modifier = Modifier
                    .size(32.dp)
                    .clickable {
                        onBackActionClicked?.invoke()
                    }
            )
        }

        Text(
            text = title ?: "",
            fontSize = 20.sp,
            fontWeight = FontWeight(600),
            maxLines = 1,
            modifier = Modifier
                .weight(1f)
                .padding(12.dp)
        )

        primaryAction?.let { drawableAction ->
            Icon(
                painter = painterResource(id = drawableAction),
                contentDescription = "App Icon",
                modifier = Modifier
                    .size(26.dp)
                    .clickable {
                        onPrimaryActionClicked?.invoke()
                    }
            )
        }

        secondaryAction?.let { drawableAction ->
            Spacer(modifier = Modifier.width(20.dp))

            Icon(
                painter = painterResource(id = drawableAction),
                contentDescription = "App Icon",
                modifier = Modifier
                    .size(28.dp)
                    .clickable {
                        onSecondaryActionClicked?.invoke()
                    }
            )
        }
    }
}