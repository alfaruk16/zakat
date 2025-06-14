package com.muslimbd.zakat.features.presentation.zakat_calculator

data class ZakatCalculatorState(
    val isLoading: Boolean = false,
    val nagadTaka: String = "",
    val bankTaka: String = "",
    val shornoTaka: String = "",
    val rupaTaka: String = "",
    val shareBazarTaka: String = "",
    val onnanoBiniog: String = "",
    val bashaVara: String = "",
    val shompotti: String = "",
    val nagadBabsha: String = "",
    val ponno: String = "",
    val pension: String = "",
    val paribarikRin: String = "",
    val onnannoMuldhon: String = "",
    val krishiTaka: String = "",
    val creditCard: String = "",
    val gariPayment: String = "",
    val babshaPayment: String = "",
    val familyRin: String = "",
    val onnanoRin: String = "",
    val total: String = "",
    val zakat: String = ""
)