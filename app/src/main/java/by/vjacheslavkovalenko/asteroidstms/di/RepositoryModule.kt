package by.vjacheslavkovalenko.asteroidstms.di

import by.vjacheslavkovalenko.asteroidstms.repository.ApiRepository
import by.vjacheslavkovalenko.asteroidstms.repository.ApiRepositoryImpl
import by.vjacheslavkovalenko.asteroidstms.repository.CacheRepository
import by.vjacheslavkovalenko.asteroidstms.repository.CacheRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindApiRepository(apiRepositoryImpl: ApiRepositoryImpl): ApiRepository

    @Binds
    abstract fun bindCacheRepository(cacheRepositoryImpl: CacheRepositoryImpl): CacheRepository
}


//***PERPLEX***
//
//package by.vjacheslavkovalenko.asteroidstms.di
//
//import by.vjacheslavkovalenko.asteroidstms.repository.ApiRepositoryImpl
//import by.vjacheslavkovalenko.asteroidstms.repository.CacheRepositoryImpl
//import by.vjacheslavkovalenko.asteroidstms.repository.ApiRepository
//import by.vjacheslavkovalenko.asteroidstms.repository.CacheRepository
//import dagger.Binds
//import dagger.Module
//import dagger.hilt.InstallIn
//import dagger.hilt.components.SingletonComponent
//
//@Module
//@InstallIn(SingletonComponent::class)
//abstract class RepositoryModule {
//
//    @Binds
//    abstract fun bindApiRepository(apiRepositoryImpl: ApiRepositoryImpl): ApiRepository
//
//    @Binds
//    abstract fun bindCacheRepository(cacheRepositoryImpl: CacheRepositoryImpl): CacheRepository
//}