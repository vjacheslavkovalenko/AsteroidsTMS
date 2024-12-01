package by.vjacheslavkovalenko.asteroidstms.di

import by.vjacheslavkovalenko.asteroidstms.network.Api
import by.vjacheslavkovalenko.asteroidstms.utils.Constants.BASEURL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

//555

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton // Обеспечиваем синглтон для OkHttpClient
    fun provideOkHttpClient(): OkHttpClient {
        val loggingInterceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY // Устанавливаем уровень логирования
        }

        return OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor) // Добавляем интерсептор для логирования
            .build() // Здесь можно добавить дополнительные настройки клиента, если необходимо
    }

    @Provides
    @Singleton // Обеспечиваем синглтон для Retrofit
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASEURL) // Указываем базовый URL для API
            .client(okHttpClient) // Устанавливаем клиент OkHttp
            .addConverterFactory(GsonConverterFactory.create()) // Устанавливаем конвертер для JSON
            .build()
    }

    @Provides
    @Singleton // Обеспечиваем синглтон для Api
    fun provideApi(retrofit: Retrofit): Api {
        return retrofit.create(Api::class.java) // Создаем экземпляр API интерфейса
    }
}
//
//Класс NetworkModule будет модулем для внедрения зависимостей с использованием Dagger Hilt, который предоставляет экземпляры сетевых API-интерфейсов. Он будет использоваться для настройки и предоставления зависимостей, связанных с сетевыми запросами.
//
//Объяснение кода
//Аннотация @Module: Указывает, что этот класс является модулем Dagger Hilt, который предоставляет зависимости.
//Аннотация @InstallIn(SingletonComponent::class): Указывает, что зависимости, предоставляемые этим модулем, будут доступны в синглтон-компоненте, что означает, что они будут существовать на протяжении всего времени работы приложения.
//Метод provideOkHttpClient:
//Создает и настраивает экземпляр OkHttpClient, который используется для выполнения HTTP-запросов.
//Здесь можно добавить дополнительные настройки клиента (например, логирование или обработку ошибок).
//Метод provideRetrofit:
//Создает экземпляр Retrofit, используя базовый URL и клиент OkHttp.
//Устанавливает конвертер Gson для преобразования JSON-ответов в объекты Kotlin.
//Метод provideApi:
//Создает экземпляр интерфейса Api, который определяет методы для выполнения сетевых запросов к NASA API.
//Этот модуль обеспечивает удобный способ управления зависимостями сетевого слоя вашего приложения и упрощает тестирование и поддержку кода.



//
//@Module
//@InstallIn(SingletonComponent::class)
//object NetworkModule {
//
//    @Provides
//    @Singleton
//    fun provideApi(): Api {
////        val retrofit = Retrofit.Builder()
////            .baseUrl("https://api.nasa.gov/")
////            .client(OkHttpClient())
////            .addConverterFactory(GsonConverterFactory.create())
////            .build()
//        val retrofit = Retrofit.Builder()
//            .baseUrl("https://api.nasa.gov/")
//            .client(OkHttpClient.Builder()
//                .addInterceptor(
//                    HttpLoggingInterceptor().apply {
//                        setLevel(HttpLoggingInterceptor.Level.BODY)
//                    }
//                )
//                .build())
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//        return retrofit.create(Api::class.java)
//    }
//}