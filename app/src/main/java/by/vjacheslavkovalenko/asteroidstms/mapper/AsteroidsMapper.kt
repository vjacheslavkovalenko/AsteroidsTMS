package by.vjacheslavkovalenko.asteroidstms.mapper

import by.vjacheslavkovalenko.asteroidstms.database.entity.AsteroidsEntity
import by.vjacheslavkovalenko.asteroidstms.model.Asteroids
import by.vjacheslavkovalenko.asteroidstms.network.entity.AsteroidResponse
import javax.inject.Inject
import by.vjacheslavkovalenko.asteroidstms.network.entity.NearEarthObject
import org.checkerframework.checker.units.qual.min

//555
object AsteroidsMapper {

    // Преобразование из сетевой модели NearEarthObject в локальную модель Asteroids
    fun mapToAsteroids(entity: NearEarthObject): Asteroids {
        return Asteroids(
            asteroidId = entity.asteroidId,
            nameAsteroid = entity.nameAsteroid,
            estimatedDiameterMax = entity.estimatedDiameter.kilometers.estimatedDiameterMax ?: 0.0,
            estimatedDiameterMin = entity.estimatedDiameter.kilometers.estimatedDiameterMin ?: 0.0,
            isPotentiallyHazardous = entity.isPotentiallyHazardous
        )
    }

    // Преобразование из локальной модели Asteroids в сущность базы данных AsteroidsEntity
    fun mapToEntity(model: Asteroids): AsteroidsEntity {
        return AsteroidsEntity(
            asteroidId = model.asteroidId,
            nameAsteroid = model.nameAsteroid,
            estimatedDiameterMax = model.estimatedDiameterMax,
            estimatedDiameterMin = model.estimatedDiameterMin,
            isPotentiallyHazardous = model.isPotentiallyHazardous
        )
    }

    // Преобразование из сущности базы данных AsteroidsEntity в локальную модель Asteroids
    fun mapToModel(entity: AsteroidsEntity): Asteroids {
        return Asteroids(
            asteroidId = entity.asteroidId,
            nameAsteroid = entity.nameAsteroid,
            estimatedDiameterMax = entity.estimatedDiameterMax,
            estimatedDiameterMin = entity.estimatedDiameterMin,
            isPotentiallyHazardous = entity.isPotentiallyHazardous
        )
    }
}


//
//Объяснение кода
//Пакет: Класс находится в пакете by.vjacheslavkovalenko.asteroidstms.mapper, что указывает на его назначение.
//Методы:
//mapToAsteroids: Преобразует объект Asteroids в другой объект Asteroids. Этот метод может быть полезен, если вы хотите создать копию объекта с изменениями, но в текущем виде он не меняет данные.
//mapToEntity: Преобразует объект Asteroids в объект AsteroidsEntity (сущность базы данных).
//mapToModel: Преобразует объект AsteroidsEntity обратно в объект Asteroids.
//Обработка значений: Все методы используют одни и те же поля для преобразования, что упрощает работу с данными.
//Этот класс обеспечивает чистое преобразование между различными представлениями данных, что упрощает поддержку и тестирование приложения.
//
//
//Класс AsteroidsMapper будет использоваться для преобразования данных между сетевыми моделями и локальными моделями, обеспечивая чистоту кода и разделение ответственности.
//
//
//
//В строке estimatedDiameterMax = entity.estimatedDiameter.kilometers.max ?: 0.0, используется оператор Элвиса (?:), который позволяет задать значение по умолчанию в случае, если значение слева от оператора равно null. Давайте разберем это выражение более подробно.
//1. Структура данных
//Класс NearEarthObject содержит поле estimatedDiameter, которое является объектом класса EstimatedDiameter. Этот класс, в свою очередь, имеет поле kilometers, представляющее собой объект, содержащий максимальный (max) и минимальный (min) диаметр астероида в километрах.
//2. Потенциальная проблема с отсутствующими данными
//При работе с данными, полученными из API, всегда существует вероятность, что некоторые поля могут отсутствовать или быть равными null. Это может произойти по нескольким причинам:
//Данные не были предоставлены API.
//Ошибка в ответе API.
//3. Использование оператора Элвиса
//Оператор Элвиса (?:) позволяет обработать такие случаи:
//entity.estimatedDiameter.kilometers.max: Это выражение пытается получить максимальный диаметр астероида в километрах. Если значение max равно null, то выражение будет возвращать null.
//?: 0.0: Если значение слева (максимальный диаметр) равно null, оператор Элвиса вернет значение справа — 0.0. Это значение по умолчанию, которое используется в случае отсутствия данных.
//4. Зачем это нужно?
//Использование такого подхода позволяет избежать возможных исключений или ошибок, связанных с попыткой использования значения null. Например, если бы вы просто присвоили значение без проверки на null, это могло бы привести к ошибке времени выполнения.
//Пример
//Если API вернул следующий объект:
//json
//{
//    "id": "12345",
//    "name": "Asteroid X",
//    "estimated_diameter": {
//        "kilometers": {
//            "max": null,
//            "min": 1.5
//        }
//    },
//    "is_potentially_hazardous_asteroid": true
//}
//
//В этом случае:
//entity.estimatedDiameter.kilometers.max будет равно null.
//В результате, estimatedDiameterMax получит значение 0.0.
//Это гарантирует, что ваше приложение сможет продолжить работу без сбоев и корректно обработает ситуацию с отсутствующими данными.
//Заключение
//Таким образом, строка estimatedDiameterMax = entity.estimatedDiameter.kilometers.max ?: 0.0 обеспечивает безопасное извлечение данных с установкой значения по умолчанию, что улучшает стабильность и надежность приложения при работе с внешними API.
//
//
//


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


//object AsteroidsMapper {
//
//    // Преобразование из AsteroidsEntity в Asteroids
//    fun mapToModel(entity: AsteroidsEntity): Asteroids {
//        return Asteroids(
//            asteroidId = entity.asteroidId,
//            nameAsteroid = entity.nameAsteroid,
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
//            nameAsteroid = model.nameAsteroid,
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