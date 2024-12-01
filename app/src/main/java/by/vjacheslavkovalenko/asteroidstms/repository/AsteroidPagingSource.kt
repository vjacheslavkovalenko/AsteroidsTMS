package by.vjacheslavkovalenko.asteroidstms.repository

import androidx.paging.PagingSource
import androidx.paging.PagingState
import by.vjacheslavkovalenko.asteroidstms.database.AsteroidsDao
import by.vjacheslavkovalenko.asteroidstms.model.Asteroids
import by.vjacheslavkovalenko.asteroidstms.database.entity.AsteroidsEntity
import by.vjacheslavkovalenko.asteroidstms.network.Api
import by.vjacheslavkovalenko.asteroidstms.network.entity.NearEarthObject


//555
class AsteroidPagingSource(
    private val api: Api,
    private val startDate: String,
    private val endDate: String,
    private val apiKey: String
) : PagingSource<Int, NearEarthObject>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, NearEarthObject> {
        return try {
            val response = api.getAsteroids(startDate, endDate, apiKey)
            val nearEarthObjects = response.nearEarthObjects // Получаем список объектов

            LoadResult.Page(
                data = nearEarthObjects,
                prevKey = null, // Укажите предыдущий ключ, если он есть
                nextKey = null // Укажите следующий ключ, если он есть
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, NearEarthObject>): Int? {
        return null // Логика для получения ключа для обновления
    }
}

