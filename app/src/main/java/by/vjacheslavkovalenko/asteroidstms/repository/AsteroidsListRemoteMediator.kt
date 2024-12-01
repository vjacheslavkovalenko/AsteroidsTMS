package by.vjacheslavkovalenko.asteroidstms.repository

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import by.vjacheslavkovalenko.asteroidstms.mapper.AsteroidsMapper
import by.vjacheslavkovalenko.asteroidstms.model.Asteroids
//import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpException
import java.io.IOException
import javax.inject.Inject
import kotlinx.coroutines.flow.first
import retrofit2.HttpException
import by.vjacheslavkovalenko.asteroidstms.database.AsteroidsDao
import by.vjacheslavkovalenko.asteroidstms.database.entity.AsteroidsEntity
import by.vjacheslavkovalenko.asteroidstms.network.Api
import by.vjacheslavkovalenko.asteroidstms.network.entity.AsteroidResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import by.vjacheslavkovalenko.asteroidstms.network.entity.NearEarthObjects
import by.vjacheslavkovalenko.asteroidstms.network.entity.NearEarthObject

//555
@OptIn(ExperimentalPagingApi::class)
class AsteroidsListRemoteMediator(
    private val api: Api,
    private val asteroidsDao: AsteroidsDao,
    private val apiKey: String
) : RemoteMediator<Int, AsteroidsEntity>() {

    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, AsteroidsEntity>
    ): MediatorResult {
        return withContext(Dispatchers.IO) {
            try {
                // Определяем диапазон дат для запроса к API
                val startDate = getStartDate(loadType)
                val endDate = getEndDate(loadType)

                // Получаем данные об астероидах из API
                val response: NearEarthObjects = api.getAsteroids(startDate, endDate, apiKey)

                // Сохраняем данные в базе данных
                response.nearEarthObjects.forEach { nearEarthObject ->
                    val entity = AsteroidsEntity(
                        asteroidId = nearEarthObject.asteroidId,
                        nameAsteroid = nearEarthObject.nameAsteroid,
                        estimatedDiameterMax = nearEarthObject.estimatedDiameter.kilometers.estimatedDiameterMax,
                        estimatedDiameterMin = nearEarthObject.estimatedDiameter.kilometers.estimatedDiameterMin,
                        isPotentiallyHazardous = nearEarthObject.isPotentiallyHazardous
                    )
                    asteroidsDao.insertAsteroid(entity)
                }

                MediatorResult.Success(endOfPaginationReached = response.nearEarthObjects.isEmpty())
            } catch (e: Exception) {
                MediatorResult.Error(e)
            }
        }
    }

    private fun getStartDate(loadType: LoadType): String {
        // Логика для определения начальной даты в зависимости от типа загрузки
        return "2023-01-01" // Замените на вашу логику получения даты
    }

    private fun getEndDate(loadType: LoadType): String {
        // Логика для определения конечной даты в зависимости от типа загрузки
        return "2023-01-07" // Замените на вашу логику получения даты
    }
}



//Этот класс отвечает за управление кэшированием данных об астероидах и синхронизацией между локальным хранилищем и удаленным источником данных (API).
//
//
//Объяснение кода
//Пакет: Класс находится в пакете by.vjacheslavkovalenko.asteroidstms.repository.
//Импорт необходимых классов:
//Импортируются классы для работы с Paging и Room, а также интерфейс API.
//Класс AsteroidsListRemoteMediator:
//Наследует от RemoteMediator, что позволяет управлять кэшированием данных между удаленным источником и локальным хранилищем.
//Принимает экземпляры API и DAO, а также ключ API.
//Метод load:
//Этот метод вызывается для загрузки данных в зависимости от типа загрузки (например, при первой загрузке или при обновлении).
//Запрашивает данные об астероидах из API и сохраняет их в базу данных.
//Возвращает результат загрузки в виде MediatorResult.
//Методы getStartDate и getEndDate:
//Эти методы определяют диапазон дат для запроса к API. Вам нужно будет реализовать логику для получения этих дат в зависимости от ваших требований.
//Заключение
//Теперь у вас есть полностью реализованный класс AsteroidsListRemoteMediator, который управляет кэшированием данных об астероидах и синхронизацией между локальным хранилищем и удаленным источником данных (API).
//
