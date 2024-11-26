package by.vjacheslavkovalenko.asteroidstms.repository

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import by.vjacheslavkovalenko.asteroidstms.database.AsteroidsDataBase
import by.vjacheslavkovalenko.asteroidstms.Constants.APIKEY
import by.vjacheslavkovalenko.asteroidstms.database.entity.AsteroidsEntity
import by.vjacheslavkovalenko.asteroidstms.mapper.AsteroidsMapper
import by.vjacheslavkovalenko.asteroidstms.model.Asteroids
//import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpException
import java.io.IOException
import javax.inject.Inject
import androidx.room.withTransaction
import by.vjacheslavkovalenko.asteroidstms.network.Api
import by.vjacheslavkovalenko.asteroidstms.network.entity.ListRadarAsteroidsResponse
import by.vjacheslavkovalenko.asteroidstms.network.entity.NearEarthObject
import kotlinx.coroutines.flow.first
import retrofit2.HttpException

@OptIn(ExperimentalPagingApi::class)
class AsteroidsListRemoteMediator @Inject constructor(
    private val apiRepository: ApiRepository,
    private val cacheRepository: CacheRepository,
    private val asteroidsMapper: AsteroidsMapper,
    private val apiKey: String,
    private val startDate: String,
    private val endDate: String
) : RemoteMediator<Int, Asteroids>() {

    override suspend fun load(
        loadType: LoadType,
        //        state: PagingState<Int, AsteroidsEntity>
        state: PagingState<Int, Asteroids>
    ): MediatorResult {
        return try {
            // Выполняем запрос к API для получения списка астероидов
            val response = apiRepository.getListAsteroids(
                //offset = state.pages.size * 20, limit = 20
                //                apiKey = APIKEY
                apiKey, startDate, endDate
            ).first()

            // Проверяем, что ответ не пустой и успешный
            //if (response.isSuccessful) {
            if (response.isNotEmpty()) {
                // Начинаем транзакцию для базы данных
                cacheRepository.saveAsteroidsList(
                    //                cacheRepository.saveAsteroidsList(
//                    response.body()?.allAsteroids?.map {
//                        asteroidsMapper.mapResponseToEntity(it)
//                    } ?: arrayListOf()
//                )
//            }
                    response.map { asteroidsMapper.mapToEntity(it) })

                MediatorResult.Success(endOfPaginationReached = false) // Успешная загрузка данных
            } else {
                MediatorResult.Error(Exception("Empty response body"))
            }
            //            MediatorResult.Success(
//                endOfPaginationReached = response.body()?.allAsteroids?.isEmpty() == true
//            )
        } catch (e: IOException) {
            MediatorResult.Error(e) // Ошибка сети
        } catch (e: HttpException) {
            MediatorResult.Error(e) // Ошибка HTTP
        }
    }
}

//Объяснение исправлений
//Удаление дублирующих импортов:
//Убедитесь, что все импорты уникальны и соответствуют используемым классам. Я убрал лишние импорты и оставил только необходимые.
//Использование Flow:
//Метод getListAsteroids возвращает Flow<List<Asteroids>>, и мы используем first() для получения первого значения из потока.
//Проверка ответа:
//Вместо проверки на успешность ответа (как в случае с Response), мы проверяем, что список астероидов не пустой.
//Метод сохранения данных:
//Мы используем метод saveAsteroidsList из cacheRepository, чтобы сохранить преобразованные данные в базе данных.
//Обработка ошибок:
//Ошибки сети и HTTP обрабатываются корректно и возвращаются как MediatorResult.Error.

//ИИ написал:
//import androidx.paging.ExperimentalPagingApi
//import androidx.paging.LoadType
//import androidx.paging.PagingState
//import androidx.paging.RemoteMediator
//import by.vjacheslavkovalenko.asteroidstms.Constants.APIKEY
//import by.vjacheslavkovalenko.asteroidstms.database.entity.AsteroidsEntity
//import by.vjacheslavkovalenko.asteroidstms.mapper.AsteroidsMapper
//import by.vjacheslavkovalenko.asteroidstms.model.Asteroids
//import retrofit2.HttpException
//import java.io.IOException
//import javax.inject.Inject
//
//@OptIn(ExperimentalPagingApi::class)
//class AsteroidsListRemoteMediator @Inject constructor(
//    private val apiRepository: ApiRepository,
//    private val cacheRepository: CacheRepository,
//    private val asteroidsMapper: AsteroidsMapper
//) : RemoteMediator<Int, AsteroidsEntity>() {
//
//    override suspend fun load(
//        loadType: LoadType,
//        state: PagingState<Int, AsteroidsEntity>
//    ): MediatorResult {
//        return try {
//            // Определение текущей страницы для загрузки в зависимости от типа загрузки
//            val page = when (loadType) {
//                LoadType.REFRESH -> {
//                    // Для REFRESH загружаем первую страницу
//                    1
//                }
//                LoadType.APPEND -> {
//                    // Для APPEND загружаем следующую страницу на основе текущего состояния
//                    val lastItem = state.lastItemOrNull()
//                    lastItem?.id?.plus(1) ?: return MediatorResult.Success(endOfPaginationReached = true)
//                }
//                LoadType.PREPEND -> {
//                    // Для PREPEND не поддерживаем, возвращаем успешный результат с флагом конца пагинации
//                    return MediatorResult.Success(endOfPaginationReached = true)
//                }
//            }
//
//            // Выполнение сетевого запроса для получения списка астероидов
//            val response = apiRepository.getListAsteroids(APIKEY)
//
//            if (response.isSuccessful) {
//                response.body()?.allAsteroids?.let { asteroids ->
//                    // Сохранение полученных данных в кэше
//                    cacheRepository.saveAsteroidsList(
//                        asteroids.map { asteroidsMapper.mapResponseToEntity(it) }
//                    )
//                }
//                // Возвращаем успешный результат с указанием, достигли ли конца пагинации
//                MediatorResult.Success(endOfPaginationReached = response.body()?.allAsteroids.isNullOrEmpty())
//            } else {
//                MediatorResult.Error(HttpException(response))
//            }
//        } catch (e: IOException) {
//            MediatorResult.Error(e)
//        } catch (e: HttpException) {
//            MediatorResult.Error(e)
//        }
//    }
//}


//***PERPLEX***V5
//
//package by.vjacheslavkovalenko.asteroidstms.repository
//
//import androidx.paging.ExperimentalPagingApi
//import androidx.paging.PagingState
//import androidx.paging.RemoteMediator
//import androidx.room.withTransaction
//import by.vjacheslavkovalenko.asteroidstms.database.AsteroidsDatabase
//import by.vjacheslavkovalenko.asteroidstms.model.Asteroids
//import by.vjacheslavkovalenko.asteroidstms.network.Api
//import by.vjacheslavkovalenko.asteroidstms.network.entity.ListRadarAsteroidsResponse
//import kotlinx.coroutines.flow.first
//import retrofit2.HttpException
//import java.io.IOException
//
//@OptIn(ExperimentalPagingApi::class)
//class AsteroidsListRemoteMediator(
//    private val apiRepository: ApiRepository,
//    private val cacheRepository: CacheRepository,
//    private val asteroidsMapper: AsteroidsMapper,
//    private val apiKey: String,
//    private val startDate: String,
//    private val endDate: String
//) : RemoteMediator<Int, Asteroids>() {
//
//    override suspend fun load(
//        loadType: LoadType,
//        state: PagingState<Int, Asteroids>
//    ): MediatorResult {
//        return try {
//            // Выполняем запрос к API для получения списка астероидов
//            val response = apiRepository.getListAsteroids(apiKey, startDate, endDate).first()
//
//            // Проверяем, что ответ не пустой и успешный
//            if (response.isNotEmpty()) {
//                // Начинаем транзакцию для базы данных
//                cacheRepository.saveAsteroidsList(response.map { asteroidsMapper.mapToEntity(it) })
//
//                MediatorResult.Success(endOfPaginationReached = false) // Успешная загрузка данных
//            } else {
//                MediatorResult.Error(Exception("Empty response body"))
//            }
//        } catch (e: IOException) {
//            MediatorResult.Error(e) // Ошибка сети
//        } catch (e: HttpException) {
//            MediatorResult.Error(e) // Ошибка HTTP
//        }
//    }
//}














