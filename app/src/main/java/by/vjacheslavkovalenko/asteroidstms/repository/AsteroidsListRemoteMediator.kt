package by.vjacheslavkovalenko.asteroidstms.repository

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import by.vjacheslavkovalenko.asteroidstms.Constants.APIKEY
import by.vjacheslavkovalenko.asteroidstms.database.entity.AsteroidsEntity
import by.vjacheslavkovalenko.asteroidstms.mapper.AsteroidsMapper
import by.vjacheslavkovalenko.asteroidstms.model.Asteroids
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpException
import java.io.IOException
import javax.inject.Inject


@OptIn(ExperimentalPagingApi::class)
class AsteroidsListRemoteMediator @Inject constructor(
    private val apiRepository: ApiRepository,
    private val casheRepository: CasheRepository,
    private val asteroidsMapper: AsteroidsMapper
) : RemoteMediator<Int, AsteroidsEntity>() {

    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, AsteroidsEntity>
    ): MediatorResult {
        return try {
            val response = apiRepository.getListAsteroids(
                //offset = state.pages.size * 20, limit = 20
                apiKey = APIKEY
            )
            if (response.isSuccessful) {
                casheRepository.saveAsteroidsList(
                    response.body()?.allAsteroids?.map {
                        asteroidsMapper.mapResponseToEntity(it)
                    } ?: arrayListOf()
                )
            }

            MediatorResult.Success(
                endOfPaginationReached = response.body()?.allAsteroids?.isEmpty() == true
            )
        } catch (e: IOException) {
            MediatorResult.Error(e)
        } catch (e: HttpException) {
            MediatorResult.Error(e)
        }
    }
}


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
























