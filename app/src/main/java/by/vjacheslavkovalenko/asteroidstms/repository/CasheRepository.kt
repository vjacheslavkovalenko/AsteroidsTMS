package by.vjacheslavkovalenko.asteroidstms.repository

import by.vjacheslavkovalenko.asteroidstms.database.AsteroidDetailsDao
import by.vjacheslavkovalenko.asteroidstms.database.AsteroidsDao
import by.vjacheslavkovalenko.asteroidstms.database.PictureOfDayDao
import by.vjacheslavkovalenko.asteroidstms.database.entity.AsteroidDetailsEntity
import by.vjacheslavkovalenko.asteroidstms.database.entity.AsteroidsEntity
import by.vjacheslavkovalenko.asteroidstms.database.entity.PictureOfDayEntity
import retrofit2.Response
import javax.inject.Inject

interface CasheRepository {

    suspend fun loadPictureOfDay(title: String): PictureOfDayEntity

    suspend fun getListAsteroids(): List<AsteroidsEntity>

    //для теста (это по id получение конкретного астероида):
    suspend fun loadAsteroidDetails(asteroidId: String): AsteroidDetailsEntity

    suspend fun saveAsteroidsList(list: List<AsteroidsEntity>)

    suspend fun saveAsteroidDetails(asteroidDetails: AsteroidDetailsEntity)

    suspend fun savePictureOfDay(pictureOfDay: PictureOfDayEntity)

    //для получения даты:
//    suspend fun loadAsteroidsRadarDetails(
//        startDate: String,
//        endDate: String,
//        apiKey: String
//    ): AsteroidsRadar
}

class CasheRepositoryImpl @Inject constructor(
    private val pictureOfDayDao: PictureOfDayDao,
    private val asteroidsDao: AsteroidsDao,
    private val asteroidDetailsDao: AsteroidDetailsDao
) : CasheRepository {

    //override suspend fun loadPictureOfDay(title: String): PictureOfDayEntity{
    override suspend fun loadPictureOfDay(title: String): PictureOfDayEntity{
        return pictureOfDayDao.getPictureOfDay()
    }


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

    override suspend fun savePictureOfDay(pictureOfDay: PictureOfDayEntity) {
        pictureOfDayDao.insertPictureOfDay(pictureOfDay)
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


//ИИ написал:
//package by.vjacheslavkovalenko.asteroidstms.repository
//
//import by.vjacheslavkovalenko.asteroidstms.database.AsteroidDetailsDao
//import by.vjacheslavkovalenko.asteroidstms.database.AsteroidsDao
//import by.vjacheslavkovalenko.asteroidstms.database.PictureOfDayDao
//import by.vjacheslavkovalenko.asteroidstms.database.entity.AsteroidDetailsEntity
//import by.vjacheslavkovalenko.asteroidstms.database.entity.AsteroidsEntity
//import by.vjacheslavkovalenko.asteroidstms.database.entity.PictureOfDayEntity
//import javax.inject.Inject
//
//interface CacheRepository {
//
//    suspend fun loadPictureOfDay(title: String): PictureOfDayEntity
//
//    suspend fun getListAsteroids(): List<AsteroidsEntity>
//
//    // Получение конкретного астероида по ID
//    suspend fun loadAsteroidDetails(asteroidId: String): AsteroidDetailsEntity
//
//    suspend fun saveAsteroidsList(list: List<AsteroidsEntity>)
//
//    suspend fun saveAsteroidDetails(asteroidDetails: AsteroidDetailsEntity)
//
//    suspend fun savePictureOfDay(pictureOfDay: PictureOfDayEntity)
//}
//
//class CacheRepositoryImpl @Inject constructor(
//    private val pictureOfDayDao: PictureOfDayDao,
//    private val asteroidsDao: AsteroidsDao,
//    private val asteroidDetailsDao: AsteroidDetailsDao
//) : CacheRepository {
//
//    override suspend fun loadPictureOfDay(title: String): PictureOfDayEntity {
//        // Возможно, стоит добавить проверку на наличие записи с таким заголовком
//        return pictureOfDayDao.getPictureOfDay() ?: throw Exception("Picture of the day not found")
//    }
//
//    override suspend fun getListAsteroids(): List<AsteroidsEntity> {
//        return asteroidsDao.getListAsteroids()
//    }
//
//    override suspend fun loadAsteroidDetails(asteroidId: String): AsteroidDetailsEntity {
//        return asteroidDetailsDao.getAsteroidDetailsById(asteroidId)
//            ?: throw Exception("Asteroid details not found for ID: $asteroidId")
//    }
//
//    override suspend fun saveAsteroidsList(list: List<AsteroidsEntity>) {
//        asteroidsDao.insertList(list)
//    }
//
//    override suspend fun saveAsteroidDetails(asteroidDetails: AsteroidDetailsEntity) {
//        asteroidDetailsDao.insertAsteroidDetails(asteroidDetails)
//    }
//
//    override suspend fun savePictureOfDay(pictureOfDay: PictureOfDayEntity) {
//        pictureOfDayDao.insertPictureOfDay(pictureOfDay)
//    }
//}


//***PERPLEX***
//
//package by.vjacheslavkovalenko.asteroidstms.repository
//
//interface CacheRepository {
//
//     suspend fun loadPictureOfDay(title: String): PictureOfDayEntity
//
//     suspend fun getListAsteroids(): List<AsteroidsEntity>
//
//     suspend fun loadAsteroidDetails(asteroidId: String): AsteroidDetailsEntity
//
//     suspend fun saveAsteroidsList(list: List<AsteroidsEntity>)
//
//     suspend fun savePictureOfDay(pictureOfDay: PictureOfDayEntity)
//}


//***PERPLEX*** !!!!!!
//
//Предлагает это создать отдельным файлом (т.е. разбить на два файла)
//
//package by.vjacheslavkovalenko.asteroidstms.repository
//
//import by.vjacheslavkovalenko.asteroidstms.database.AsteroidDetailsDao
//import by.vjacheslavkovalenko.asteroidstms.database.AsteroidsDao
//import by.vjacheslavkovalenko.asteroidstms.database.PictureOfDayDao
//import by.vjacheslavkovalenko.asteroidstms.database.entity.AsteroidDetailsEntity
//import by.vjacheslavkovalenko.asteroidstms.database.entity.AsteroidsEntity
//import by.vjacheslavkovalenko.asteroidstms.database.entity.PictureOfDayEntity
//import javax.inject.Inject
//
//class CacheRepositoryImpl @Inject constructor(
//     private val pictureOfDayDao: PictureOfDayDao,
//     private val asteroidsDao: AsteroidsDao,
//     private val asteroidDetailsDao: AsteroidDetailsDao
//) : CacheRepository {
//
//     override suspend fun loadPictureOfDay(title: String): PictureOfDayEntity {
//         return pictureOfDayDao.getPictureOfDay()
//     }
//
//     override suspend fun getListAsteroids(): List<AsteroidsEntity> {
//         return asteroidsDao.getListAsteroids()
//     }
//
//     override suspend fun loadAsteroidDetails(asteroidId: String): AsteroidDetailsEntity {
//         return asteroidDetailsDao.getAsteroidDetailsById(asteroidId)
//     }
//
//     override suspend fun saveAsteroidsList(list: List<AsteroidsEntity>) {
//         asteroidsDao.insertList(list)
//     }
//
//     override suspend fun savePictureOfDay(pictureOfDay: PictureOfDayEntity) {
//         pictureOfDayDao.insertPictureOfDay(pictureOfDay)
//     }
//}



//***PERPLEX***V2
//
//package by.vjacheslavkovalenko.asteroidstms.repository
//
//import by.vjacheslavkovalenko.asteroidstms.database.entity.PictureOfDayEntity
//
//interface CacheRepository {
//
//    suspend fun loadPictureOfDay(title: String): PictureOfDayEntity
//
//    suspend fun getListAsteroids(): List<AsteroidsEntity>
//
//    suspend fun loadAsteroidDetails(asteroidId: String): AsteroidDetailsEntity
//
//    suspend fun saveAsteroidsList(list: List<AsteroidsEntity>)
//
//    suspend fun savePictureOfDay(pictureOfDay: PictureOfDayEntity)
//}


//***PERPLEX***V2  !!!!!!!!
//
//CacheRepositoryImpl.kt (обновленный)
//
//package by.vjacheslavkovalenko.asteroidstms.repository
//
//import by.vjacheslavkovalenko.asteroidstms.database.AsteroidDetailsDao
//import by.vjacheslavkovalenko.asteroidstms.database.AsteroidsDao
//import by.vjacheslavkovalenko.asteroidstms.database.PictureOfDayDao
//import by.vjacheslavkovalenko.asteroidstms.database.entity.AsteroidDetailsEntity
//import by.vjacheslavkovalenko.asteroidstms.database.entity.AsteroidsEntity
//import by.vjacheslavkovalenko.asteroidstms.database.entity.PictureOfDayEntity
//import javax.inject.Inject
//
//class CacheRepositoryImpl @Inject constructor(
//     private val pictureOfDayDao: PictureOfDayDao,
//     private val asteroidsDao: AsteroidsDao,
//     private val asteroidDetailsDao: AsteroidDetailsDao
//) : CacheRepository {
//
//     override suspend fun loadPictureOfDay(title: String): PictureOfDayEntity {
//         return pictureOfDayDao.getPictureOfDay() ?: throw Exception("Picture of the day not found")
//     }
//
//     override suspend fun getListAsteroids(): List<AsteroidsEntity> {
//         return asteroidsDao.getListAsteroids()
//     }
//
//     override suspend fun loadAsteroidDetails(asteroidId: String): AsteroidDetailsEntity {
//         return asteroidDetailsDao.getAsteroidDetailsById(asteroidId)
//     }
//
//     override suspend fun saveAsteroidsList(list: List<AsteroidsEntity>) {
//         asteroidsDao.insertList(list)
//     }
//
//     override suspend fun savePictureOfDay(pictureOfDay: PictureOfDayEntity) {
//         pictureOfDayDao.insertPictureOfDay(pictureOfDay)
//     }
//}
