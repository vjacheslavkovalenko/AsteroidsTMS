package by.vjacheslavkovalenko.asteroidstms.di

import androidx.paging.PagingSource
import by.vjacheslavkovalenko.asteroidstms.database.entity.AsteroidsEntity
import by.vjacheslavkovalenko.asteroidstms.repository.ApiRepository
import by.vjacheslavkovalenko.asteroidstms.repository.ApiRepositoryImpl
import by.vjacheslavkovalenko.asteroidstms.repository.AsteroidPagingSource
import by.vjacheslavkovalenko.asteroidstms.repository.CacheRepository
import by.vjacheslavkovalenko.asteroidstms.repository.CacheRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


//Класс RepositoryModule будет модулем для внедрения зависимостей с использованием Dagger Hilt, который связывает интерфейсы репозиториев с их реализациями. Он будет предоставлять необходимые зависимости для работы с данными в вашем приложении.
//Объяснение кода
//Аннотация @Module: Указывает, что этот класс является модулем Dagger Hilt, который предоставляет зависимости.
//Аннотация @InstallIn(SingletonComponent::class): Указывает, что зависимости, предоставляемые этим модулем, будут доступны в синглтон-компоненте, что означает, что они будут существовать на протяжении всего времени работы приложения.
//Метод bindApiRepository:
//Использует аннотацию @Binds для связывания интерфейса ApiRepository с его реализацией ApiRepositoryImpl.
//Это позволяет Dagger Hilt автоматически предоставлять экземпляры ApiRepositoryImpl всякий раз, когда требуется экземпляр ApiRepository.
//Этот модуль упрощает внедрение зависимостей в вашем приложении и позволяет легко управлять репозиториями и их реализациями.


//555
@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindApiRepository(apiRepositoryImpl: ApiRepositoryImpl): ApiRepository

    @Binds
    abstract fun bindCacheRepository(cacheRepositoryImpl: CacheRepositoryImpl): CacheRepository

    @Binds
    abstract fun bindAsteroidPagingSource(asteroidPagingSource: AsteroidPagingSource): PagingSource<Int, AsteroidsEntity>
}