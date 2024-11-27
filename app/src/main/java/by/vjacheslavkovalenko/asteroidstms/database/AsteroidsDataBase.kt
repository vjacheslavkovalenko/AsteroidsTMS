package by.vjacheslavkovalenko.asteroidstms.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import by.vjacheslavkovalenko.asteroidstms.database.entity.AsteroidDetailsEntity
import by.vjacheslavkovalenko.asteroidstms.database.entity.AsteroidsEntity
import by.vjacheslavkovalenko.asteroidstms.database.entity.PictureOfDayEntity

@Database(
    entities = [AsteroidsEntity::class, AsteroidDetailsEntity::class, PictureOfDayEntity::class],
    version = 1,
    //exportSchema = false // Рекомендуется отключить экспорт схемы на этапе разработки
)
@TypeConverters(Converters::class)
abstract class AsteroidsDataBase : RoomDatabase() {
    abstract fun getAsteroidsDao(): AsteroidsDao
    abstract fun getAsteroidDetailsDao(): AsteroidDetailsDao
    abstract fun getPictureOfDayDao(): PictureOfDayDao
}