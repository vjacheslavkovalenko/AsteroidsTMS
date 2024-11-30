package by.vjacheslavkovalenko.asteroidstms.repository

import androidx.paging.PagingData
import by.vjacheslavkovalenko.asteroidstms.model.AsteroidDetails
import by.vjacheslavkovalenko.asteroidstms.model.Asteroids
import by.vjacheslavkovalenko.asteroidstms.model.PictureOfDay
import by.vjacheslavkovalenko.asteroidstms.network.entity.AsteroidResponse
import by.vjacheslavkovalenko.asteroidstms.network.entity.PictureOfDayResponse
import kotlinx.coroutines.flow.Flow

//555
interface ApiRepository {
    // Метод для получения списка астероидов за указанный период
    suspend fun getAsteroids(startDate: String, endDate: String, apiKey: String): AsteroidResponse

    // Метод для получения информации о картине дня
    suspend fun getPictureOfDay(apiKey: String): PictureOfDayResponse

    // Метод для получения информации по одному астероиду
    suspend fun getAsteroidById(apiKey: String, asteroidId: String): AsteroidResponse
}
//
//Объяснение методов
//getAsteroids:
//Этот метод принимает стартовую и конечную даты, а также ключ API.
//Возвращает объект AsteroidResponse, содержащий данные об астероидах за указанный период.
//getPictureOfDay:
//Этот метод принимает ключ API.
//Возвращает объект PictureOfDayResponse, содержащий информацию о картине дня от NASA.
//getAsteroidById:
//Этот метод принимает идентификатор астероида и ключ API.
//Возвращает объект AsteroidResponse, содержащий данные о конкретном астероиде.
//Заключение
//Интерфейс ApiRepository обеспечивает четкое разделение между бизнес-логикой и доступом к данным, позволяя ViewModel взаимодействовать с репозиториями без необходимости знать детали реализации.
//

//*****
//interface ApiRepository {
//    // Метод для получения списка астероидов
//    suspend fun getAsteroids(apiKey: String, page: Int = 1): AsteroidResponse
//    // Метод для получения информации о картине дня
//    suspend fun getPictureOfDay(apiKey: String): PictureOfDayResponse
//    suspend fun getAsteroidById(apiKey: String, asteroidId: String): AsteroidResponse // Новый метод
//}


//interface ApiRepository {
//    suspend fun getPictureOfDay(): PictureOfDay
//    suspend fun getAsteroids(startDate: String, endDate: String): List<Asteroid>
//    suspend fun getAsteroidDetails(asteroidId: Int): AsteroidDetails
//}
//
//Интерфейс ApiRepository будет служить абстракцией для доступа к данным об астероидах и картине дня, предоставляя методы для получения информации из API. Он будет использоваться репозиториями для взаимодействия с сетевыми запросами.
//
//Объяснение методов
//getPictureOfDay():
//Возвращает объект типа PictureOfDay, который содержит информацию о картинке дня от NASA.
//getAsteroids(startDate: String, endDate: String):
//Принимает начальную и конечную даты в виде строк и возвращает список объектов типа Asteroid, представляющих астероиды, которые будут близки к Земле в указанный период.
//getAsteroidDetails(asteroidId: Int):
//Принимает идентификатор астероида и возвращает объект типа AsteroidDetails, содержащий детальную информацию о конкретном астероиде.
//Этот интерфейс будет реализован в классе ApiRepositoryImpl, который будет содержать логику выполнения сетевых запросов и обработки ответов от API.
//
//
//Объяснение кода
//Пакет: Интерфейс находится в пакете by.vjacheslavkovalenko.asteroidstms.repository, что указывает на его назначение как слоя доступа к данным.
//Методы:
//getAsteroids:
//Этот метод принимает два параметра: apiKey (ключ API для аутентификации) и page (номер страницы для пагинации, по умолчанию равен 1).
//Возвращает объект AsteroidResponse, который содержит данные о астероидах.
//getPictureOfDay:
//Этот метод принимает параметр apiKey для аутентификации.
//Возвращает объект PictureOfDayResponse, содержащий информацию о картине дня.
//Заключение
//Интерфейс ApiRepository обеспечивает четкую абстракцию для работы с данными, получаемыми из API, и позволяет легко изменять реализацию без необходимости изменения кода, использующего этот интерфейс. Он является частью архитектуры MVVM, связывая бизнес-логику с сетевыми запросами и обеспечивая чистую структуру кода.


//interface ApiRepository {
//    /**
//     * Получение списка астероидов за указанный период.
//     *
//     * @param apiKey Ключ API для доступа к NASA API.
//     * @param startDate Дата начала периода в формате "yyyy-MM-dd".
//     * @param endDate Дата окончания периода в формате "yyyy-MM-dd".
//     * @return Flow, содержащий список астероидов.
//     */
//    suspend fun getListAsteroids(
//        apiKey: String,
//        startDate: String,
//        endDate: String
////    ): Flow<List<Asteroids>>
//    ): Flow<PagingData<Asteroids>>
//
//    /**
//     * Получение картинки дня.
//     *
//     * @param apiKey Ключ API для доступа к NASA API.
//     * @return Flow, содержащий объект PictureOfDay.
//     */
//    suspend fun getPictureOfDay(apiKey: String): Flow<PictureOfDay>
//}
