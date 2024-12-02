package by.vjacheslavkovalenko.asteroidstms.api

import by.vjacheslavkovalenko.asteroidstms.domain.Asteroid
import retrofit2.Response

class AsteroidParser {
    companion object {
        fun parseAsteroidsResponse(response: Response<NearEarthObjectsResponse>): List<Asteroid> {
            val asteroidList = mutableListOf<Asteroid>()

            if (response.isSuccessful) {
                response.body()?.nearEarthObjects?.let { nearEarthObjects ->
                    for (asteroidListPerDate in nearEarthObjects.values) {
                        asteroidList.addAll(asteroidListPerDate)
                    }
                }
            }

            return asteroidList
        }
    }
}