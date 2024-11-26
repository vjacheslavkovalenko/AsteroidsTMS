package by.vjacheslavkovalenko.asteroidstms.model

import com.google.gson.annotations.SerializedName

//GET  https://api.nasa.gov/planetary/apod
//https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY
data class PictureOfDay(
    @SerializedName("media_type")
    val mediaType: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("url")
    val url: String,

    )

///////////////////////
/**
 * DataTransferObjects go in this file. These are responsible for parsing responses from the server
 * or formatting objects to send to the server. You should convert these to domain objects before
 * using them.
 * DataTransferObjects помещаются в этот файл. Они отвечают за разбор ответов сервера
 * или форматирование объектов для отправки на сервер. Перед использованием их следует
 * преобразовать в объекты домена.
 */


/**
 * Videos represent a devbyte that can be played.
 * Видео представляет собой devbyte, который можно воспроизвести.
 */
//@JsonClass(generateAdapter = true)
//data class NetworkPictureOfDay(
//    val url : String,
//    val date : String,
//    @Json(name = "media_type") val mediaType : String,
//    val title : String)


//***PERPLEX***V2
//
//package by.vjacheslavkovalenko.asteroidstms.model
//
//data class PictureOfDay(
//    val title: String,
//    val url: String,
//    val explanation: String
//)