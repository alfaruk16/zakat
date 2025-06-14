package com.muslimbd.zakat.features.presentation.zakat_calculator

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class ZakatCalculatorViewModel @Inject constructor() :
    ViewModel() {

    private val _state = MutableStateFlow(ZakatCalculatorState())
    val state: StateFlow<ZakatCalculatorState> = _state.asStateFlow()

    fun nagadTakaChange(taka: String) {
        _state.value = state.value.copy(nagadTaka = taka)
    }

    fun bangkTakaChange(taka: String) {
        _state.value = state.value.copy(bankTaka = taka)
    }

    fun shornoTakaChange(taka: String) {
        _state.value = state.value.copy(shornoTaka = taka)
    }

    fun rupaTakaChange(taka: String) {
        _state.value = state.value.copy(rupaTaka = taka)
    }

    fun shareBazarTakaChange(taka: String) {
        _state.value = state.value.copy(shareBazarTaka = taka)
    }

    fun onnannoBiniogTakaChange(taka: String) {
        _state.value = state.value.copy(onnanoBiniog = taka)
    }

    fun bashaVaraTakaChange(taka: String) {
        _state.value = state.value.copy(bashaVara = taka)
    }

    fun shommottiTakaChange(taka: String) {
        _state.value = state.value.copy(shompotti = taka)
    }

    fun nagadBabshaChange(taka: String) {
        _state.value = state.value.copy(nagadBabsha = taka)
    }

    fun ponnoTakaChange(taka: String) {
        _state.value = state.value.copy(ponno = taka)
    }

    fun pensionTakaChange(taka: String) {
        _state.value = state.value.copy(pension = taka)
    }

    fun paribarikTakaChange(taka: String) {
        _state.value = state.value.copy(paribarikRin = taka)
    }

    fun onnannoMuldhonTakaChange(taka: String) {
        _state.value = state.value.copy(onnannoMuldhon = taka)
    }

    fun krishiTakaChange(taka: String) {
        _state.value = state.value.copy(krishiTaka = taka)
    }

    fun creditTakaChange(taka: String) {
        _state.value = state.value.copy(creditCard = taka)
    }

    fun gariPaymentTakaChange(taka: String) {
        _state.value = state.value.copy(gariPayment = taka)
    }

    fun babshaPaymentTakaChange(taka: String) {
        _state.value = state.value.copy(babshaPayment = taka)
    }

    fun familyRinTakaChange(taka: String) {
        _state.value = state.value.copy(familyRin = taka)
    }

    fun onnanoRinTakaChange(taka: String) {
        _state.value = state.value.copy(onnanoRin = taka)
    }

    fun calculateZakat() {
        val total = (addAll(
            listOf(
                state.value.nagadTaka,
                state.value.bankTaka,
                state.value.shornoTaka,
                state.value.rupaTaka,
                state.value.shareBazarTaka,
                state.value.onnanoBiniog,
                state.value.bashaVara,
                state.value.shompotti,
                state.value.nagadBabsha,
                state.value.ponno,
                state.value.pension,
                state.value.paribarikRin,
                state.value.onnannoMuldhon,
                state.value.krishiTaka
            )
        ) - addAll(
            listOf(
                state.value.creditCard,
                state.value.gariPayment,
                state.value.babshaPayment,
                state.value.familyRin,
                state.value.onnanoRin
            )
        ))
        val zakat = total * 2.5 / 100
        _state.value = state.value.copy(zakat = zakat.toString(), total = total.toString())
    }

    private fun addAll(numbers: List<String>): Int {
        var sum = 0
        for (num in numbers) {
            try {
                sum += num.toInt()
            } catch (e: Exception) {
                println(e.message)
            }
        }
        return sum
    }

    fun closeZakatDialogu() {
        _state.value = state.value.copy(total = "", zakat = "")
    }
}