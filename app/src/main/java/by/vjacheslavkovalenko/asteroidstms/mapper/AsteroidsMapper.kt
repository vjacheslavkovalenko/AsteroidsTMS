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

//Класс AsteroidsMapper будет использоваться для преобразования данных между сущностями базы
// данных (AsteroidsEntity) и бизнес-логикой (Asteroids). Это полезно, чтобы изолировать
// логику преобразования данных и сделать код более чистым и поддерживаемым.

//Этот класс можно использовать в репозиториях или других слоях вашего приложения, где необходимо
// преобразовать данные между уровнями.

//Функции для преобразования:
//mapToModel(entity: AsteroidsEntity): Преобразует одну сущность базы данных в модель.
//mapToModelList(entities: List<AsteroidsEntity>): Преобразует список сущностей базы данных в список моделей.
//mapToEntity(model: Asteroids): Преобразует модель в сущность базы данных.
//mapToEntityList(models: List<Asteroids>): Преобразует список моделей в список сущностей базы данных.

////***PERPLEX***
//
//package by.vjacheslavkovalenko.asteroidstms.mapper
//
//import by.vjacheslavkovalenko.asteroidstms.database.entity.AsteroidsEntity
//import by.vjacheslavkovalenko.asteroidstms.model.Asteroids
//
//object AsteroidsMapper {
//
//    // Преобразование из AsteroidsEntity в Asteroids
//    fun mapToModel(entity: AsteroidsEntity): Asteroids {
//        return Asteroids(
//            asteroidId = entity.asteroidId,
//            name = entity.name,
//            estimatedDiameterMin = entity.estimatedDiameterMin,
//            estimatedDiameterMax = entity.estimatedDiameterMax,
//            isPotentiallyHazardous = entity.isPotentiallyHazardous
//        )
//    }
//
//    // Преобразование из списка AsteroidsEntity в список Asteroids
//    fun mapToModelList(entities: List<AsteroidsEntity>): List<Asteroids> {
//        return entities.map { mapToModel(it) }
//    }
//
//    // Преобразование из Asteroids в AsteroidsEntity
//    fun mapToEntity(model: Asteroids): AsteroidsEntity {
//        return AsteroidsEntity(
//            asteroidId = model.asteroidId,
//            name = model.name,
//            estimatedDiameterMin = model.estimatedDiameterMin,
//            estimatedDiameterMax = model.estimatedDiameterMax,
//            isPotentiallyHazardous = model.isPotentiallyHazardous
//        )
//    }
//
//    // Преобразование из списка Asteroids в список AsteroidsEntity
//    fun mapToEntityList(models: List<Asteroids>): List<AsteroidsEntity> {
//        return models.map { mapToEntity(it) }
//    }
//}