package by.vjacheslavkovalenko.asteroidstms.repository

import by.vjacheslavkovalenko.asteroidstms.database.entity.AsteroidDetailsEntity
import by.vjacheslavkovalenko.asteroidstms.database.entity.AsteroidsEntity
import by.vjacheslavkovalenko.asteroidstms.database.entity.PictureOfDayEntity
import kotlinx.coroutines.flow.Flow
import androidx.paging.PagingData

interface CacheRepository {

    suspend fun loadPictureOfDay(title: String): PictureOfDayEntity

    suspend fun getListAsteroids(): List<AsteroidsEntity>

    // метод для получения списка астероидов как Flow<PagingData<Asteroids>>
//    fun getPagedListAsteroids(): Flow<PagingData<Asteroids>>

    // Метод для получения списка астероидов как Flow<PagingData<AsteroidsEntity>>
    fun getPagedListAsteroids(): Flow<PagingData<AsteroidsEntity>>

    //для теста (это по id получение конкретного астероида):
    suspend fun loadAsteroidDetails(asteroidId: String): AsteroidDetailsEntity

    suspend fun saveAsteroidsList(list: List<AsteroidsEntity>)

    suspend fun savePictureOfDay(pictureOfDay: PictureOfDayEntity)

}