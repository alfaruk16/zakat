package com.muslimbd.zakat.features.presentation.home.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.muslimbd.zakat.core.components.FontSize
import com.muslimbd.zakat.core.theme.Gray
import com.muslimbd.zakat.core.theme.GrayLight
import com.muslimbd.zakat.features.data.remote.model.TextContentDtoItem

@Composable
fun ContentDetails(
    content: TextContentDtoItem?,
    textFontSize: Int,
    arabicFontSize: Int,
    increase: () -> Unit,
    decrease: () -> Unit
) {

    Column(
        modifier = Modifier
            .padding(horizontal = 5.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(modifier = Modifier.fillMaxWidth()) {
            FontSize(increase = increase, decrease = decrease)
        }
        Spacer(modifier = Modifier.height(12.dp))
        Text(
            text = content?.title ?: "",
            fontSize = 20.sp,
            color = Gray,
            fontWeight = FontWeight.W600
        )
        Spacer(modifier = Modifier.height(12.dp))
        if (!content?.text.isNullOrEmpty())
            Text(
                text = content?.text ?: "",
                color = Gray,
                lineHeight = 28.sp,
                fontSize = textFontSize.sp,
                textAlign = TextAlign.Justify
            )
        if (!content?.textInArabic.isNullOrEmpty())
            Text(
                text = content?.textInArabic
                    ?: "",
                color = Gray,
                lineHeight = 30.sp,
                fontSize = arabicFontSize.sp,
                style = TextStyle(
                    textDirection = TextDirection.Content
                ),
                modifier = Modifier.padding(top = 10.dp),
                fontWeight = FontWeight.W600
            )

        if (!content?.pronunciation.isNullOrEmpty())
            Text(
                text = content?.pronunciation
                    ?: "",
                color = Gray,
                lineHeight = 28.sp,
                fontSize = textFontSize.sp,
                modifier = Modifier.padding(top = 10.dp),
                textAlign = TextAlign.Justify
            )

        if (!content?.address.isNullOrEmpty())
            Text(
                text = content?.address
                    ?: "",
                color = Gray,
                lineHeight = 28.sp,
                fontSize = textFontSize.sp,
                modifier = Modifier.padding(top = 10.dp),
                textAlign = TextAlign.Justify
            )

        if (!content?.refUrl.isNullOrEmpty())
            Text(
                text = content?.refUrl ?: "",
                color = GrayLight,
                modifier = Modifier.padding(top = 20.dp),
                textAlign = TextAlign.Justify
            )

        Spacer(modifier = Modifier.height(10.dp))

    }


}