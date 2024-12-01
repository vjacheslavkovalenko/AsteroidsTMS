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

//555
@Module
@InstallIn(SingletonComponent::class)
object DataBaseModule {

    @Provides
    @Singleton // Обеспечиваем синглтон для базы данных
    fun provideAsteroidsDatabase(@ApplicationContext context: Context): AsteroidsDataBase {
        return Room.databaseBuilder(
            context,
            AsteroidsDataBase::class.java,
            "asteroids_database" // Имя базы данных
        ).build()
    }

    @Provides
    @Singleton // Обеспечиваем синглтон для DAO астероидов
    fun provideAsteroidsDao(database: AsteroidsDataBase): AsteroidsDao {
        return database.getAsteroidsDao()
    }

    @Provides
    @Singleton // Обеспечиваем синглтон для DAO деталей астероидов
    fun provideAsteroidDetailsDao(database: AsteroidsDataBase): AsteroidDetailsDao {
        return database.getAsteroidDetailsDao()
    }

    @Provides
    @Singleton // Обеспечиваем синглтон для DAO картины дня
    fun providePictureOfDayDao(database: AsteroidsDataBase): PictureOfDayDao {
        return database.getPictureOfDayDao()
    }
}

//
//Вот код для объекта DataBaseModule, который будет использоваться с Dagger Hilt для предоставления зависимостей, связанных с базой данных. Он будет предоставлять экземпляры базы данных и DAO классов, которые вы определили ранее.
//
//Класс DataBaseModule будет модулем для внедрения зависимостей с использованием Dagger Hilt. Он будет предоставлять экземпляры базы данных и DAO классов, что упрощает тестирование и поддержку вашего приложения.
//Объяснение кода
//Аннотация @Module: Указывает, что этот класс является модулем Dagger Hilt, который предоставляет зависимости.
//Аннотация @InstallIn(SingletonComponent::class): Указывает, что зависимости, предоставляемые этим модулем, будут доступны в синглтон-компоненте, что означает, что они будут существовать на протяжении всего времени работы приложения.
//Методы @Provides:
//provideAsteroidsDatabase: Метод для предоставления экземпляра базы данных AsteroidsDataBase, используя метод getDatabase.
//provideAsteroidsDao, provideAsteroidDetailsDao, и providePictureOfDayDao: Методы для предоставления экземпляров DAO, получая их из базы данных.
//Этот модуль позволяет легко управлять зависимостями базы данных в вашем приложении и обеспечивает удобный способ их внедрения в другие классы (например, ViewModel или репозитории).


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
//    fun provideAsteroidsDao(dataBase: AsteroidsDataBase): AsteroidsDao {
//        return dataBase.getAsteroidsDao()
//    }
//
//    @Provides
//    @Singleton
//    fun provideAsteroidDetailsDao(dataBase: AsteroidsDataBase): AsteroidDetailsDao {
//        return dataBase.getAsteroidDetailsDao()
//    }
//
//    @Provides
//    @Singleton
//    fun providePictureDao(dataBase: AsteroidsDataBase): PictureOfDayDao {
//        return dataBase.getPictureOfDayDao()
//    }
//}