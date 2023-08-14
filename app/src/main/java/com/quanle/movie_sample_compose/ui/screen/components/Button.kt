package com.quanle.movie_sample_compose.ui.screen.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonColors
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
@Preview
fun LayoutButtonPreview() {
    LayoutButton(
        modifier = Modifier,
        primaryContent = "asdasd",
        secondaryContent = "qwe",
        onPrimaryActionClicked =  {}
    )
}

@Composable
fun LayoutButton(
    modifier: Modifier,
    primaryContent: String,
    onPrimaryActionClicked: () -> Unit,
    secondaryContent: String? = null,
    onSecondaryActionClicked: (() -> Unit)? = null,
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {

        secondaryContent?.let { secondaryText ->
            SingleButton(
                text = secondaryText,
                actionClicked = { onSecondaryActionClicked?.invoke() },
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color(0xFFFCE7E9),
                    contentColor = Color.Red,
                ),
                modifier = Modifier
                    .weight(1f)
                    .padding(
                        end = 4.dp,
                        start = 12.dp
                    )
            )
        }

        SingleButton(
            text = primaryContent,
            actionClicked = { onPrimaryActionClicked.invoke() },
            modifier = Modifier
                .weight(1f)
                .padding(
                    end = if (secondaryContent != null) 12.dp else 0.dp,
                    start = if (secondaryContent != null) 4.dp else 0.dp
                )
        )
    }
}

@Composable
fun SingleButton(
    modifier: Modifier = Modifier,
    actionClicked: () -> Unit,
    text: String,
    colors: ButtonColors = ButtonDefaults.buttonColors(
        backgroundColor = Color.Red,
        contentColor = Color.White
    )
) {
    Button(
        modifier = modifier.fillMaxWidth(),
        onClick = { actionClicked() },
        shape = RoundedCornerShape(20.dp),
        elevation = ButtonDefaults.elevation(),
        colors = colors,
        content = {
            Text(
                text = text,
                modifier = Modifier.padding(vertical = 4.dp)
            )
        }
    )
}