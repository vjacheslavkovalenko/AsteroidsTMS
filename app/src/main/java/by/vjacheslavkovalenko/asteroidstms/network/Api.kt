package by.vjacheslavkovalenko.asteroidstms.network

import by.vjacheslavkovalenko.asteroidstms.Constants.APIKEY
import by.vjacheslavkovalenko.asteroidstms.network.entity.AsteroidResponse
import by.vjacheslavkovalenko.asteroidstms.network.entity.ListAsteroidsResponse
import by.vjacheslavkovalenko.asteroidstms.network.entity.ListRadarAsteroidsResponse
import by.vjacheslavkovalenko.asteroidstms.network.entity.PictureOfDayResponse
import by.vjacheslavkovalenko.asteroidstms.utils.convertDateToString
import by.vjacheslavkovalenko.asteroidstms.utils.toDate
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import java.time.LocalDate

interface Api {
    //https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY
//baseUrl("https://api.nasa.gov/neo/rest/v1/")
    @GET("planetary/apod")
    suspend fun getPictureOfDay(
        @Query("api_key") apiKey: String = APIKEY
    ): Response<PictureOfDayResponse>

    @GET("neo/rest/v1/feed")
    suspend fun loadAsteroidsRadar(
        @Query("start_date") startDate: String,
        @Query("end_date") endDate: String,
        @Query("api_key") apiKey: String
    ): Response<ListRadarAsteroidsResponse>

    //GET https://api.nasa.gov/neo/rest/v1/neo/browse/
//    @GET("neo/browse")

    //https://api.nasa.gov/neo/rest/v1/neo/3542519?api_key=DEMO_KEY
//    @GET("neo/rest/v1/neo/{asteroidId}")

    //https://api.nasa.gov/neo/rest/v1/feed?start_date=START_DATE&end_date=END_DATE&api_key=API_KEY
    //https://api.nasa.gov/neo/rest/v1/feed?start_date=2021-09-07&end_date=2021-09-08&api_key=DEMO_KEY

//    @GET("neo/rest/v1/feed")
}


//***PERPLEX***V5
//package by.vjacheslavkovalenko.asteroidstms.network
//
//import by.vjacheslavkovalenko.asteroidstms.network.entity.ListAsteroidsResponse
//import by.vjacheslavkovalenko.asteroidstms.network.entity.PictureOfDayResponse
//import retrofit2.Response
//import retrofit2.http.GET
//import retrofit2.http.Query
//
//interface Api {
//
//    @GET("astroids") // Замените на реальный путь к вашему API для получения списка астероидов
//    suspend fun getListAsteroids(
//        @Query("api_key") apiKey: String,
//        @Query("start_date") startDate: String,
//        @Query("end_date") endDate: String
//    ): Response<ListAsteroidsResponse>
//
//    @GET("picture_of_the_day") // Замените на реальный путь к вашему API для получения картины дня
//    suspend fun getPictureOfTheDay(
//        @Query("api_key") apiKey: String
//    ): Response<PictureOfDayResponse>
//}