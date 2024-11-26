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