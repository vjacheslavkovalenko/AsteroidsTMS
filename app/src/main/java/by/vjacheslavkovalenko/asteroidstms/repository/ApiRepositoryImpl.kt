package by.vjacheslavkovalenko.asteroidstms.repository

import by.vjacheslavkovalenko.asteroidstms.network.entity.NearEarthObject
import by.vjacheslavkovalenko.asteroidstms.model.Asteroids
import by.vjacheslavkovalenko.asteroidstms.model.PictureOfDay
import by.vjacheslavkovalenko.asteroidstms.network.entity.ListRadarAsteroidsResponse
import by.vjacheslavkovalenko.asteroidstms.network.entity.PictureOfDayResponse
import by.vjacheslavkovalenko.asteroidstms.network.Api
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Response
import javax.inject.Inject

class ApiRepositoryImpl @Inject constructor(
    private val api: Api
) : ApiRepository {

    override suspend fun getListAsteroids(
        apiKey: String,
        startDate: String,
        endDate: String
    ): Flow<List<Asteroids>> = flow {
        // Выполняем запрос к API для получения списка астероидов
        val response: Response<ListRadarAsteroidsResponse> =
            api.loadAsteroidsRadar(startDate, endDate, apiKey)

        if (response.isSuccessful) {
            response.body()?.let { radarResponse ->
                // Преобразуем ответ в список астероидов
                val asteroidsList = radarResponse.nearEarthObjects.flatMap { entry ->
                    entry.value.map { nearEarthObject ->
                        mapToModel(nearEarthObject)
                    }
                }
                emit(asteroidsList) // Отправляем список астероидов через Flow
            } ?: throw Exception("Empty response body")
        } else {
            throw Exception("Error fetching asteroids: ${response.message()}")
        }
    }

    override suspend fun getPictureOfDay(apiKey: String): Flow<PictureOfDay> = flow {
        // Выполняем запрос к API для получения картины дня
        val response: Response<PictureOfDayResponse> = api.getPictureOfDay(apiKey)

        if (response.isSuccessful) {
            response.body()?.let { pictureResponse ->
                emit(mapToModel(pictureResponse)) // Преобразование ответа в модель PictureOfDay
            } ?: throw Exception("Empty response body")
        } else {
            throw Exception("Error fetching picture of the day: ${response.message()}")
        }
    }

    private fun mapToModel(response: NearEarthObject): Asteroids {
        return Asteroids(
            asteroidId = response.asteroidId,
            nameAsteroid = response.nameAsteroid,
            estimatedDiameterMin = response.estimatedDiameter.kilometers.estimatedDiameterMin,
            estimatedDiameterMax = response.estimatedDiameter.kilometers.estimatedDiameterMax,
            isPotentiallyHazardous = response.isPotentiallyHazardous
        )
    }

    private fun mapToModel(response: PictureOfDayResponse): PictureOfDay {
        return PictureOfDay(
            title = response.title,
            url = response.url,
            explanation = response.explanation
        )
    }
}