package by.vjacheslavkovalenko.asteroidstms.domain

class LoadAsteroidDetailsUseCase {
}




//ИИ написал:
//import by.vjacheslavkovalenko.asteroidstms.database.AsteroidsDao
//import by.vjacheslavkovalenko.asteroidstms.mapper.AsteroidsMapper
//import by.vjacheslavkovalenko.asteroidstms.repository.AsteroidDetailsRepository
//import kotlinx.coroutines.Dispatchers
//import kotlinx.coroutines.flow.Flow
//import kotlinx.coroutines.flow.flow
//import kotlinx.coroutines.flow.flowOn
//import javax.inject.Inject
//
//class LoadAsteroidDetailsUseCase @Inject constructor(
//    private val asteroidDetailsRepository: AsteroidDetailsRepository,
//    private val asteroidsDao: AsteroidsDao,
//    private val mapper: AsteroidsMapper
//) {
//
//    // Функция для загрузки деталей астероида по его ID
//    fun loadAsteroidDetails(asteroidId: String): Flow<Result<AsteroidDetailsDomainModel>> = flow {
//        try {
//            // Получаем детали астероида из репозитория (может быть локально или из сети)
//            val asteroidDetailsEntity = asteroidDetailsRepository.getAsteroidDetails(asteroidId)
//
//            // Преобразуем сущность в доменную модель
//            val asteroidDetailsDomainModel = mapper.mapEntityToDomain(asteroidDetailsEntity)
//
//            // Возвращаем результат
//            emit(Result.success(asteroidDetailsDomainModel))
//        } catch (e: Exception) {
//            // Обработка ошибок и возврат результата с ошибкой
//            emit(Result.failure(e))
//        }
//    }.flowOn(Dispatchers.IO)
//}


//***PERPLEX***
//
//package by.vjacheslavkovalenko.asteroidstms.domain
//
//import by.vjacheslavkovalenko.asteroidstms.repository.CacheRepository
//import javax.inject.Inject
//
//class LoadAsteroidDetailsUseCase @Inject constructor(private val cacheRepository: CacheRepository) {
//
//    suspend fun loadAsteroidDetails(asteroidId: String) = cacheRepository.loadAsteroidDetails(asteroidId)
//}

