package by.vjacheslavkovalenko.asteroidstms.di

import android.content.ContentValues.TAG
import android.content.Context
import android.util.Log
import androidx.room.Room
import by.vjacheslavkovalenko.asteroidstms.database.AsteroidDetailsDao
import by.vjacheslavkovalenko.asteroidstms.database.AsteroidsDao
import by.vjacheslavkovalenko.asteroidstms.database.AsteroidsDataBase
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
        return Room.databaseBuilder(context, AsteroidsDataBase::class.java, "dataBase").build()
        Log.i(TAG, "myyyyy")
    }

    @Provides
    @Singleton
    fun provideAsteroidsDao(dataBase: AsteroidsDataBase): AsteroidsDao {
        return dataBase.getAsteroidsDao()
    }

    @Provides
    @Singleton
    fun provideAsteroidDetailsDao(dataBase: AsteroidsDataBase): AsteroidDetailsDao {
        return dataBase.getAsteroidDetailsDao()
    }
}