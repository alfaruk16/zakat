package com.muslimbd.zakat.features.presentation.donate

import android.app.Application
import android.os.Build
import androidx.annotation.RequiresExtension
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.muslimbd.zakat.core.util.Async
import com.muslimbd.zakat.features.data.remote.entity.SSL
import com.muslimbd.zakat.features.domain.use_case.InitiateSSLPayUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
@HiltViewModel
class DonateViewModel @Inject constructor(
    private val initiateSSLPayUseCase: InitiateSSLPayUseCase, application: Application
) :
    AndroidViewModel(application) {


    private val _state = MutableStateFlow(DonateState())
    val state: StateFlow<DonateState> = _state.asStateFlow()

    fun donateChanged(it: String) {
        _state.value = state.value.copy(amount = it)
    }

    fun amountChange(it: String) {
        _state.value = state.value.copy(amount = it)
    }

    fun signUp(navToSSL: (String) -> Unit) {
        _state.value = state.value.copy(isValidate = true)
        if (state.value.amount.isNotEmpty() && !state.value.isLoading) {
            _state.value = state.value.copy(isLoading = true)

            initiateSSLPayUseCase.invoke(
                SSL(amount = state.value.amount)
            ).onEach { result ->
                when (result) {
                    is Async.Success -> {
                        _state.value = state.value.copy(isLoading = false)
                        navToSSL(result.data?.GatewayPageURL ?: "")
                    }

                    is Async.Loading -> _state.value = state.value.copy(isLoading = true)
                    is Async.Error -> _state.value = state.value.copy(isLoading = false)
                }

            }.launchIn(viewModelScope)

        }
    }

}