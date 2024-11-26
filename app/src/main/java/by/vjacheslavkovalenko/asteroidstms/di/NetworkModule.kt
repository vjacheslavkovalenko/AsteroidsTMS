package by.vjacheslavkovalenko.asteroidstms.di

import by.vjacheslavkovalenko.asteroidstms.network.Api
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideApi(): Api {
//        val retrofit = Retrofit.Builder()
//            .baseUrl("https://api.nasa.gov/")
//            .client(OkHttpClient())
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.nasa.gov/")
            .client(OkHttpClient.Builder()
                .addInterceptor(
                    HttpLoggingInterceptor().apply {
                        setLevel(HttpLoggingInterceptor.Level.BODY)
                    }
                )
                .build())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit.create(Api::class.java)
    }
}