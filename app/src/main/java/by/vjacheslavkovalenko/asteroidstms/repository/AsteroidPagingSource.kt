package by.vjacheslavkovalenko.asteroidstms.repository

import androidx.paging.PagingSource
import androidx.paging.PagingState
import by.vjacheslavkovalenko.asteroidstms.database.AsteroidsDao
import by.vjacheslavkovalenko.asteroidstms.model.Asteroids
import by.vjacheslavkovalenko.asteroidstms.database.entity.AsteroidsEntity

class AsteroidPagingSource(
    private val asteroidsDao: AsteroidsDao
) : PagingSource<Int, AsteroidsEntity>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, AsteroidsEntity> {
        val page = params.key ?: 0 // Начинаем с первой страницы (0)

        return try {
            // Используем метод pagingSource() для получения списка астероидов
            val response = asteroidsDao.getListAsteroids() // Получаем список астероидов из DAO

            LoadResult.Page(
                data = response, // Здесь мы возвращаем список сущностей AsteroidsEntity
                prevKey = if (page == 0) null else page - 1,
                nextKey = if (response.isEmpty()) null else page + 1 // Установите ключ для следующей страницы
            )
        } catch (exception: Exception) {
            LoadResult.Error(exception)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, AsteroidsEntity>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }
}
