package com.muslimbd.zakat.features.presentation.donate

import androidx.compose.ui.graphics.Color


data class DonateState(
    val isLoading: Boolean = false,
    val amounts: List<String> = listOf("50", "100", "200", "500"),
    val amount: String = "100",
    val isValidate: Boolean = false,
    val colors: List<List<Color>> = listOf(
        listOf(Color(0xFFFF8787), Color(0xFFC16A6A)),
        listOf(Color(0xFFFFCF87), Color(0xFFCA9547)),
        listOf(Color(0xFF39A8A8), Color(0xFF11D7BF)),
        listOf(Color(0xFFAF1DA9), Color(0xFFD21CD6))
    )
)