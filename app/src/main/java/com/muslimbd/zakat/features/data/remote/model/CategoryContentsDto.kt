package com.muslimbd.zakat.features.data.remote.model

data class CategoryContentsDto(
    val `data`: List<TextContentDtoItem>? = null,
    val error: Any? = null,
    val message: String? = null,
    val status: Int? = null,
    val totalPage: Int? = null,
    val totalRecords: Int? = null
)