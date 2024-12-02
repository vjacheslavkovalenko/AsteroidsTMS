package by.vjacheslavkovalenko.asteroidstms.utils

import java.text.SimpleDateFormat
import java.util.*

class Utils {
    companion object {
        fun convertDateStringToFormattedString(date: Date, format: String, locale: Locale = Locale.getDefault()): String {
            val formatter = SimpleDateFormat(format, locale)
            return formatter.format(date)
        }

        fun addDaysToDate(date: Date, daysToAdd: Int): Date {
            val calendar = Calendar.getInstance()
            calendar.time = date
            calendar.add(Calendar.DATE, daysToAdd)
            return calendar.time
        }

        fun getCurrentDate(): String {
            val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
            return dateFormat.format(Date())
        }
    }
}