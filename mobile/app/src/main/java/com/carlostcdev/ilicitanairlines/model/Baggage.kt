package com.carlostcdev.ilicitanairlines.model

import com.carlostcdev.ilicitanairlines.ui.enums.BaggageType

data class Baggage(
    val id: Long,
    val name: String,
    val type: BaggageType,
    val weight: Double,
    val height: Int,
    val width: Int,
    val length: Int,
    val price: Double,
    val included: Boolean = false
)