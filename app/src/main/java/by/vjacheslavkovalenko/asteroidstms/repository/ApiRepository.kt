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