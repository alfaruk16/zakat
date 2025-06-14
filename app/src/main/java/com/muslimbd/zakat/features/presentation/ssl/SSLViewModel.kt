package com.muslimbd.zakat.features.presentation.ssl

import android.app.Application
import android.content.Context.MODE_PRIVATE
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import com.muslimbd.zakat.core.util.LocalConstant
import com.muslimbd.zakat.features.presentation.ScreenArgs
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class SSLViewModel @Inject constructor(
    application: Application,
    savedStateHandle: SavedStateHandle
) : AndroidViewModel(application) {

    private val _state = MutableStateFlow(SSLState())
    val state: StateFlow<SSLState> = _state.asStateFlow()

    private val url: String = checkNotNull(savedStateHandle[ScreenArgs.TITLE] ?: "")

    private val sharedPreferences =
        application.getSharedPreferences(LocalConstant.sharedPreferences, MODE_PRIVATE)

    init {
        viewModelScope.launch {
            _state.value = state.value.copy(
                url = url,
                user = sharedPreferences.getString(LocalConstant.mobile, "") ?: ""
            )
        }
    }

    fun onPageLoaded() {
        _state.value = state.value.copy(isLoading = false)
    }


}