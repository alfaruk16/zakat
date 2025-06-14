package com.muslimbd.zakat.features.presentation.zakat_calculator.components

import androidx.compose.foundation.Image
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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.muslimbd.zakat.R
import com.muslimbd.zakat.core.theme.BackGroundColor
import com.muslimbd.zakat.core.theme.Gray
import com.muslimbd.zakat.core.theme.Primary

@Composable
fun ZakatDialogue(
    total: String,
    zakat: String,
    onDismiss: () -> Unit
) {
    Dialog(onDismissRequest = { onDismiss() }) {
        Box(contentAlignment = Alignment.TopEnd) {
            Box(modifier = Modifier.padding(15.dp)) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(BackGroundColor, shape = RoundedCornerShape(20.dp))
                        .padding(20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Image(
                        painter = painterResource(id = R.drawable.zakat_calculator),
                        contentDescription = null,
                        modifier = Modifier
                            .size(60.dp)
                    )

                    Text(
                        text = "মোট সম্পদ: $total",
                        fontSize = 15.sp,
                        fontWeight = FontWeight.W500,
                        color = Gray,
                        modifier = Modifier.padding(bottom = 10.dp, top = 20.dp)
                    )
                    Text(
                        text = "যাকাত বাকী: $zakat",
                        fontSize = 15.sp,
                        fontWeight = FontWeight.W500,
                        color = Gray
                    )
                }
            }
            Box(modifier = Modifier
                .background(Primary, shape = CircleShape).padding(2.dp)
                .clickable {
                    onDismiss()
                }) {
                Icon(
                    Icons.Filled.Close, contentDescription = null,
                    modifier = Modifier.size(30.dp).padding(2.dp),
                    tint = Color.White
                )
            }
        }
    }
}