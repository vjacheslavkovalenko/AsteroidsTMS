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
import by.vjacheslavkovalenko.asteroidstms.model.AsteroidDetails
import by.vjacheslavkovalenko.asteroidstms.model.PictureOfDay

//555
class CacheRepositoryImpl @Inject constructor(
    private val asteroidsDao: AsteroidsDao,
    private val asteroidDetailsDao: AsteroidDetailsDao,
    private val pictureOfDayDao: PictureOfDayDao
) : CacheRepository {

    override suspend fun getAsteroidDetails(asteroidId: String): AsteroidDetails? {
        return asteroidDetailsDao.getAsteroidDetailsById(asteroidId)?.let { entity ->
            // Преобразование из сущности в модель
            AsteroidDetails(
                asteroidId = entity.asteroidId,
                nameAsteroid = entity.nameAsteroid,
                estimatedDiameter = entity.estimatedDiameter
                // Добавьте другие необходимые поля из AsteroidDetailsEntity в AsteroidDetails
            )
        }
    }

    override suspend fun saveAsteroidDetails(asteroidDetails: AsteroidDetails) {
        // Преобразование из модели в сущность перед сохранением
        val entity = AsteroidDetailsEntity(
            asteroidId = asteroidDetails.asteroidId,
            nameAsteroid = asteroidDetails.nameAsteroid,
            estimatedDiameter = asteroidDetails.estimatedDiameter
            // Добавьте другие необходимые поля из AsteroidDetails в AsteroidDetailsEntity
        )
        asteroidDetailsDao.insertAsteroidDetails(entity)
    }

    override suspend fun getListAsteroids(): List<Asteroids> {
        return asteroidsDao.getListAsteroids().map { entity ->
            // Преобразование из сущности в модель
            Asteroids(
                asteroidId = entity.asteroidId,
                nameAsteroid = entity.nameAsteroid,
                estimatedDiameterMax = entity.estimatedDiameterMax,
                estimatedDiameterMin = entity.estimatedDiameterMin,
                isPotentiallyHazardous = entity.isPotentiallyHazardous
                // Добавьте другие необходимые поля из AsteroidsEntity в Asteroids
            )
        }
    }

    override suspend fun saveAsteroids(asteroids: List<Asteroids>) {
        val entities = asteroids.map { asteroid ->
            // Преобразование из модели в сущность перед сохранением
            AsteroidsEntity(
                asteroidId = asteroid.asteroidId,
                nameAsteroid = asteroid.nameAsteroid,
                estimatedDiameterMax = asteroid.estimatedDiameterMax,
                estimatedDiameterMin = asteroid.estimatedDiameterMin,
                isPotentiallyHazardous = asteroid.isPotentiallyHazardous
                // Добавьте другие необходимые поля из Asteroids в AsteroidsEntity
            )
        }
        entities.forEach { asteroidsDao.insertAsteroid(it) }
    }

    override suspend fun getPictureOfDay(): PictureOfDay? {
        return pictureOfDayDao.getPictureOfDay()?.let { entity ->
            // Преобразование из сущности в модель
            PictureOfDay(
                title = entity.title,
                url = entity.url,
                explanation = entity.explanation
            )
        }
    }

    override suspend fun savePictureOfDay(pictureOfDay: PictureOfDay) {
        val entity = PictureOfDayEntity(
            title = pictureOfDay.title,
            url = pictureOfDay.url,
            explanation = pictureOfDay.explanation
        )
        pictureOfDayDao.insertPictureOfDay(entity)
    }

    override suspend fun getAsteroidPagingSource(): PagingSource<Int, AsteroidsEntity> {
        return asteroidsDao.pagingSource()
    }
}
//
//
//Вот пример реализации класса CacheRepositoryImpl, который будет реализовывать интерфейс CacheRepository. Этот класс будет содержать логику доступа к кэшированным данным, используя DAO для взаимодействия с локальной базой данных.
//
//Объяснение кода
//Конструктор:
//Использует внедрение зависимостей для получения экземпляров DAO, необходимых для работы с локальной базой данных.
//Методы:
//getAsteroidDetails: Получает детали астероида по его идентификатору и преобразует их из сущности в модель.
//saveAsteroidDetails: Сохраняет детали астероида, преобразуя их из модели в сущность перед вставкой в базу данных.
//getListAsteroids: Получает список астероидов и преобразует их из сущностей в модели.
//saveAsteroids: Сохраняет список астероидов, преобразуя их из моделей в сущности перед вставкой.
//getPictureOfDay: Получает картину дня и преобразует ее из сущности в модель.
//savePictureOfDay: Сохраняет информацию о картине дня, преобразуя ее из модели в сущность перед вставкой.
//Этот класс реализует интерфейс CacheRepository, обеспечивая доступ к кэшированным данным о астероидах и картине дня.

//Объяснение кода
//Конструктор:
//Использует внедрение зависимостей для получения экземпляров DAO, необходимых для работы с локальной базой данных.
//Методы:
//getAsteroidDetails: Получает детали астероида по его идентификатору и преобразует их из сущности в модель AsteroidDetails.
//saveAsteroidDetails: Сохраняет детали астероида, преобразуя их из модели AsteroidDetails в сущность AsteroidDetailsEntity перед вставкой.
//getListAsteroids: Получает список астероидов и преобразует их из сущностей AsteroidsEntity в модели Asteroids.
//saveAsteroids: Сохраняет список астероидов, преобразуя их из моделей Asteroids в сущности AsteroidsEntity перед вставкой.
//getPictureOfDay: Получает картину дня и преобразует ее из сущности PictureOfDayEntity в модель PictureOfDay.
//savePictureOfDay: Сохраняет информацию о картине дня, преобразуя ее из модели PictureOfDay в сущность PictureOfDayEntity перед вставкой.
//Этот класс реализует интерфейс CacheRepository, обеспечивая доступ к кэшированным данным о астероидах и картине дня, с учетом ваших классов данных.


//class CacheRepositoryImpl @Inject constructor(
//    private val pictureOfDayDao: PictureOfDayDao,
//    private val asteroidsDao: AsteroidsDao,
//    private val asteroidDetailsDao: AsteroidDetailsDao
//) : CacheRepository {
//
//    override suspend fun loadPictureOfDay(title: String): PictureOfDayEntity {
//        return pictureOfDayDao.getPictureOfDay() ?: throw Exception("Picture of the day not found")
//    }
//
//    override suspend fun getListAsteroids(): List<AsteroidsEntity> {
//        return asteroidsDao.getListAsteroids()
//    }
//
//    override fun getPagedListAsteroids(): Flow<PagingData<AsteroidsEntity>> {
//        return Pager(
//            config = PagingConfig(pageSize = 20), //  размер страницы
//            pagingSourceFactory = { asteroidsDao.pagingSource() } // Используем pagingSource из DAO
//        ).flow
//    }
//
//    override suspend fun loadAsteroidDetails(asteroidId: String): AsteroidDetailsEntity {
//        return asteroidDetailsDao.getAsteroidDetailsById(asteroidId)
//    }
//
//    override suspend fun saveAsteroidsList(list: List<AsteroidsEntity>) {
//        asteroidsDao.insertList(list)
//    }
//
//    override suspend fun savePictureOfDay(pictureOfDay: PictureOfDayEntity) {
//        pictureOfDayDao.insertPictureOfDay(pictureOfDay)
//    }
//}
