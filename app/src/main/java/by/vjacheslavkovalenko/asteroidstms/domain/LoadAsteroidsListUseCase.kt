package by.vjacheslavkovalenko.asteroidstms.domain

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.map
import by.vjacheslavkovalenko.asteroidstms.database.AsteroidsDao
import by.vjacheslavkovalenko.asteroidstms.mapper.AsteroidsMapper
import by.vjacheslavkovalenko.asteroidstms.repository.AsteroidsListRemoteMediator
import by.vjacheslavkovalenko.asteroidstms.repository.CacheRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import by.vjacheslavkovalenko.asteroidstms.model.Asteroids
import kotlinx.coroutines.flow.Flow

class LoadAsteroidsListUseCase @Inject constructor(
    private val cacheRepository: CacheRepository
) {
//    suspend fun loadData() = cacheRepository.getListAsteroids()

    // Метод возвращает Flow<PagingData<Asteroids>>
    fun loadData(): Flow<PagingData<Asteroids>> {
        return cacheRepository.getPagedListAsteroids()
    }
}
//class LoadAsteroidsListUseCase @Inject constructor(
//    private val asteroidsListRemoteMediator: AsteroidsListRemoteMediator,
//    private val asteroidsDao: AsteroidsDao,
//    private val mapper: AsteroidsMapper
//) {
//
//    @OptIn(ExperimentalPagingApi::class)
//    fun loadData() = Pager(
//        config = PagingConfig(pageSize = 20),
//        remoteMediator = asteroidsListRemoteMediator
//    ) {
//        asteroidsDao.pagingSource()
//    }.flow.flowOn(Dispatchers.IO).map {
//        it.map {
//            mapper.mapEntityToDomain(it)
//        }
//    }
//}


//***PERPLEX***
//
//package by.vjacheslavkovalenko.asteroidstms.domain
//
//import by.vjacheslavkovalenko.asteroidstms.repository.CacheRepository
//import javax.inject.Inject
//
//class LoadAsteroidsListUseCase @Inject constructor(private val cacheRepository: CacheRepository) {
//
//    suspend fun loadData() = cacheRepository.getListAsteroids()
//}

