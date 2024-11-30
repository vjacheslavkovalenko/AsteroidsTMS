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
import androidx.paging.PagingSource
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import by.vjacheslavkovalenko.asteroidstms.database.AsteroidsDao
import by.vjacheslavkovalenko.asteroidstms.database.PictureOfDayDao
import by.vjacheslavkovalenko.asteroidstms.network.entity.AsteroidResponse

//555
class ApiRepositoryImpl @Inject constructor(
    private val api: Api
) : ApiRepository {

    override suspend fun getAsteroids(startDate: String, endDate: String, apiKey: String): AsteroidResponse {
        return api.getAsteroids(startDate, endDate, apiKey)
    }

    override suspend fun getPictureOfDay(apiKey: String): PictureOfDayResponse {
        return api.getPictureOfDay(apiKey)
    }

    override suspend fun getAsteroidById(apiKey: String, asteroidId: String): AsteroidResponse {
        return api.getAsteroidById(asteroidId, apiKey)
    }
}
//Объяснение кода
//Пакет: Класс находится в пакете by.vjacheslavkovalenko.asteroidstms.repository, что указывает на его назначение как слоя доступа к данным.
//Конструктор:
//Использует внедрение зависимостей для получения экземпляра интерфейса Api, который будет использоваться для выполнения сетевых запросов.
//Методы:
//getAsteroids: Реализует метод для получения списка астероидов за указанный период. Он принимает стартовую и конечную даты, а также ключ API, и возвращает объект AsteroidResponse.
//getPictureOfDay: Реализует метод для получения информации о картине дня, принимая ключ API и возвращая объект PictureOfDayResponse.
//getAsteroidById: Реализует метод для получения информации о конкретном астероиде по его идентификатору. Он также принимает ключ API и возвращает объект AsteroidResponse.
//Заключение
//Класс ApiRepositoryImpl является важным компонентом архитектуры MVVM, обеспечивая связь между сетевыми запросами и бизнес-логикой приложения. Он позволяет вашему приложению взаимодействовать с внешним API для получения актуальных данных об астероидах и картине дня от NASA.
//
//
//
//
//
//тот класс будет содержать логику для выполнения сетевых запросов к API, а также обеспечивать доступ к данным о астероидах и картине дня.
//
//Объяснение кода
//Пакет: Класс находится в пакете by.vjacheslavkovalenko.asteroidstms.repository, что указывает на его назначение как слоя доступа к данным.
//Конструктор:
//Использует внедрение зависимостей для получения экземпляра интерфейса Api, который будет использоваться для выполнения сетевых запросов.
//Методы:
//getAsteroids: Реализует метод для получения списка астероидов. Он принимает ключ API и номер страницы, возвращая объект AsteroidResponse.
//getPictureOfDay: Реализует метод для получения информации о картине дня, принимая ключ API и возвращая объект PictureOfDayResponse.
//getAsteroidById: Реализует метод для получения информации о конкретном астероиде по его идентификатору. Он также принимает ключ API и возвращает объект AsteroidResponse.
//Заключение
//Этот класс является важным компонентом архитектуры MVVM, обеспечивая связь между сетевыми запросами и бизнес-логикой приложения. Он позволяет вашему приложению взаимодействовать с внешним API для получения актуальных данных об астероидах и картине дня от NASA.
//




//*****
//class ApiRepositoryImpl @Inject constructor(
//    private val api: Api, // Интерфейс для сетевых запросов
//    private val asteroidsDao: AsteroidsDao, // DAO для работы с астероидами
//    private val pictureOfDayDao: PictureOfDayDao // DAO для работы с картиной дня
//) : ApiRepository {
//
//    override suspend fun getPictureOfDay(): PictureOfDay {
//        // Проверяем наличие данных в локальной базе
//        val localPictureOfDay = pictureOfDayDao.getPictureOfDay()
//        return if (localPictureOfDay != null) {
//            localPictureOfDay
//        } else {
//            // Если данных нет, выполняем запрос к API
//            val response = api.getPictureOfDay()
//            // Сохраняем полученные данные в локальную базу данных
//            pictureOfDayDao.insertPictureOfDay(response.toEntity())
//            response
//        }
//    }
//
//    override suspend fun getAsteroids(startDate: String, endDate: String): List<Asteroid> {
//        // Выполняем запрос к API для получения списка астероидов
//        val response = api.getAsteroids(startDate, endDate)
//        // Сохраняем полученные данные в локальную базу данных
//        asteroidsDao.insertAsteroids(response.nearEarthObjects.map { it.toEntity() })
//        return response.nearEarthObjects.map { it.toModel() }
//    }
//
//    override suspend fun getAsteroidDetails(asteroidId: Int): AsteroidDetails {
//        // Выполняем запрос к API для получения деталей астероида
//        val response = api.getAsteroidDetails(asteroidId)
//        return response.toModel() // Преобразуем ответ в модель AsteroidDetails
//    }
//}
//Объяснение кода
//Конструктор:
//Использует внедрение зависимостей для получения экземпляров Api, AsteroidsDao и PictureOfDayDao.
//Метод getPictureOfDay():
//Сначала проверяет наличие данных о картинке дня в локальной базе данных.
//Если данные есть, возвращает их.
//Если нет, выполняет запрос к API, сохраняет полученные данные в базу и возвращает их.
//Метод getAsteroids(startDate: String, endDate: String):
//Выполняет запрос к API для получения списка астероидов на указанный период.
//Сохраняет полученные данные в локальную базу данных и возвращает список астероидов в формате модели.
//Метод getAsteroidDetails(asteroidId: Int):
//Выполняет запрос к API для получения деталей конкретного астероида по его идентификатору.
//Преобразует ответ из API в модель AsteroidDetails и возвращает её.
//Дополнительные методы
//В приведенном коде предполагается наличие методов расширения (toEntity(), toModel()), которые преобразуют объекты из сетевого формата в формат сущностей и моделей соответственно. Эти методы должны быть реализованы в соответствующих классах.




//
//class ApiRepositoryImpl @Inject constructor(
//    private val api: Api
//) : ApiRepository {
//
//    override suspend fun getListAsteroids(
//        apiKey: String, startDate: String, endDate: String
//    ): Flow<PagingData<Asteroids>> {
//        return Pager(
//            config = PagingConfig(pageSize = 20),
//            pagingSourceFactory = { AsteroidPagingSource(api, apiKey, startDate, endDate) }
//        ).flow
//    }


//
////    override suspend fun getListAsteroids(
////        apiKey: String,
////        startDate: String,
////        endDate: String
////    ): Flow<List<Asteroids>> = flow {
////        // Выполняем запрос к API для получения списка астероидов
////        val response: Response<ListRadarAsteroidsResponse> =
////            api.loadAsteroidsRadar(startDate, endDate, apiKey)
////
////
////
////        if (response.isSuccessful) {
////            response.body()?.let { radarResponse ->
////                // Преобразуем ответ в список астероидов
////                val asteroidsList = radarResponse.nearEarthObjects.flatMap { entry ->
////                    entry.value.map { nearEarthObject ->
////                        mapToModel(nearEarthObject)
////                    }
////                }
////                emit(asteroidsList) // Отправляем список астероидов через Flow
////            } ?: throw Exception("Empty response body")
////        } else {
////            throw Exception("Error fetching asteroids: ${response.message()}")
////        }
////    }
//
//override suspend fun getPictureOfDay(apiKey: String): Flow<PictureOfDay> = flow {
//    // Выполняем запрос к API для получения картинки дня
//    val response: Response<PictureOfDayResponse> = api.getPictureOfDay(apiKey)
//
//    if (response.isSuccessful) {
//        response.body()?.let { pictureResponse ->
//            emit(mapToModel(pictureResponse)) // Преобразование ответа в модель PictureOfDay
//        } ?: throw Exception("Empty response body")
//    } else {
//        throw Exception("Error fetching picture of the day: ${response.message()}")
//    }
//}
//
//private fun mapToModel(response: NearEarthObject): Asteroids {
//    return Asteroids(
//        asteroidId = response.asteroidId,
//        nameAsteroid = response.nameAsteroid,
//        estimatedDiameterMin = response.estimatedDiameter.kilometers.estimatedDiameterMin,
//        estimatedDiameterMax = response.estimatedDiameter.kilometers.estimatedDiameterMax,
//        isPotentiallyHazardous = response.isPotentiallyHazardous
//    )
//}
//
//private fun mapToModel(response: PictureOfDayResponse): PictureOfDay {
//    return PictureOfDay(
//        title = response.title,
//        url = response.url,
//        explanation = response.explanation
//    )
//}
//}