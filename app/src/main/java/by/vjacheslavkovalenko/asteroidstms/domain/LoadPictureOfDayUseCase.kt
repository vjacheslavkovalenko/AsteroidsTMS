package by.vjacheslavkovalenko.asteroidstms.domain

import by.vjacheslavkovalenko.asteroidstms.repository.CacheRepository
import javax.inject.Inject
import by.vjacheslavkovalenko.asteroidstms.model.PictureOfDay
import by.vjacheslavkovalenko.asteroidstms.database.entity.PictureOfDayEntity

//555
class LoadPictureOfDayUseCase @Inject constructor(
    private val cacheRepository: CacheRepository
) {
    suspend operator fun invoke(): PictureOfDayEntity? {
        val picture = cacheRepository.getPictureOfDay() // Получаем картину дня из репозитория
        return picture?.let {
            // Преобразуем PictureOfDay в PictureOfDayEntity
            PictureOfDayEntity(url = it.url, title = it.title, explanation = it.explanation)
        }
    }
}
//*****
//class LoadPictureOfDayUseCase @Inject constructor(
//    private val cacheRepository: CacheRepository
//) {
//
//    suspend operator fun invoke(): PictureOfDay? {
//        return cacheRepository.getPictureOfDay() // Получаем картину дня из репозитория
//    }
//}
//
//
//Класс LoadPictureOfDayUseCase будет представлять бизнес-логику для получения информации о картине дня из репозитория. Он будет инкапсулировать логику получения данных и преобразования их в модель, используемую во ViewModel.
//
//Объяснение кода
//Конструктор:
//Использует внедрение зависимостей для получения экземпляра CacheRepository, который будет использоваться для доступа к кэшированным данным о картине дня.
//Метод invoke:
//Это операторный метод, что позволяет вызывать экземпляр LoadPictureOfDayUseCase как функцию.
//Возвращает объект PictureOfDay?.
//Внутри метода вызывается метод getPictureOfDay из репозитория, который возвращает информацию о картине дня.
//Этот класс является частью архитектуры MVVM и связывает ViewModel с репозиториями, обеспечивая чистую и понятную бизнес-логику для получения данных о картине дня.


//class LoadPictureOfDayUseCase @Inject constructor(
//   private val cacheRepository: CacheRepository
//) {
//
//   suspend fun loadPictureOfDay(): PictureOfDay {
//      return cacheRepository.loadPictureOfDay() // Получаем картину дня из кэша или API.
//   }
//}


//class LoadPictureOfDayUseCase @Inject constructor(
//    private val cacheRepository: CacheRepository
//) {
//    suspend fun loadPictureOfDay(title: String) = cacheRepository.loadPictureOfDay(title)// Получаем картину дня из кэша или API.
//}