package com.muslimbd.zakat.features.presentation.home.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
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
import com.muslimbd.zakat.features.data.remote.model.TextContentDtoItem

@Composable
fun ContentItem(
    categoryItem: TextContentDtoItem?,
    itemSelected: (TextContentDtoItem?) -> Unit,
    currentContent: TextContentDtoItem
) {
    Card(
        Modifier
            .fillMaxWidth()
            .clickable {
                itemSelected(categoryItem ?: TextContentDtoItem())
            },
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(containerColor = Primary),
        elevation = CardDefaults.cardElevation(2.dp)
    ) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.BottomEnd) {
            Row(
                Modifier.padding(
                    start = 18.dp,
                    end = 15.dp,
                    top = 18.dp,
                    bottom = 18.dp
                ),
                verticalAlignment = Alignment.CenterVertically
            ) {

                Spacer(modifier = Modifier.width(12.dp))
                Text(
                    text = categoryItem?.title ?: "",
                    fontSize = 20.sp,
                    color = Color.White,
                    modifier = Modifier.weight(1f),
                    maxLines = 2,
                    minLines = 2,
                    fontWeight = if (categoryItem?.id == currentContent.id) FontWeight.W600 else FontWeight.W400
                )
                Spacer(modifier = Modifier.width(12.dp))

            }

            Icon(painter = painterResource(id = R.drawable.zakat), contentDescription = null,
                tint = Color.White,
                modifier = Modifier.size(24.dp).padding(3.dp))
        }
    }
}