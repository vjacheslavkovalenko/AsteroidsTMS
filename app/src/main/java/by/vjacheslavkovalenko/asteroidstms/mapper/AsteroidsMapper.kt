package by.vjacheslavkovalenko.asteroidstms.mapper

import by.vjacheslavkovalenko.asteroidstms.database.entity.AsteroidsEntity
import by.vjacheslavkovalenko.asteroidstms.model.Asteroids
import by.vjacheslavkovalenko.asteroidstms.network.entity.AsteroidResponse
import javax.inject.Inject

class AsteroidsMapper @Inject constructor() {

    fun mapResponseToEntity(asteroidsResponse: AsteroidResponse): AsteroidsEntity {
        return AsteroidsEntity(
            asteroidsResponse.asteroidId
        )
    }

    fun mapEntityToDomain(asteroidsEntity: AsteroidsEntity): Asteroids {
        return Asteroids(
            asteroidsEntity.asteroidId
        )
    }
}