package by.vjacheslavkovalenko.asteroidstms.network

import by.vjacheslavkovalenko.asteroidstms.utils.Constants.APIKEY
import by.vjacheslavkovalenko.asteroidstms.network.entity.AsteroidResponse
import by.vjacheslavkovalenko.asteroidstms.network.entity.ListAsteroidsResponse
import by.vjacheslavkovalenko.asteroidstms.network.entity.ListRadarAsteroidsResponse
import by.vjacheslavkovalenko.asteroidstms.network.entity.NearEarthObject
import by.vjacheslavkovalenko.asteroidstms.network.entity.NearEarthObjects
import by.vjacheslavkovalenko.asteroidstms.network.entity.PictureOfDayResponse
//import by.vjacheslavkovalenko.asteroidstms.utils.convertDateToString
//import by.vjacheslavkovalenko.asteroidstms.utils.toDate
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import java.time.LocalDate

//555
interface Api {

    // Метод для получения списка астероидов за указанный период
    @GET("neo/rest/v1/feed")
    suspend fun getAsteroids(
        @Query("start_date") startDate: String,
        @Query("end_date") endDate: String,
        @Query("api_key") apiKey: String = APIKEY
    ): NearEarthObjects

    // Метод для получения информации о картине дня
    @GET("planetary/apod")
    suspend fun getPictureOfDay(
        @Query("api_key") apiKey: String = APIKEY
    ): PictureOfDayResponse

    // Метод для получения информации по одному астероиду
    @GET("neo/rest/v1/neo/{id}")
    suspend fun getAsteroidById(
        @Path("id") asteroidId: String,
        @Query("api_key") apiKey: String = APIKEY
    ): AsteroidResponse
}
//
//
//

//
//interface Api {
//
//    // Метод для получения списка астероидов
//    @GET("neo/rest/v1/neo/browse")
//    suspend fun getAsteroids(
//        @Query("api_key") apiKey: String,
//        @Query("page") page: Int = 1 // Параметр для пагинации (по умолчанию первая страница)
//    ): AsteroidResponse
//
//    // Метод для получения информации о картине дня
//    @GET("planetary/apod")
//    suspend fun getPictureOfDay(
//        @Query("api_key") apiKey: String
//    ): PictureOfDayResponse
//
//    // Метод для получения информации по одному астероиду
//    @GET("neo/rest/v1/neo/{id}")
//    suspend fun getAsteroidById(
//        @Path("id") asteroidId: String,
//        @Query("api_key") apiKey: String
//    ): AsteroidResponse
//}
//
//*****
//interface Api {
//
//    // Метод для получения списка астероидов
//    @GET("neo/rest/v1/neo/browse")
//    suspend fun getAsteroids(
//        @Query("api_key") apiKey: String = APIKEY,
//        @Query("page") page: Int = 1 // Параметр для пагинации (по умолчанию первая страница)
//    ): AsteroidResponse
//
//    // Метод для получения информации о картине дня
//    @GET("planetary/apod")
//    suspend fun getPictureOfDay(
//        @Query("api_key") apiKey: String
//    ): PictureOfDayResponse
//}
//
//
//Интерфейс Api будет определять методы для выполнения сетевых запросов к NASA API, позволяя вашему приложению получать данные об астероидах и картине дня. Вот пример реализации этого интерфейса с использованием библиотеки Retrofit для работы с HTTP-запросами:
//
//Объяснение кода
//Пакет: Интерфейс находится в пакете by.vjacheslavkovalenko.asteroidstms.network, что указывает на его назначение.
//Методы:
//getAsteroids:
//Аннотация @GET указывает, что это HTTP GET запрос к указанному пути API.
//Метод принимает параметр apiKey, который необходим для аутентификации запросов к API NASA.
//Параметр page используется для пагинации, позволяя запрашивать данные по страницам.
//Возвращает объект AsteroidResponse, который должен содержать данные о астероидах.
//getPictureOfDay:
//Также использует аннотацию @GET для выполнения GET запроса к API.
//Принимает параметр apiKey для аутентификации.
//Возвращает объект PictureOfDayResponse, содержащий данные о картине дня.
//Заключение
//Интерфейс Api является важным компонентом архитектуры MVVM, обеспечивая связь между сетевыми запросами и бизнес-логикой приложения. Он позволяет вашему приложению взаимодействовать с внешним API для получения актуальных данных об астероидах и картине дня от NASA.


//interface Api {
//    //https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY
////baseUrl("https://api.nasa.gov/neo/rest/v1/")
//    @GET("planetary/apod")
//    suspend fun getPictureOfDay(
//        @Query("api_key") apiKey: String = APIKEY
//    ): Response<PictureOfDayResponse>
//
//    @GET("neo/rest/v1/feed")
//    suspend fun loadAsteroidsRadar(
//        @Query("start_date") startDate: String,
//        @Query("end_date") endDate: String,
//        @Query("api_key") apiKey: String
//    ): Response<ListRadarAsteroidsResponse>
//
//    //GET https://api.nasa.gov/neo/rest/v1/neo/browse/
////    @GET("neo/browse")
//
//    //https://api.nasa.gov/neo/rest/v1/neo/3542519?api_key=DEMO_KEY
////    @GET("neo/rest/v1/neo/{asteroidId}")
//
//    //https://api.nasa.gov/neo/rest/v1/feed?start_date=START_DATE&end_date=END_DATE&api_key=API_KEY
//    //https://api.nasa.gov/neo/rest/v1/feed?start_date=2021-09-07&end_date=2021-09-08&api_key=DEMO_KEY
//
////    @GET("neo/rest/v1/feed")
//}


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