package by.vjacheslavkovalenko.asteroidstms.di

import by.vjacheslavkovalenko.asteroidstms.Constants
import by.vjacheslavkovalenko.asteroidstms.api.AsteroidApiService
import by.vjacheslavkovalenko.asteroidstms.repository.AsteroidRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Constants.BASEURL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideAsteroidApiService(retrofit: Retrofit): AsteroidApiService {
        return retrofit.create(AsteroidApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideAsteroidRepository(apiService: AsteroidApiService): AsteroidRepository {
        return AsteroidRepository(apiService)
    }
}
