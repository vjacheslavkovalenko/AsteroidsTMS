package by.vjacheslavkovalenko.asteroidstms.repository

import by.vjacheslavkovalenko.asteroidstms.database.AsteroidDetailsDao
import by.vjacheslavkovalenko.asteroidstms.database.AsteroidsDao
import by.vjacheslavkovalenko.asteroidstms.database.entity.AsteroidDetailsEntity
import by.vjacheslavkovalenko.asteroidstms.database.entity.AsteroidsEntity
import retrofit2.Response
import javax.inject.Inject

interface CasheRepository {

    suspend fun getListAsteroids(): List<AsteroidsEntity>

    //для теста (это по id получение конкретного астероида):
    suspend fun loadAsteroidDetails(asteroidId: String): AsteroidDetailsEntity

    suspend fun saveAsteroidsList(list: List<AsteroidsEntity>)

    suspend fun saveAsteroidDetails(asteroidDetails: AsteroidDetailsEntity)

    //для получения даты:
//    suspend fun loadAsteroidsRadarDetails(
//        startDate: String,
//        endDate: String,
//        apiKey: String
//    ): AsteroidsRadar
}

class CasheRepositoryImpl @Inject constructor(
    private val asteroidsDao: AsteroidsDao,
    private val asteroidDetailsDao: AsteroidDetailsDao
) : CasheRepository {

    override suspend fun getListAsteroids(): List<AsteroidsEntity> {
        return asteroidsDao.getListAsteroids()
    }

    override suspend fun loadAsteroidDetails(asteroidId: String): AsteroidDetailsEntity {
        return asteroidDetailsDao.getAsteroidDetailsById(asteroidId)
    }

    override suspend fun saveAsteroidsList(list: List<AsteroidsEntity>) {
        asteroidsDao.insertList(list)
    }

    override suspend fun saveAsteroidDetails(asteroidDetails: AsteroidDetailsEntity) {
        asteroidDetailsDao.insertAsteroidDetails(asteroidDetails)
    }

//    override suspend fun loadAsteroidsRadarDetails(
//        startDate: String,
//        endDate: String,
//        apiKey: String
//    ): AsteroidsRadar {
//        TODO("Not yet implemented")
//    }

//    override suspend fun loadAsteroidsRadarDetails(
//        startDate: String,
//        endDate: String,
//        apiKey: String
//    ): AsteroidsRadar {
//
//    }
}