package com.muslimbd.zakat.core.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.muslimbd.zakat.R
import com.muslimbd.zakat.core.theme.Primary

@Composable
fun Bismillah(width: Dp, icon: Int = R.drawable.bismillah, background: Int? = null) {

    if (background != null)
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    color = Primary,
                    shape = RoundedCornerShape(bottomStart = 20.dp, bottomEnd = 20.dp)
                )
                .height(width),
            ) {
            Image(
                painter = painterResource(id = background), contentDescription = null,
                modifier = Modifier.fillMaxSize()
            )
        }
    else
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    color = Primary,
                    shape = RoundedCornerShape(bottomStart = 20.dp, bottomEnd = 20.dp)
                )
                .padding(10.dp)
                .height(width),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Spacer(modifier = Modifier.height(10.dp))
            Image(
                painter = painterResource(id = icon), contentDescription = null,
                modifier = Modifier
                    .padding(bottom = 10.dp, start = 50.dp, end = 50.dp, top = 10.dp)
                    .fillMaxWidth()
                    .weight(1f)
            )
            Spacer(modifier = Modifier.height(50.dp))
        }
}