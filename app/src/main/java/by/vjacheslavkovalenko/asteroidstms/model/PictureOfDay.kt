package by.vjacheslavkovalenko.asteroidstms.model

import com.google.gson.annotations.SerializedName

//GET  https://api.nasa.gov/planetary/apod
//https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY
data class PictureOfDay(
//    @SerializedName("media_type")
//    val mediaType: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("url")
    val url: String,
    @SerializedName("explanation")
    val explanation: String
)


//***PERPLEX***V2
//
//package by.vjacheslavkovalenko.asteroidstms.model
//
//data class PictureOfDay(
//    val title: String,
//    val url: String,
//    val explanation: String
//)