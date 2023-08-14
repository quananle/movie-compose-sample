package com.quanle.movie_sample_compose.ui.screen.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldColors
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.quanle.movie_sample_compose.R
import com.quanle.movie_sample_compose.utils.wtf

@Composable
@Preview
fun InputViewPreview() {
    var textSas by remember {
        mutableStateOf("")
    }
    InputView(
        modifier = Modifier.fillMaxWidth(),
        hint = "Le Anh Quan",
        text = textSas,
        onTextChanged = {textSas = it},
        onFocusCleared = {},
        isFocusCleared = false
    )
}

// TODO 14 08 23: make FocusCleared cleaner
/**
 * WARNING: Clear focus when clicking outside causes multiple callbacks.
 **/
@Composable
fun InputView(
    modifier: Modifier,
    isFocusCleared: Boolean,
    onFocusCleared: () -> Unit,
    hint: String,
    text: String,
    onTextChanged: (String) -> Unit,
    maxLines: Int = 1,
    keyboardType: KeyboardType = KeyboardType.Text,
    imeAction: ImeAction = ImeAction.Done,
    textFieldVisualTransformation: VisualTransformation = VisualTransformation.None,
    singleLine: Boolean = true,
    readOnly: Boolean = false,
    onDone: (() -> Unit)? = null,
    onSend: ((String) -> Unit)? = null,
    onSearch: ((String) -> Unit)? = null,
    @DrawableRes leadingIcon: Int? = null,
    @DrawableRes trailingIcon: Int? = null
) {

    var isFocused by remember { mutableStateOf(false) }
    val focusManager = LocalFocusManager.current

    OutlinedTextField(
        modifier = modifier.onFocusChanged { isFocused = it.hasFocus },
        value = text,
        onValueChange = { textInput -> onTextChanged(textInput) },
        singleLine = singleLine,
        maxLines = maxLines,
        shape = RoundedCornerShape(8.dp),
        readOnly = readOnly,
        colors = TextFieldDefaults.outlinedTextFieldColors(
            textColor = Color.Black,
            cursorColor = Color.Black,
            backgroundColor = if (isFocused) Color(0xFFFCE7E9) else Color(0xFFFAFAFA),
            focusedBorderColor = Color.Red,
            unfocusedBorderColor = Color.Transparent
        ),
        leadingIcon = if (leadingIcon != null) {
            @Composable {
                Icon(
                    painter = painterResource(id = leadingIcon),
                    contentDescription = "",
                    tint = if (isFocused) Color.Red else Color.LightGray
                )
            }
        } else null,
        trailingIcon = if (trailingIcon != null) {
            @Composable {
                Icon(
                    painter = painterResource(id = trailingIcon),
                    contentDescription = "",
                    tint = if (isFocused) Color.Red else Color.LightGray
                )
            }
        } else null,
        placeholder = {
            Text(
                text = if (isFocused) "" else hint,
                color = Color.LightGray
            )
        },
        visualTransformation = textFieldVisualTransformation,
        keyboardOptions = KeyboardOptions(
            keyboardType = keyboardType,
            imeAction = imeAction
        ),
        keyboardActions = KeyboardActions(
            onDone = {
                onDone?.invoke()
                focusManager.clearFocus(true)
            },
            onSearch = {
                onSearch?.invoke(text)
                focusManager.clearFocus(false)
            },
            onSend = {
                onSend?.invoke(text)
                focusManager.clearFocus(true)
            }
        )
    )

    if (isFocusCleared) {
        focusManager.clearFocus()
        onFocusCleared()
        when(imeAction) {
            ImeAction.Done -> onDone?.invoke()
            ImeAction.Send -> onSend?.invoke(text)
            ImeAction.Search -> onSearch?.invoke(text)
        }
    }
}


