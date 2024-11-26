package by.vjacheslavkovalenko.asteroidstms.domain

import by.vjacheslavkovalenko.asteroidstms.model.Asteroids
import by.vjacheslavkovalenko.asteroidstms.repository.ApiRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Response
import java.time.LocalDate
import javax.inject.Inject


class LoadAsteroidsRadarUseCase @Inject constructor(
    private val apiRepository: ApiRepository
) {
    suspend fun execute(apiKey: String): Flow<List<Asteroids>> = flow {
        // Получаем текущую дату и дату через 6 дней в формате "yyyy-MM-dd"
        val startDate = LocalDate.now().toString() // Получаем текущую дату в формате yyyy-MM-dd
        val endDate = LocalDate.now().plusDays(6).toString() // Получаем дату через 6 дней

        // Вызываем метод API с параметрами и эмитим результат
        apiRepository.getListAsteroids(apiKey, startDate, endDate).collect { asteroidsList ->
            emit(asteroidsList) // Эмитим список астероидов
        }
    }
}