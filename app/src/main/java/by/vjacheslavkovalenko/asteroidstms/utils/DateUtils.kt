package by.vjacheslavkovalenko.asteroidstms.utils

import android.os.Build
import androidx.annotation.RequiresApi
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.ZoneId
import java.util.Date
import java.time.format.DateTimeFormatter

object DateUtils {

    private val formatter: DateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")

    fun getCurrentDate(): String {
        return LocalDate.now().format(formatter) // Возвращает сегодняшнюю дату в формате "yyyy-MM-dd".
    }

    fun getEndDate(startDate: String): String {
        val startLocalDate = LocalDate.parse(startDate, formatter)
        val endLocalDate = startLocalDate.plusDays(6) // Прибавляет 6 дней к стартовой дате.
        return endLocalDate.format(formatter) // Возвращает конечную дату в формате "yyyy-MM-dd".
    }
}

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