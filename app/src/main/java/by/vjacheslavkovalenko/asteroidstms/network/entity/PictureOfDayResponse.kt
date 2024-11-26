package by.vjacheslavkovalenko.asteroidstms.network.entity

import com.google.gson.annotations.SerializedName

data class PictureOfDayResponse(
//    @SerializedName("media_type")
//    val mediaType: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("url")
    val url: String,
    val explanation: String
)


//***PERPLEX***V2
//
//package by.vjacheslavkovalenko.asteroidstms.network.entity
//
//data class PictureOfDayResponse(
//    val title: String,
//    val url: String,
//    val explanation: String
//)
