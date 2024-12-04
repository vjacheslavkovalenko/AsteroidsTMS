package by.vjacheslavkovalenko.asteroidstms.domain

import com.google.gson.annotations.SerializedName

data class PictureOfDay(
    @SerializedName("title")
    val title: String,
    @SerializedName("url")
    val url: String
)
