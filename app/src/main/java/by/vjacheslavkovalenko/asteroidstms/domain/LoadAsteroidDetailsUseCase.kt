package by.vjacheslavkovalenko.asteroidstms.domain

import by.vjacheslavkovalenko.asteroidstms.model.AsteroidDetails
import by.vjacheslavkovalenko.asteroidstms.repository.CacheRepository
import by.vjacheslavkovalenko.asteroidstms.database.entity.AsteroidDetailsEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LoadAsteroidDetailsUseCase @Inject constructor(
    private val cacheRepository: CacheRepository
) {

    suspend fun loadAsteroidDetails(asteroidId: String): AsteroidDetails {
        // Получаем детали астероида (сущность) из кэша
        val entity = cacheRepository.loadAsteroidDetails(asteroidId)

        // Преобразуем сущность в модель
        return mapEntityToModel(entity)
    }

    private fun mapEntityToModel(entity: AsteroidDetailsEntity): AsteroidDetails {
        return AsteroidDetails(
            asteroidId = entity.asteroidId,
            nameAsteroid = entity.nameAsteroid,
            estimatedDiameter = entity.estimatedDiameter // Список диаметров
        )
    }
}
//   private fun mapEntityToModel(entity: AsteroidDetailsEntity): AsteroidDetails {
//       return AsteroidDetails(
//           asteroidId = entity.asteroidId,
//           nameAsteroid = entity.nameAsteroid,
//           estimatedDiameterMin = entity.diameterMin,
//           estimatedDiameterMax = entity.diameterMax,
//           isPotentiallyHazardous = entity.isPotentiallyHazardous // Добавьте нужные поля здесь.
//       )
//   }
//}