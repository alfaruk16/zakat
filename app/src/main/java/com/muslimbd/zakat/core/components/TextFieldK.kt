package com.muslimbd.zakat.core.components

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.muslimbd.zakat.core.theme.GrayExtraLight
import com.muslimbd.zakat.core.theme.GrayLight

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextFieldK(
    modifier: Modifier = Modifier,
    value: String,
    label: Int,
    onValueChange: (String) -> Unit,
    keyboardType: KeyboardType = KeyboardType.Text,
    leadingIcon: @Composable (() -> Unit)?,
    suffixIcon: @Composable (() -> Unit)? = null,
    error: String = "",
    visualTransformation: VisualTransformation = VisualTransformation.None,
    focusRequester: FocusRequester,
    onTap: (() -> Unit)? = null,
    onFocus: (() -> Unit)? = null,
    enabled: Boolean = true,
    singleLine: Boolean = true,
    height: Dp = 60.dp,
    fontSize: TextUnit = 20.sp
) {
    val interactionSource = remember { MutableInteractionSource() }

    Column(modifier = modifier) {
        BasicTextField(
            value = value,
            onValueChange = { onValueChange(it) },
            textStyle = TextStyle(fontSize = fontSize),
            modifier = Modifier
                .fillMaxWidth()
                .border(
                    width = 1.dp,
                    color = GrayExtraLight,
                    shape = RoundedCornerShape(10.dp)
                )
                .focusRequester(focusRequester)
                .onFocusChanged {
                    if (onFocus != null)
                        onFocus()
                }
                .clickable {
                    if (onTap != null)
                        onTap()

                }
                .height(height),
            keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
            visualTransformation = visualTransformation,
            enabled = enabled,
        ) { innerTextField ->
            TextFieldDefaults.DecorationBox(
                value = value,
                innerTextField = innerTextField,
                enabled = enabled,
                singleLine = singleLine,
                visualTransformation = visualTransformation,
                interactionSource = interactionSource,
                contentPadding = PaddingValues(0.dp),
                shape = RoundedCornerShape(10.dp),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.White,
                    unfocusedContainerColor = Color.White,
                    disabledContainerColor = Color.White,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent,
                ),
                leadingIcon = leadingIcon,
                placeholder = { Text(text = stringResource(id = label), fontSize = fontSize, color = GrayLight) },
                suffix = suffixIcon
            )
        }

        if (error.isNotEmpty()) {
            Text(text = error, fontSize = 12.sp, color = Color.Red)
        }
    }
}