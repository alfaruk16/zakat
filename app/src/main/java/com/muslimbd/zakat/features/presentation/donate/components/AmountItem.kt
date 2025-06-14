package com.muslimbd.zakat.features.presentation.donate.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircleOutline
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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
import com.muslimbd.zakat.R
import com.muslimbd.zakat.core.theme.Primary

@Composable
fun AmountItem(
    amount: String,
    currentAmount: String,
    color: List<Color>,
    onSelect: (String) -> Unit
) {

    Card(
        colors = CardDefaults.cardColors(Color.Transparent),
        shape = RoundedCornerShape(15.dp),
        modifier = Modifier.padding(horizontal = 25.dp)
    ) {
        Box(contentAlignment = Alignment.TopEnd) {
            Box(
                modifier = Modifier
                    .clickable {
                        onSelect(amount)
                    }
                    .padding(horizontal = 5.dp, vertical = 5.dp)
                    .border(2.dp, Primary, shape = RoundedCornerShape(15))
            ) {
                Image(
                    painter = painterResource(id = R.drawable.taka), contentDescription = null,
                    modifier = Modifier
                        .size(24.dp)
                        .padding(5.dp)
                )

                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .padding(horizontal = 10.dp, vertical = 10.dp)
                        .fillMaxSize(),
                ) {
                    Text(
                        text = amount,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.W500,
                        color = Color.Black
                    )
                }
            }
            if (amount == currentAmount)
                Icon(
                    Icons.Default.CheckCircleOutline, contentDescription = null,
                    tint = Color.Black,
                    modifier = Modifier.size(24.dp)
                )
        }
    }

}