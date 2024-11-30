package by.vjacheslavkovalenko.asteroidstms.utils

import android.os.Build
import androidx.annotation.RequiresApi
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.ZoneId
import java.util.Date
import java.time.format.DateTimeFormatter
import java.util.Calendar
import java.util.Locale

//555
object DateUtils {

    // Функция для получения сегодняшней даты в формате YYYY-MM-DD
    fun getTodayDate(): String {
        val calendar = Calendar.getInstance()
        val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        return dateFormat.format(calendar.time)
    }

    // Функция для получения даты через 6 дней от сегодняшней даты в формате YYYY-MM-DD
    fun getEndDate(): String {
        val calendar = Calendar.getInstance()
        calendar.add(Calendar.DAY_OF_YEAR, 6) // Добавляем 6 дней
        val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        return dateFormat.format(calendar.time)
    }
}
//
//Объяснение кода
//Импорт необходимых классов:
//Импортируем классы SimpleDateFormat, Calendar, Date и Locale, которые необходимы для работы с датами.
//Объект DateUtils:
//Создаем объект-утилиту, который содержит функции для работы с датами.
//Функция getTodayDate:
//Использует Calendar для получения текущей даты.
//Форматирует дату в строку формата "YYYY-MM-DD" с помощью SimpleDateFormat.
//Функция getEndDate:
//Также использует Calendar, но перед получением даты добавляет 6 дней к текущей дате.
//Форматирует полученную дату аналогично.


//object DateUtils {
//
//    private val formatter: DateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
//
//    fun getCurrentDate(): String {
//        return LocalDate.now().format(formatter) // Возвращает сегодняшнюю дату в формате "yyyy-MM-dd".
//    }
//
//    fun getEndDate(startDate: String): String {
//        val startLocalDate = LocalDate.parse(startDate, formatter)
//        val endLocalDate = startLocalDate.plusDays(6) // Прибавляет 6 дней к стартовой дате.
//        return endLocalDate.format(formatter) // Возвращает конечную дату в формате "yyyy-MM-dd".
//    }
//}

//private const val PATTER_FORMAT = "yyyy-MM-dd"
//fun Date.convertDateToString(): String {
//    val format = SimpleDateFormat(PATTER_FORMAT)
//    return format.format(this)
//}
//
//@RequiresApi(Build.VERSION_CODES.O)
//fun LocalDate.toDate(): Date = Date.from(this.atStartOfDay(ZoneId.systemDefault()).toInstant())
//
//fun String.toDate(): Date {
//    val dateFormat = SimpleDateFormat(PATTER_FORMAT)
//    return dateFormat.parse(this) ?: Date()
//}