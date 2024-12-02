package by.vjacheslavkovalenko.asteroidstms.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import by.vjacheslavkovalenko.asteroidstms.Constants

object RetrofitInstance {
    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(Constants.BASEURL) // Использование BASE_URL из Constants.
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val api: AsteroidApiService by lazy {
        retrofit.create(AsteroidApiService::class.java)
    }
}
