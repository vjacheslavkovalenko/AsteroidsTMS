package by.vjacheslavkovalenko.asteroidstms.repository

import by.vjacheslavkovalenko.asteroidstms.network.Api
import by.vjacheslavkovalenko.asteroidstms.network.entity.AsteroidResponse
import by.vjacheslavkovalenko.asteroidstms.network.entity.ListAsteroidsResponse
import by.vjacheslavkovalenko.asteroidstms.network.entity.ListRadarAsteroidsResponse
import by.vjacheslavkovalenko.asteroidstms.network.entity.PictureOfDayResponse
import by.vjacheslavkovalenko.asteroidstms.model.Asteroids
import by.vjacheslavkovalenko.asteroidstms.model.PictureOfDay
import kotlinx.coroutines.flow.Flow
import retrofit2.Response
import javax.inject.Inject

interface ApiRepository {
    /**
     * Получение списка астероидов за указанный период.
     *
     * @param apiKey Ключ API для доступа к NASA API.
     * @param startDate Дата начала периода в формате "yyyy-MM-dd".
     * @param endDate Дата окончания периода в формате "yyyy-MM-dd".
     * @return Flow, содержащий список астероидов.
     */
    suspend fun getListAsteroids(
        apiKey: String,
        startDate: String,
        endDate: String
    ): Flow<List<Asteroids>>

    /**
     * Получение картины дня.
     *
     * @param apiKey Ключ API для доступа к NASA API.
     * @return Flow, содержащий объект PictureOfDay.
     */
    suspend fun getPictureOfDay(apiKey: String): Flow<PictureOfDay>
}

//interface ApiRepository {
//
//    suspend fun loadPictureOfDay(apiKey: String): Response<PictureOfDayResponse>
//
//    suspend fun getListAsteroids(apiKey: String): Response<ListAsteroidsResponse>
//
//    //для теста (это по id получение конкретного астероида):
//    suspend fun loadAsteroidDetails(
//        asteroidId: String,
//        apiKey: String
//    ): Response<AsteroidResponse>
//
//    //для получения даты:
//    suspend fun loadAsteroidsRadarDetails(
//        startDate: String,
//        endDate: String,
//        apiKey: String
//    ): Response<ListRadarAsteroidsResponse>
//}

//class ApiRepositoryImpl @Inject constructor(private val api: Api) : ApiRepository {
//
//    override suspend fun loadPictureOfDay(apiKey: String): Response<PictureOfDayResponse> {
//        return api.loadPictureOfDay(apiKey)
//    }
//
//    override suspend fun getListAsteroids(apiKey: String): Response<ListAsteroidsResponse> {
//        return api.loadAsteroidsList(apiKey)
//    }
//
//    override suspend fun loadAsteroidDetails(
//        asteroidId: String,
//        apiKey: String
//    ): Response<AsteroidResponse> {
//        return api.loadAsteroidDetails(asteroidId, apiKey)
//    }
//
//    override suspend fun loadAsteroidsRadarDetails(
//        startDate: String,
//        endDate: String,
//        apiKey: String
//    ): Response<ListRadarAsteroidsResponse> {
//        return api.loadAsteroidsRadar(startDate, endDate, apiKey)
//    }
//}


// ИИ написал:
//class ApiRepositoryImpl @Inject constructor(private val api: Api) : ApiRepository {
//
//    override suspend fun loadPictureOfDay(apiKey: String): Result<PictureOfDayResponse> {
//        return try {
//            val response = api.loadPictureOfDay(apiKey)
//            if (response.isSuccessful) {
//                response.body()?.let { Result.Success(it) } ?: Result.Error(Exception("Empty response body"))
//            } else {
//                Result.Error(Exception("Error ${response.code()}: ${response.message()}"))
//            }
//        } catch (e: Exception) {
//            Result.Error(e)
//        }
//    }
//
//    override suspend fun getListAsteroids(apiKey: String): Result<ListAsteroidsResponse> {
//        return try {
//            val response = api.getListAsteroids(apiKey)
//            if (response.isSuccessful) {
//                response.body()?.let { Result.Success(it) } ?: Result.Error(Exception("Empty response body"))
//            } else {
//                Result.Error(Exception("Error ${response.code()}: ${response.message()}"))
//            }
//        } catch (e: Exception) {
//            Result.Error(e)
//        }
//    }
//
//    override suspend fun loadAsteroidDetails(asteroidId: String, apiKey: String): Result<AsteroidResponse> {
//        return try {
//            val response = api.loadAsteroidDetails(asteroidId, apiKey)
//            if (response.isSuccessful) {
//                response.body()?.let { Result.Success(it) } ?: Result.Error(Exception("Empty response body"))
//            } else {
//                Result.Error(Exception("Error ${response.code()}: ${response.message()}"))
//            }
//        } catch (e: Exception) {
//            Result.Error(e)
//        }
//    }
//
//    override suspend fun loadAsteroidsRadarDetails(startDate: String, endDate: String, apiKey: String): Result<ListRadarAsteroidsResponse> {
//        return try {
//            val response = api.loadAsteroidsRadar(startDate, endDate, apiKey)
//            if (response.isSuccessful) {
//                response.body()?.let { Result.Success(it) } ?: Result.Error(Exception("Empty response body"))
//            } else {
//                Result.Error(Exception("Error ${response.code()}: ${response.message()}"))
//            }
//        } catch (e: Exception) {
//            Result.Error(e)
//        }
//    }
//}


//***PERPLEX***V5
//package by.vjacheslavkovalenko.asteroidstms.repository
//
//import by.vjacheslavkovalenko.asteroidstms.model.Asteroids
//import by.vjacheslavkovalenko.asteroidstms.model.PictureOfDay
//import kotlinx.coroutines.flow.Flow
//
//interface ApiRepository {
//
//    // Получение списка астероидов
//    suspend fun getListAsteroids(apiKey: String, startDate: String, endDate: String): Flow<List<Asteroids>>
//
//    // Получение картины дня
//    suspend fun getPictureOfTheDay(apiKey: String): Flow<PictureOfDay>
//}
//
//Интерфейс ApiRepository будет служить абстракцией для работы с данными, получаемыми из вашего API. Он будет определять методы, которые будут использоваться для получения информации о астероидах и картине дня. Этот интерфейс будет реализован в классе ApiRepositoryImpl, который будет взаимодействовать с вашим интерфейсом Api.
//
//
