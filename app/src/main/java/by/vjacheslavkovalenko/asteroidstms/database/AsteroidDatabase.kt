package by.vjacheslavkovalenko.asteroidstms.database

import androidx.room.Database
import androidx.room.RoomDatabase
import by.vjacheslavkovalenko.asteroidstms.domain.Asteroid

@Database(entities = [Asteroid::class], version = 1)
abstract class AsteroidDatabase : RoomDatabase() {
    abstract fun asteroidDao(): AsteroidDao
}
