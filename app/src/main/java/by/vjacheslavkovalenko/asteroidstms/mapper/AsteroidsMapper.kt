package by.vjacheslavkovalenko.asteroidstms.mapper

import by.vjacheslavkovalenko.asteroidstms.database.entity.AsteroidsEntity
import by.vjacheslavkovalenko.asteroidstms.model.Asteroids
import by.vjacheslavkovalenko.asteroidstms.network.entity.AsteroidResponse
import javax.inject.Inject

//class AsteroidsMapper @Inject constructor() {
//
//    fun mapResponseToEntity(asteroidsResponse: AsteroidResponse): AsteroidsEntity {
//        return AsteroidsEntity(
//            asteroidsResponse.asteroidId
//        )
//    }
//
//    fun mapEntityToDomain(asteroidsEntity: AsteroidsEntity): Asteroids {
//        return Asteroids(
//            asteroidsEntity.asteroidId
//        )
//    }
//}

object AsteroidsMapper {

    // Преобразование из AsteroidsEntity в Asteroids
    fun mapToModel(entity: AsteroidsEntity): Asteroids {
        return Asteroids(
            asteroidId = entity.asteroidId,
            nameAsteroid = entity.name,
            estimatedDiameterMin = entity.estimatedDiameterMin,
            estimatedDiameterMax = entity.estimatedDiameterMax,
            isPotentiallyHazardous = entity.isPotentiallyHazardous
        )
    }

    // Преобразование из списка AsteroidsEntity в список Asteroids
    fun mapToModelList(entities: List<AsteroidsEntity>): List<Asteroids> {
        return entities.map { mapToModel(it) }
    }

    // Преобразование из Asteroids в AsteroidsEntity
    fun mapToEntity(model: Asteroids): AsteroidsEntity {
        return AsteroidsEntity(
            asteroidId = model.asteroidId,
            name = model.nameAsteroid,
            estimatedDiameterMin = model.estimatedDiameterMin,
            estimatedDiameterMax = model.estimatedDiameterMax,
            isPotentiallyHazardous = model.isPotentiallyHazardous
        )
    }

    // Преобразование из списка Asteroids в список AsteroidsEntity
    fun mapToEntityList(models: List<Asteroids>): List<AsteroidsEntity> {
        return models.map { mapToEntity(it) }
    }
}