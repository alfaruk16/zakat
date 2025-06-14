package com.muslimbd.zakat.features.presentation.donate.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForwardIos
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.muslimbd.zakat.R
import com.muslimbd.zakat.core.theme.Gray
import com.muslimbd.zakat.core.theme.GrayLight
import com.muslimbd.zakat.core.theme.Primary
import com.muslimbd.zakat.core.util.Common

@Composable
fun DonateButton(amount: String, isLoading: Boolean, navToSSL: () -> Unit) {

    Box(
        modifier = Modifier
            .padding(horizontal = 5.dp)
            .background(
                color = if (amount.isNotEmpty() && !isLoading) Color.Transparent else GrayLight,
                shape = RoundedCornerShape(8.dp)
            ).border(2.dp, Primary, RoundedCornerShape(10))
            .fillMaxWidth()
            .clickable {
                navToSSL()
            }
            .height(100.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Card(
                colors = CardDefaults.cardColors(Color.White),
                modifier = Modifier
                    .padding(horizontal = 10.dp, vertical = 7.dp)
                    .height(50.dp),
                elevation = CardDefaults.cardElevation(5.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .padding(horizontal = 15.dp)
                        .padding(top = 10.dp, bottom = 5.dp)
                ) {
                    Image(
                        painterResource(id = R.drawable.ssl),
                        contentDescription = null,
                        contentScale = ContentScale.Fit,
                        modifier = Modifier.size(30.dp)
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    Text(
                        text = Common.mfs,
                        color = Gray,
                        modifier = Modifier.weight(1f),
                        fontWeight = FontWeight.W600
                    )
                }

            }
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = stringResource(id = R.string.donation_process),
                    color = Color.Black,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.W500,
                    modifier = Modifier.padding(start = 15.dp)
                )
                Icon(Icons.AutoMirrored.Filled.ArrowForwardIos, contentDescription = null,
                    modifier = Modifier.size(18.dp).padding(start = 5.dp),
                    tint = Color.Black)
            }
        }

    }


}