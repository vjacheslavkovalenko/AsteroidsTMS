package by.vjacheslavkovalenko.asteroidstms.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import by.vjacheslavkovalenko.asteroidstms.database.entity.AsteroidDetailsEntity
import by.vjacheslavkovalenko.asteroidstms.database.entity.AsteroidsEntity
import by.vjacheslavkovalenko.asteroidstms.database.entity.PictureOfDayEntity

@Database(entities = [AsteroidsEntity::class], version = 1)
@TypeConverters(Converters::class)
abstract class AsteroidsDataBase : RoomDatabase() {
    abstract fun getAsteroidsDao(): AsteroidsDao
}