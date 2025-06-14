package com.muslimbd.zakat.core.util

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import com.muslimbd.zakat.core.theme.BackGroundDark
import com.muslimbd.zakat.core.theme.GradientColor1
import com.muslimbd.zakat.core.theme.GradientColor2
import com.muslimbd.zakat.core.theme.Primary


object Common {
    fun getImageColor(id: String?): Color {

        if (id != null) {
            val regex = "-?[0-9]+(\\.[0-9]+)?".toRegex()

            if (id.matches(regex)) {
                when (id.toInt() % 10) {
                    0 -> {
                        return Primary.copy(alpha = .5f)
                    }

                    1 -> {
                        return Color.DarkGray.copy(alpha = .5f)
                    }

                    2 -> {
                        return BackGroundDark.copy(alpha = .5f)
                    }

                    3 -> {
                        GradientColor1
                    }

                    4 -> {
                        return GradientColor2
                    }

                    5 -> {
                        return Primary.copy(alpha = .5f)
                    }

                    6 -> {
                        return Color.DarkGray.copy(alpha = .5f)
                    }

                    7 -> {
                        return BackGroundDark.copy(alpha = .5f)
                    }

                    8 -> {
                        return GradientColor1
                    }

                    9 -> {
                        return GradientColor2
                    }
                }
            }
        }

        return Primary.copy(alpha = .5f)
    }

    val mfs = buildAnnotatedString {
        withStyle(style = SpanStyle(Color(0xFFE2136E))) {
            append("বি")
        }
        append("কাশ/ ")
        withStyle(style = SpanStyle(Color(0xFFEA1D25))) {
            append("ন")
        }
        append("গদ/ ")
        withStyle(style = SpanStyle(Color(0xFF89288F))) {
            append("র")
        }
        append("কেট/ ")
        withStyle(style = SpanStyle(Color(0xFF295CAB))) {
            append("ব্যাং")
        }
        append("ক")
    }
}