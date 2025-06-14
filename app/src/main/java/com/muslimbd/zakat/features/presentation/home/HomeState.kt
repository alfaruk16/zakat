package com.muslimbd.zakat.features.presentation.home

import com.muslimbd.zakat.features.data.remote.model.CategoryContentsDto
import com.muslimbd.zakat.features.data.remote.model.TextContentDtoItem


data class HomeState(
    val isLoading: Boolean = true,
    val categoryContents: CategoryContentsDto = CategoryContentsDto(),
    val currentContent: TextContentDtoItem = TextContentDtoItem(),
    val arabicFontSize: Int = 24,
    val textFontSize: Int = 20
)