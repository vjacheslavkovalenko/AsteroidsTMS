package by.vjacheslavkovalenko.asteroidstms.repository

import by.vjacheslavkovalenko.asteroidstms.api.AsteroidApiService
import by.vjacheslavkovalenko.asteroidstms.api.AsteroidParser.Companion.parseAsteroidsResponse
import by.vjacheslavkovalenko.asteroidstms.domain.Asteroid
import javax.inject.Inject

class AsteroidRepository @Inject constructor(private val apiService: AsteroidApiService) {
    suspend fun getAsteroids(startDate: String, endDate: String): List<Asteroid> {
        val response = apiService.getAsteroids(startDate, endDate)
        return parseAsteroidsResponse(response)
    }
}