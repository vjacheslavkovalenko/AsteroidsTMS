package by.vjacheslavkovalenko.asteroidstms.domain

import by.vjacheslavkovalenko.asteroidstms.repository.CacheRepository
import javax.inject.Inject

class LoadPictureOfDayUseCase @Inject constructor(
    private val cacheRepository: CacheRepository
) {
    suspend fun loadPictureOfDay(title: String) = cacheRepository.loadPictureOfDay(title)
}