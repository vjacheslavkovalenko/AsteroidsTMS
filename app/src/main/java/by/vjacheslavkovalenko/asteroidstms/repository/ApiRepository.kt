package by.vjacheslavkovalenko.asteroidstms.repository

import androidx.paging.PagingData
import by.vjacheslavkovalenko.asteroidstms.model.Asteroids
import by.vjacheslavkovalenko.asteroidstms.model.PictureOfDay
import kotlinx.coroutines.flow.Flow

interface ApiRepository {
    /**
     * Получение списка астероидов за указанный период.
     *
     * @param apiKey Ключ API для доступа к NASA API.
     * @param startDate Дата начала периода в формате "yyyy-MM-dd".
     * @param endDate Дата окончания периода в формате "yyyy-MM-dd".
     * @return Flow, содержащий список астероидов.
     */
    suspend fun getListAsteroids(
        apiKey: String,
        startDate: String,
        endDate: String
//    ): Flow<List<Asteroids>>
    ): Flow<PagingData<Asteroids>>

    /**
     * Получение картинки дня.
     *
     * @param apiKey Ключ API для доступа к NASA API.
     * @return Flow, содержащий объект PictureOfDay.
     */
    suspend fun getPictureOfDay(apiKey: String): Flow<PictureOfDay>
}
