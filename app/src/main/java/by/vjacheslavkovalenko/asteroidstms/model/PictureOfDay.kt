package by.vjacheslavkovalenko.asteroidstms.model

import com.google.gson.annotations.SerializedName

data class PictureOfDay(
    @SerializedName("title")
    val title: String,
    @SerializedName("url")
    val url: String,
    @SerializedName("explanation")
    val explanation: String
)
