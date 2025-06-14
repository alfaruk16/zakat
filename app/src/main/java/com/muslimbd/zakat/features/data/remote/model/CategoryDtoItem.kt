package com.muslimbd.zakat.features.data.remote.model

import javax.annotation.concurrent.Immutable

@Immutable
data class CategoryDtoItem(
    val about: String? = null,
    val appLanguage: String? = null,
    val code: String? = null,
    val contentBaseUrl: String? = null,
    val createdBy: String? = null,
    val createdOn: String? = null,
    val id: String? = null,
    val imageUrl: String? = null,
    val isActive: Boolean? = null,
    val name: String? = null,
    val sequenceNo: Int? = null,
    val updatedBy: String? = null,
    val updatedOn: String? = null,
    val userFavouritedThis: Boolean? = null,
    val hasSubCategory: Boolean = false,
    val icon: Int? = null,
    val selectedTab: Int? = null,
    val totalContent: Int? = null,
    val category: String? = null,
    val isShortByPopular: Boolean? = null,
    val isShortByFavorite: Boolean? = null,
    val image: Int? = null,
    val isPremium: Boolean? = null
)