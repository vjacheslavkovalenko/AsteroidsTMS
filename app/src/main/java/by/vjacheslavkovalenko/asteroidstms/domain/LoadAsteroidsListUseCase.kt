package by.vjacheslavkovalenko.asteroidstms.domain

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.map
import by.vjacheslavkovalenko.asteroidstms.database.AsteroidsDao
import by.vjacheslavkovalenko.asteroidstms.database.entity.AsteroidsEntity
import by.vjacheslavkovalenko.asteroidstms.mapper.AsteroidsMapper
import by.vjacheslavkovalenko.asteroidstms.repository.AsteroidsListRemoteMediator
import by.vjacheslavkovalenko.asteroidstms.repository.CacheRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import by.vjacheslavkovalenko.asteroidstms.model.Asteroids
import by.vjacheslavkovalenko.asteroidstms.network.entity.AsteroidResponse
import by.vjacheslavkovalenko.asteroidstms.repository.ApiRepository
import kotlinx.coroutines.flow.Flow

//555
class LoadAsteroidsListUseCase @Inject constructor(
    private val apiRepository: ApiRepository
) {
    suspend operator fun invoke(startDate: String, endDate: String, apiKey: String): AsteroidResponse {
        return apiRepository.getAsteroids(startDate, endDate, apiKey)
    }
}
//
//Вот окончательный вариант класса LoadAsteroidsListUseCase, который будет использоваться для получения списка астероидов из репозитория. Этот класс будет находиться в пакете, который вы определили для бизнес-логики, например, by.vjacheslavkovalenko.asteroidstms.domain.
//
//
//

//*****
//class LoadAsteroidsListUseCase @Inject constructor(
//    private val cacheRepository: CacheRepository
//) {
//
//    suspend operator fun invoke(): List<Asteroids> {
//        return cacheRepository.getListAsteroids() // Получаем список астероидов из репозитория
//    }
//}


//Класс LoadAsteroidsListUseCase будет представлять бизнес-логику для получения списка астероидов из репозитория. Он будет инкапсулировать логику получения данных и преобразования их в модель, используемую во ViewModel.
//
//Объяснение кода
//Конструктор:
//Использует внедрение зависимостей для получения экземпляра CacheRepository, который будет использоваться для доступа к кэшированным данным об астероидах.
//Метод invoke:
//Это операторный метод, что позволяет вызывать экземпляр LoadAsteroidsListUseCase как функцию.
//Возвращает список объектов Asteroids.
//Внутри метода вызывается метод getListAsteroids из репозитория, который возвращает список астероидов.
//Этот класс является частью архитектуры MVVM и связывает ViewModel с репозиториями, обеспечивая чистую и понятную бизнес-логику для получения данных о списке астероидов.


//class LoadAsteroidsListUseCase @Inject constructor(
//    private val cacheRepository: CacheRepository,
//    private val apiRepository: ApiRepository
//) {
////    suspend fun loadData() = cacheRepository.getListAsteroids()
//
//    // Метод возвращает Flow<PagingData<Asteroids>>  //поменять, если не сработает, на безэнтити
//    fun loadData(): Flow<PagingData<AsteroidsEntity>> {
//        return cacheRepository.getPagedListAsteroids()
//    }
//
//    //        suspend fun execute(apiKey: String, startDate: String, endDate: String): Flow<List<Asteroids>> {
//    suspend fun execute(
//        apiKey: String,
//        startDate: String,
//        endDate: String
//    ): Flow<PagingData<Asteroids>> {
//        return apiRepository.getListAsteroids(
//            apiKey,
//            startDate,
//            endDate
//        )// Получаем список астероидов из репозитория.
//    }
//
//}
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
