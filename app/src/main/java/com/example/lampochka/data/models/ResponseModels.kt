package com.example.lampochka.data.models

data class GetBrightnessLevelDto(
    val max: Int,
    val min: Int,
    val precision: Int,
)

data class GetColorsDto(
    val id: Int,
    val name: String,
    val type: String,
    val color: String,
)

data class GetCurrentColorDto(
    val id: Int,
    val name: String,
    val type: String,
    val color: String,
)


