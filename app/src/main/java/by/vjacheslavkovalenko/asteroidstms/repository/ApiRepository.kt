package by.vjacheslavkovalenko.asteroidstms.repository

import by.vjacheslavkovalenko.asteroidstms.network.Api
import by.vjacheslavkovalenko.asteroidstms.network.entity.AsteroidResponse
import by.vjacheslavkovalenko.asteroidstms.network.entity.ListAsteroidsResponse
import by.vjacheslavkovalenko.asteroidstms.network.entity.ListRadarAsteroidsResponse
import by.vjacheslavkovalenko.asteroidstms.network.entity.PictureOfDayResponse
import retrofit2.Response
import javax.inject.Inject


interface ApiRepository {

    suspend fun loadPictureOfDay(apiKey: String): Response<PictureOfDayResponse>

    suspend fun getListAsteroids(apiKey: String): Response<ListAsteroidsResponse>

    //для теста (это по id получение конкретного астероида):
    suspend fun loadAsteroidDetails(
        asteroidId: String,
        apiKey: String
    ): Response<AsteroidResponse>

    //для получения даты:
    suspend fun loadAsteroidsRadarDetails(
        startDate: String,
        endDate: String,
        apiKey: String
    ): Response<ListRadarAsteroidsResponse>
}

class ApiRepositoryImpl @Inject constructor(private val api: Api) : ApiRepository {

    override suspend fun loadPictureOfDay(apiKey: String): Response<PictureOfDayResponse> {
        return api.loadPictureOfDay(apiKey)
    }

    override suspend fun getListAsteroids(apiKey: String): Response<ListAsteroidsResponse> {
        return api.loadAsteroidsList(apiKey)
    }

    override suspend fun loadAsteroidDetails(
        asteroidId: String,
        apiKey: String
    ): Response<AsteroidResponse> {
        return api.loadAsteroidDetails(asteroidId, apiKey)
    }

    override suspend fun loadAsteroidsRadarDetails(
        startDate: String,
        endDate: String,
        apiKey: String
    ): Response<ListRadarAsteroidsResponse> {
        return api.loadAsteroidsRadar(startDate, endDate, apiKey)
    }
}



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