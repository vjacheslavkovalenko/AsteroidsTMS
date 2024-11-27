package by.vjacheslavkovalenko.asteroidstms.network.entity

import com.google.gson.annotations.SerializedName

data class PictureOfDayResponse(
    @SerializedName("title")
    val title: String,
    @SerializedName("url")
    val url: String,
    val explanation: String
)