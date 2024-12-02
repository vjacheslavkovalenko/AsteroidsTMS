package by.vjacheslavkovalenko.asteroidstms.api

import by.vjacheslavkovalenko.asteroidstms.domain.Asteroid
import by.vjacheslavkovalenko.asteroidstms.Constants
import retrofit2.Response
import java.text.SimpleDateFormat
import java.util.*

class AsteroidParser {
    companion object {
        // Метод для парсинга ответа API и получения списка астероидов
        fun parseAsteroidsResponse(response: Response<NearEarthObjectsResponse>): List<Asteroid> {
            val asteroidList = mutableListOf<Asteroid>()

            if (response.isSuccessful) {
                response.body()?.nearEarthObjects?.let { nearEarthObjects ->
                    for (asteroidListPerDate in nearEarthObjects.values) {
                        asteroidList.addAll(asteroidListPerDate)
                    }
                }
            }

            return asteroidList
        }

        // Функция для получения сегодняшней даты в формате, заданном в API_QUERY_DATE_FORMAT
        private fun getTodayDate(): String {
            val calendar = Calendar.getInstance()
            val dateFormat = SimpleDateFormat(Constants.API_QUERY_DATE_FORMAT, Locale.getDefault())
            return dateFormat.format(calendar.time)
        }

        // Функция для получения даты через 6 дней от сегодняшней
        private fun getEndDate(): String {
            val calendar = Calendar.getInstance()
            calendar.add(Calendar.DAY_OF_YEAR, Constants.DEFAULT_END_DATE_DAYS) // Используем DEFAULT_END_DATE_DAYS
            val dateFormat = SimpleDateFormat(Constants.API_QUERY_DATE_FORMAT, Locale.getDefault())
            return dateFormat.format(calendar.time)
        }

        // Функция для получения списка дат на следующие 7 дней
        fun getNextSevenDaysFormattedDates(): List<String> {
            val formattedDateList = mutableListOf<String>()
            val calendar = Calendar.getInstance()

            for (i in 0 until Constants.DEFAULT_END_DATE_DAYS + 1) { // Генерируем 7 дней
                formattedDateList.add(getTodayDate()) // Добавляем сегодняшнюю дату
                calendar.add(Calendar.DAY_OF_YEAR, 1) // Переходим к следующему дню
            }

            return formattedDateList
        }
    }
}