package com.muslimbd.zakat.core.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.muslimbd.zakat.core.theme.Primary

@Composable
fun AppName() {
    val annotatedString = buildAnnotatedString {
        withStyle(style = SpanStyle(Color.Black)) {
            append("Al Quran")
        }
    }
    Box(modifier = Modifier.padding(bottom = 5.dp)) {
        Text(text = annotatedString)
    }
}

@Composable
fun AppNameNavBar() {
    val annotatedString = buildAnnotatedString {
        withStyle(style = SpanStyle(Color.Black)) {
            append("мυѕℓιм")
        }
        withStyle(style = SpanStyle(Primary)) {
            append("в")
        }
        withStyle(style = SpanStyle(Color.Red)) {
            append("ᴅ")
        }
    }
    Text(text = annotatedString)
}

@Composable
fun AppNameBody(fontSize: Int = 32) {
    val annotatedString = buildAnnotatedString {
        withStyle(style = SpanStyle(Color.Black, fontSize = fontSize.sp, fontWeight = FontWeight.W600)) {
            append("мυѕℓιм")
        }
        withStyle(style = SpanStyle(Primary, fontSize = fontSize.sp, fontWeight = FontWeight.W600)) {
            append("в")
        }
        withStyle(style = SpanStyle(Color.Red, fontSize = fontSize.sp, fontWeight = FontWeight.W600)) {
            append("ᴅ")
        }
    }
    Text(text = annotatedString)
}

@Composable
fun AppNameStart(fontSize: Int = 32) {
    val annotatedString = buildAnnotatedString {
        withStyle(style = SpanStyle(Color.White, fontSize = fontSize.sp, fontWeight = FontWeight.W600)) {
            append("мυѕℓιм")
        }
        withStyle(style = SpanStyle(Color.Green, fontSize = fontSize.sp, fontWeight = FontWeight.W600)) {
            append("в")
        }
        withStyle(style = SpanStyle(Color.Red, fontSize = fontSize.sp, fontWeight = FontWeight.W600)) {
            append("ᴅ")
        }
    }
    Text(text = annotatedString)
}