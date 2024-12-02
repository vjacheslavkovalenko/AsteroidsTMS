package by.vjacheslavkovalenko.asteroidstms.api

import by.vjacheslavkovalenko.asteroidstms.Constants
import by.vjacheslavkovalenko.asteroidstms.domain.Asteroid
import retrofit2.http.GET
import retrofit2.Response
import retrofit2.http.Query

interface AsteroidApiService {
    @GET("neo/rest/v1/feed")
    suspend fun getAsteroids(
        @Query("start_date") startDate: String,
        @Query("end_date") endDate: String,
        @Query("api_key") apiKey: String = Constants.APIKEY
    ): Response<NearEarthObjectsResponse>
}

