package com.muslimbd.zakat.features.presentation.home

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import com.muslimbd.zakat.R
import com.muslimbd.zakat.core.util.AppConstants
import com.muslimbd.zakat.core.util.Async
import com.muslimbd.zakat.core.util.LocalConstant
import com.muslimbd.zakat.features.data.remote.model.CategoryContentsDto
import com.muslimbd.zakat.features.data.remote.model.CategoryDtoItem
import com.muslimbd.zakat.features.data.remote.model.TextContentDtoItem
import com.muslimbd.zakat.features.domain.use_case.GetCategoryContentsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getSCategoryContents: GetCategoryContentsUseCase,
    savedStateHandle: SavedStateHandle, application: Application
) :
    AndroidViewModel(application) {

    private val _state = MutableStateFlow(HomeState())
    val state: StateFlow<HomeState> = _state.asStateFlow()

    private val category = CategoryDtoItem(
        name = AppConstants.zakat, icon = R.drawable.zakat,
        id = AppConstants.zakatId
    )

    private val sharedPreferences =
        application.getSharedPreferences(LocalConstant.sharedPreferences, Context.MODE_PRIVATE)

    init {
        init()
    }

    fun init() {
        getSubCategories(id = category.id ?: "")
    }

    private fun getSubCategories(id: String) {
        getSCategoryContents(id).onEach { result ->
            when (result) {
                is Async.Success -> {

                    _state.value = HomeState(
                        categoryContents = result.data ?: CategoryContentsDto(),
                        isLoading = false
                    )
                }

                is Async.Error -> {
                    _state.value = state.value.copy(isLoading = false)
                }

                else -> {}
            }
        }.launchIn(viewModelScope)
    }

    fun itemSelected(categoryItem: TextContentDtoItem?) {
        if (state.value.currentContent.id == categoryItem?.id) {
            _state.value = state.value.copy(currentContent = TextContentDtoItem())
        } else {
            _state.value = state.value.copy(currentContent = categoryItem ?: TextContentDtoItem())
        }
    }

    fun closeContentDialogue() {
        _state.value = state.value.copy(currentContent = TextContentDtoItem())
    }

    fun decrease() {
        if (state.value.textFontSize > 16) {
            _state.value = state.value.copy(
                textFontSize = state.value.textFontSize - 2,
                arabicFontSize = state.value.arabicFontSize - 2
            )
            val editor: SharedPreferences.Editor = sharedPreferences.edit()
            editor.putInt(LocalConstant.arabicFontSize, state.value.arabicFontSize)
            editor.putInt(LocalConstant.textFontSize, state.value.textFontSize)
            editor.apply()
        }
    }

    fun increase() {
        if (state.value.textFontSize < 30) {
            _state.value = state.value.copy(
                textFontSize = state.value.textFontSize + 2,
                arabicFontSize = state.value.arabicFontSize + 2
            )
            val editor: SharedPreferences.Editor = sharedPreferences.edit()
            editor.putInt(LocalConstant.arabicFontSize, state.value.arabicFontSize)
            editor.putInt(LocalConstant.textFontSize, state.value.textFontSize)
            editor.apply()
        }
    }
}