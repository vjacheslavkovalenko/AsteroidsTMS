package by.vjacheslavkovalenko.asteroidstms.utils

import java.text.SimpleDateFormat
import java.util.*

object DateUtils {
    private const val DATE_FORMAT = "yyyy-MM-dd" // Формат даты

    // Функция для получения сегодняшней даты в формате "yyyy-MM-dd"
    fun getTodayDate(): String {
        val calendar = Calendar.getInstance()
        val dateFormat = SimpleDateFormat(DATE_FORMAT, Locale.getDefault())
        return dateFormat.format(calendar.time)
    }

    // Функция для получения даты через 6 дней от сегодняшней
    fun getEndDate(): String {
        val calendar = Calendar.getInstance()
        calendar.add(Calendar.DAY_OF_YEAR, 6) // Добавляем 6 дней
        val dateFormat = SimpleDateFormat(DATE_FORMAT, Locale.getDefault())
        return dateFormat.format(calendar.time)
    }
}