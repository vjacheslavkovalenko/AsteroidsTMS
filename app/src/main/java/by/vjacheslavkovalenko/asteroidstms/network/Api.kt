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

//gM0Ze05VWVs9uAcahDClWEvapDNv7m5MNiuO3TLl
interface Api {

    //https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY
//baseUrl("https://api.nasa.gov/neo/rest/v1/")
    @GET("planetary/apod")
    suspend fun loadPictureOfDay(
        @Query("api_key") apiKey: String = APIKEY
    ): Response<PictureOfDayResponse>


    //GET https://api.nasa.gov/neo/rest/v1/feed?start_date=START_DATE&end_date=END_DATE&api_key=API_KEY
    // @GET(value = "neo/rest/v1/feed")
    //GET https://api.nasa.gov/neo/rest/v1/neo/browse/
    @GET("neo/browse")
    suspend fun loadAsteroidsList(
        @Query("api_key") apiKey: String
    ): Response<ListAsteroidsResponse>

    //это чисто для проверки:
    //https://api.nasa.gov/neo/rest/v1/neo/3542519?api_key=DEMO_KEY
    @GET("neo/rest/v1/neo/{asteroidId}")
    suspend fun loadAsteroidDetails(
        @Path("asteroid_id") asteroidId: String,
        @Query("api_key") apiKey: String,
    ): Response<AsteroidResponse>

    //https://api.nasa.gov/neo/rest/v1/feed?start_date=START_DATE&end_date=END_DATE&api_key=API_KEY
    //https://api.nasa.gov/neo/rest/v1/feed?start_date=2021-09-07&end_date=2021-09-08&api_key=DEMO_KEY
    //@RequiresApi(Build.VERSION_CODES.O) - это перечисление известных на данный момент кодов версий SDK (.0 значит "Выпущена публично как Android 8.0 в августе 2017 года." ссылка: https://developer.android.com/reference/android/os/Build.VERSION_CODES
    //это попытка подключить запрос по дате:
    @GET("neo/rest/v1/feed")
    suspend fun loadAsteroidsRadar(
        @Query("start_date") startDate: String = LocalDate.now().toDate().convertDateToString(),
        @Query("send_date") endDate: String = LocalDate.now().plusDays(6).toDate()
            .convertDateToString(),
        @Query("api_key") apiKey: String,
    ): Response<ListRadarAsteroidsResponse>
}
//------------------------------баба:
//private val moshi = Moshi.Builder()
//    .add(KotlinJsonAdapterFactory())
//    .build()
//interface NeoApiService {
//    @RequiresApi(Build.VERSION_CODES.O)
//    @GET("neo/rest/v1/feed")
//    suspend fun getFeed(
//        @Query("start_date") startDate: String = LocalDate.now().toDate().convertDateToString(),
//        @Query("end_date") endDate: String = LocalDate.now().plusDays(6).toDate()
//            .convertDateToString()
//    ): String
//
//    @GET("planetary/apod")
//    suspend fun getPictureOfTheDay(): PictureOfDay
//}


//-------------------------------мужик:
// Since we only have one service, this can all go in one file.
// If you add more services, split this to multiple files and make sure to share the retrofit
// object between services.
//********** Поскольку у нас только одна служба, все это можно разместить в одном файле.
//********** Если вы добавите больше служб, разделите это на несколько файлов и убедитесь,
//********** что вы разделяете объект модернизации между службами.
//
//enum class AsteroidApiFilter(val value: String) { SHOW_SAVED("saved"), SHOW_TODAY("today"), SHOW_WEEK("week") }
//
///**
// * Build the Moshi object that Retrofit will be using, making sure to add the Kotlin adapter for
// * full Kotlin compatibility.
//********** Создайте объект Moshi, который будет использовать Retrofit, обязательно добавив
//********** адаптер Kotlin для полной совместимости с Kotlin.
// */
//private val moshi = Moshi.Builder()
//    .add(KotlinJsonAdapterFactory())
//    .build()
//
///**
// * Use the Retrofit builder to build a retrofit object using a Moshi converter with our Moshi
// * object.
//********** Используйте конструктор Retrofit для создания объекта модернизации с использованием
//********** конвертера Moshi и нашего объекта Moshi.
// */
//private val retrofit = Retrofit.Builder()
//    .baseUrl(BASE_URL)
//    .addConverterFactory(ScalarsConverterFactory.create())
//    .addConverterFactory(MoshiConverterFactory.create(moshi))
//    .addCallAdapterFactory(CoroutineCallAdapterFactory())
//    .build()
//
///**
// * A retrofit service to fetch the picture of the day.
//********** Услуга модернизации для получения изображения дня.
// */
//interface AsteroidRadarService {
//    @GET(value = "planetary/apod")
//    fun getPictureOfDay(@Query("api_key") apiKey: String): Deferred<NetworkPictureOfDay>
//
//    @GET(value = "neo/rest/v1/feed")
//    fun getAsteroids(@Query("api_key") apiKey: String) : Deferred<String>
//}
//
///**
// * Main entry point for network access. Call like `Network.picturesOfDay.getPictureOfDay()`
//********** Основная точка входа для сетевого доступа.
// ********* Вызов типа `Network.picturesOfDay.getPictureOfDay()`
// */
//object Network {
//
//    val radarApi = retrofit.create(AsteroidRadarService::class.java)
//}