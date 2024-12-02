package by.vjacheslavkovalenko.asteroidstms.database

import androidx.room.Database
import by.vjacheslavkovalenko.asteroidstms.domain.Asteroid

@Database(entities = [Asteroid::class], version = 1)
abstract data class AsteroidDatabase(){
    abstract fun asteroidDao(): AsteroidDao
}
