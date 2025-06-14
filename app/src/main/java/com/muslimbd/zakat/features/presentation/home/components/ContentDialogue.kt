package com.muslimbd.zakat.features.presentation.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.muslimbd.zakat.core.theme.BackGroundColor
import com.muslimbd.zakat.core.theme.Primary
import com.muslimbd.zakat.features.data.remote.model.TextContentDtoItem

@Composable
fun ContentDialogue(
    content: TextContentDtoItem,
    textFontSize: Int,
    arabicFontSize: Int,
    increase: () -> Unit,
    decrease: () -> Unit,
    onDismiss: () -> Unit
) {
    Dialog(onDismissRequest = { onDismiss() }) {
        Box(contentAlignment = Alignment.TopEnd) {

            Box(modifier = Modifier.padding(15.dp)) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(BackGroundColor, shape = RoundedCornerShape(20.dp))
                        .padding(15.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    ContentDetails(
                        content = content,
                        textFontSize = textFontSize,
                        arabicFontSize = arabicFontSize,
                        increase = increase,
                        decrease = decrease
                    )
                }
            }

            Box(modifier = Modifier.clickable {
                onDismiss()
            }) {
                Icon(
                    Icons.Default.Close, contentDescription = null,
                    modifier = Modifier
                        .background(Primary, CircleShape)
                        .padding(2.dp)
                        .size(30.dp),
                    tint = Color.White
                )
            }
        }
    }
}