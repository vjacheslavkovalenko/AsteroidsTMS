package by.vjacheslavkovalenko.asteroidstms.di

import android.content.Context
import androidx.room.Room
import by.vjacheslavkovalenko.asteroidstms.database.AsteroidDetailsDao
import by.vjacheslavkovalenko.asteroidstms.database.AsteroidsDao
import by.vjacheslavkovalenko.asteroidstms.database.AsteroidsDataBase
import by.vjacheslavkovalenko.asteroidstms.database.PictureOfDayDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataBaseModule {

    @Provides
    @Singleton
    fun provideAsteroidsDataBase(@ApplicationContext context: Context): AsteroidsDataBase {
//        return Room.databaseBuilder(context, AsteroidsDataBase::class.java, "dataBase").build()
        return Room.databaseBuilder(context, AsteroidsDataBase::class.java, "asteroids_database")
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun provideAsteroidsDao(dataBase: AsteroidsDataBase): AsteroidsDao {
        return dataBase.getAsteroidsDao()
    }

//    @Provides
//    @Singleton
//    fun provideAsteroidDetailsDao(dataBase: AsteroidsDataBase): AsteroidDetailsDao {
//        return dataBase.getAsteroidDetailsDao()
//    }

//    @Provides
//    @Singleton
//    fun providePictureOfDayDao(dataBase: AsteroidsDataBase): PictureOfDayDao {
//        return dataBase.getPictureOfDayDao()
//    }
}


//ии написал
//package by.vjacheslavkovalenko.asteroidstms.di
//
//import android.content.Context
//import androidx.room.Room
//import by.vjacheslavkovalenko.asteroidstms.database.AsteroidDetailsDao
//import by.vjacheslavkovalenko.asteroidstms.database.AsteroidsDao
//import by.vjacheslavkovalenko.asteroidstms.database.AsteroidsDataBase
//import by.vjacheslavkovalenko.asteroidstms.database.PictureOfDayDao
//import dagger.Module
//import dagger.Provides
//import dagger.hilt.InstallIn
//import dagger.hilt.android.qualifiers.ApplicationContext
//import dagger.hilt.components.SingletonComponent
//import javax.inject.Singleton
//
//@Module
//@InstallIn(SingletonComponent::class)
//object DataBaseModule {
//
//    @Provides
//    @Singleton
//    fun provideAsteroidsDataBase(@ApplicationContext context: Context): AsteroidsDataBase {
//        return Room.databaseBuilder(context, AsteroidsDataBase::class.java, "asteroids_database") // Уточнено имя базы данных
//            .fallbackToDestructiveMigration() // Добавлено для обработки миграций, если необходимо
//            .build()
//    }
//
//    @Provides
//    @Singleton
//    fun provideAsteroidsDao(database: AsteroidsDataBase): AsteroidsDao {
//        return database.getAsteroidsDao()
//    }
//
//    @Provides
//    @Singleton
//    fun provideAsteroidDetailsDao(database: AsteroidsDataBase): AsteroidDetailsDao {
//        return database.getAsteroidDetailsDao()
//    }
//
//    @Provides
//    @Singleton
//    fun providePictureOfDayDao(database: AsteroidsDataBase): PictureOfDayDao {
//        return database.getPictureOfDayDao()
//    }
//}


//***PERPLEX***
//
//package by.vjacheslavkovalenko.asteroidstms.di
//
//import android.content.Context
//import androidx.room.Room
//import by.vjacheslavkovalenko.asteroidstms.database.AsteroidsDataBase
//import dagger.Module
//import dagger.Provides
//import dagger.hilt.InstallIn
//import dagger.hilt.android.qualifiers.ApplicationContext
//import dagger.hilt.components.SingletonComponent
//
//@Module
//@InstallIn(SingletonComponent::class)
//object DataBaseModule {
//
//    @Provides
//    @Singleton
//    fun provideAsteroidsDataBase(@ApplicationContext context: Context): AsteroidsDataBase {
//        return Room.databaseBuilder(context, AsteroidsDataBase::class.java, "asteroids_database")
//            .fallbackToDestructiveMigration()
//            .build()
//    }
//
//    @Provides
//    @Singleton
//    fun provideAsteroidsDao(database: AsteroidsDataBase): AsteroidsDao {
//        return database.getAsteroidsDao()
//    }
//}