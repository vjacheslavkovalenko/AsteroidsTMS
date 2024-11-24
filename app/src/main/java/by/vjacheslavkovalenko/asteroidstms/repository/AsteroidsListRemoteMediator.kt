package by.vjacheslavkovalenko.asteroidstms.repository

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
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
                offset = state.pages.size * 20, limit = 20
            )
            if (response.isSuccessful) {
                casheRepository.saveAsteroidsList(
                    response.body()?.results?.map {
                        asteroidsMapper.mapResponseToEntity(it)
                    } ?: arrayListOf()
                )
            }

            MediatorResult.Success(
                endOfPaginationReached = response.body()?.results?.isEmpty() == true
            )
        } catch (e: IOException) {
            MediatorResult.Error(e)
        } catch (e: HttpException) {
            MediatorResult.Error(e)
        }
    }
}



























