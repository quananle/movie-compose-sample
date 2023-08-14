package com.quanle.movie_sample_compose.ui.screen.components

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.width
import androidx.compose.material.Chip
import androidx.compose.material.ChipDefaults
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
@Preview
fun chipPreview() {
   Row(
       Modifier.fillMaxSize(),
       verticalAlignment = Alignment.CenterVertically,
       horizontalArrangement = Arrangement.Center
   ) {
       ChipComponent(content = "asdasd", isSelected =  true)
       Spacer(modifier = Modifier.width(12.dp))
       ChipComponent(content = "uiouiou",isSelected =  false)
   }
}


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ChipComponent(
    modifier: Modifier = Modifier,
    content: String,
    isSelected: Boolean
) {
    Chip(
        onClick = { /* Do something! */ },
        colors =
        if (!isSelected)
            ChipDefaults.chipColors(
                backgroundColor = Color.White,
                contentColor = Color.Red
            )
        else
            ChipDefaults.chipColors(
                backgroundColor = Color.Red,
                contentColor = Color.White
            ),
        border =
        if (!isSelected)
            BorderStroke(
                ChipDefaults.OutlinedBorderSize,
                Color.Red
            )
        else null,
        modifier = Modifier.padding(end = 4.dp)
    ) {
        Text(
            text = content,
            modifier = modifier.padding(
                vertical = 4.dp,
                horizontal = 8.dp
            )
        )
    }
}