package by.vjacheslavkovalenko.asteroidstms.database

import androidx.room.Database
import androidx.room.RoomDatabase
import by.vjacheslavkovalenko.asteroidstms.database.entity.AsteroidDetailsEntity
import by.vjacheslavkovalenko.asteroidstms.database.entity.AsteroidsEntity
import by.vjacheslavkovalenko.asteroidstms.database.entity.PictureOfDayEntity

@Database(
    entities = [AsteroidDetailsEntity::class, AsteroidsEntity::class, PictureOfDayEntity::class],
    version = 1
)
abstract class AsteroidsDataBase : RoomDatabase() {

    abstract fun getAsteroidsDao(): AsteroidsDao

    abstract fun getAsteroidDetailsDao(): AsteroidDetailsDao

    abstract fun getPictureOfDayDao(): PictureOfDayDao
}

//***PERPLEX***
//
//package by.vjacheslavkovalenko.asteroidstms.database
//
//import androidx.room.Database
//import androidx.room.RoomDatabase
//import androidx.room.TypeConverters
//import by.vjacheslavkovalenko.asteroidstms.database.entity.AsteroidsEntity
//
//@Database(entities = [AsteroidsEntity::class], version = 1)
//@TypeConverters(Converters::class)
//abstract class AsteroidsDataBase : RoomDatabase() {
//    abstract fun getAsteroidsDao(): AsteroidsDao
//}