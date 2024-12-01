package by.vjacheslavkovalenko.asteroidstms.domain

import by.vjacheslavkovalenko.asteroidstms.model.AsteroidDetails
import by.vjacheslavkovalenko.asteroidstms.repository.CacheRepository
import by.vjacheslavkovalenko.asteroidstms.database.entity.AsteroidDetailsEntity
import by.vjacheslavkovalenko.asteroidstms.repository.ApiRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject



//555
class LoadAsteroidDetailsUseCase @Inject constructor(
    private val cacheRepository: CacheRepository
) {

    suspend operator fun invoke(asteroidId: String): AsteroidDetails? {
        return cacheRepository.getAsteroidDetails(asteroidId)
    }
}
//
//Класс LoadAsteroidDetailsUseCase будет представлять бизнес-логику для получения деталей астероида из репозитория. Он будет инкапсулировать логику получения данных и преобразования их в модель, используемую во ViewModel.
//
//Объяснение кода
//Конструктор:
//Использует внедрение зависимостей для получения экземпляра CacheRepository, который будет использоваться для доступа к кэшированным данным.
//Метод invoke:
//Это операторный метод, что позволяет вызывать экземпляр LoadAsteroidDetailsUseCase как функцию.
//Принимает строку asteroidId в качестве параметра и возвращает объект AsteroidDetails?.
//Внутри метода вызывается метод getAsteroidDetails из репозитория, который возвращает детали астероида по его идентификатору.
//Этот класс является частью архитектуры MVVM и связывает ViewModel с репозиториями, обеспечивая чистую и понятную бизнес-логику для получения данных о деталях астероидов.

//class LoadAsteroidDetailsUseCase @Inject constructor(
//    private val repository: ApiRepository
//) {
//    suspend fun execute(asteroidId: Int): AsteroidDetails {
//        return repository.getAsteroidDetails(asteroidId)
//    }
//}
//Объяснение кода
//Конструктор с внедрением зависимостей: Используется Dagger Hilt для внедрения зависимости ApiRepository, который отвечает за взаимодействие с источниками данных (например, API или базой данных).
//Метод execute:
//Принимает идентификатор астероида (asteroidId) в качестве параметра.
//Вызывает метод getAsteroidDetails из репозитория для получения деталей астероида.
//Возвращает объект типа AsteroidDetails, который содержит информацию о конкретном астероиде.
//Этот класс позволяет ViewModel запрашивать данные о деталях астероида, не заботясь о том, как именно эти данные получаются.


//class LoadAsteroidDetailsUseCase @Inject constructor(
//    private val cacheRepository: CacheRepository
//) {
//
//    suspend fun loadAsteroidDetails(asteroidId: String): AsteroidDetails {
//        // Получаем детали астероида (сущность) из кэша
//        val entity = cacheRepository.loadAsteroidDetails(asteroidId)
//
//        // Преобразуем сущность в модель
//        return mapEntityToModel(entity)
//    }
//
//    private fun mapEntityToModel(entity: AsteroidDetailsEntity): AsteroidDetails {
//        return AsteroidDetails(
//            asteroidId = entity.asteroidId,
//            nameAsteroid = entity.nameAsteroid,
//            estimatedDiameter = entity.estimatedDiameter // Список диаметров
//        )
//    }
//}


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