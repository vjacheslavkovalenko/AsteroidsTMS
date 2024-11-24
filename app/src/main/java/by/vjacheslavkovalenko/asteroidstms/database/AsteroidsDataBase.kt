package by.vjacheslavkovalenko.asteroidstms.database

import androidx.room.Database
import androidx.room.RoomDatabase
import by.vjacheslavkovalenko.asteroidstms.database.entity.AsteroidDetailsEntity
import by.vjacheslavkovalenko.asteroidstms.database.entity.AsteroidsEntity

@Database(entities = [AsteroidDetailsEntity::class, AsteroidsEntity::class], version = 1)
abstract class AsteroidsDataBase : RoomDatabase() {

    abstract fun getAsteroidsDao(): AsteroidsDao

    abstract fun getAsteroidDetailsDao(): AsteroidDetailsDao
}