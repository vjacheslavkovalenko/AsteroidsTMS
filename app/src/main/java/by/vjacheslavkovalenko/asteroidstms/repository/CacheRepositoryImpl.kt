package by.vjacheslavkovalenko.asteroidstms.repository

import by.vjacheslavkovalenko.asteroidstms.database.AsteroidDetailsDao
import by.vjacheslavkovalenko.asteroidstms.database.AsteroidsDao
import by.vjacheslavkovalenko.asteroidstms.database.PictureOfDayDao
import by.vjacheslavkovalenko.asteroidstms.database.entity.AsteroidDetailsEntity
import by.vjacheslavkovalenko.asteroidstms.database.entity.AsteroidsEntity
import by.vjacheslavkovalenko.asteroidstms.database.entity.PictureOfDayEntity
import javax.inject.Inject
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.PagingSource
import by.vjacheslavkovalenko.asteroidstms.model.Asteroids
import kotlinx.coroutines.flow.Flow

class CacheRepositoryImpl @Inject constructor(
    private val pictureOfDayDao: PictureOfDayDao,
    private val asteroidsDao: AsteroidsDao,
    private val asteroidDetailsDao: AsteroidDetailsDao
) : CacheRepository {

    override suspend fun loadPictureOfDay(title: String): PictureOfDayEntity {
        return pictureOfDayDao.getPictureOfDay() ?: throw Exception("Picture of the day not found")
    }

    override suspend fun getListAsteroids(): List<AsteroidsEntity> {
        return asteroidsDao.getListAsteroids()
    }

    override fun getPagedListAsteroids(): Flow<PagingData<AsteroidsEntity>> {
        return Pager(
            config = PagingConfig(pageSize = 20), //  размер страницы
            pagingSourceFactory = { asteroidsDao.pagingSource() } // Используем pagingSource из DAO
        ).flow
    }

    override suspend fun loadAsteroidDetails(asteroidId: String): AsteroidDetailsEntity {
        return asteroidDetailsDao.getAsteroidDetailsById(asteroidId)
    }

    override suspend fun saveAsteroidsList(list: List<AsteroidsEntity>) {
        asteroidsDao.insertList(list)
    }

    override suspend fun savePictureOfDay(pictureOfDay: PictureOfDayEntity) {
        pictureOfDayDao.insertPictureOfDay(pictureOfDay)
    }
}
