package com.muslimbd.zakat.features.data.remote.model

data class TextContentDto(
    val `data`: TextContentDtoItem? = null,
    val error: Any? = null,
    val message: String? = null,
    val status: Int? = null,
    val totalPage: Int? = null,
    val totalRecords: Int? = null
)