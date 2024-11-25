package by.vjacheslavkovalenko.asteroidstms.utils

import android.os.Build
import androidx.annotation.RequiresApi
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.ZoneId
import java.util.Date

private const val PATTER_FORMAT = "yyyy-MM-dd"
fun Date.convertDateToString(): String {
    val format = SimpleDateFormat(PATTER_FORMAT)
    return format.format(this)
}

@RequiresApi(Build.VERSION_CODES.O)
fun LocalDate.toDate(): Date = Date.from(this.atStartOfDay(ZoneId.systemDefault()).toInstant())

fun String.toDate(): Date {
    val dateFormat = SimpleDateFormat(PATTER_FORMAT)
    return dateFormat.parse(this) ?: Date()
}


//ии ответил
//Ваш файл utils содержит несколько полезных функций для работы с датами в Android. Давайте рассмотрим, нужны ли эти функции в вашем проекте и как они могут быть использованы.
//Анализ функций в файле
//Функция convertDateToString():
//Эта функция расширяет класс Date и позволяет легко преобразовывать объект Date в строку формата "yyyy-MM-dd". Это может быть полезно, если вам нужно отображать даты в пользовательском интерфейсе или передавать их в API.
//Функция toDate() для LocalDate:
//Эта функция расширяет класс LocalDate и преобразует его в объект Date. Это может быть полезно, если вы используете Java 8 или выше и хотите интегрировать новые классы работы с датами с существующим кодом, который использует класс Date.
//Функция toDate() для String:
//Эта функция преобразует строку в объект Date, используя заданный формат. Это полезно, если вы получаете даты в виде строк (например, из API) и хотите конвертировать их для дальнейшего использования.
//Нужен ли вам этот файл?
//Если вы работаете с датами: Если ваш проект требует работы с датами (например, отображение, преобразование или передача дат), то этот файл будет полезен.
//Если вы используете API, возвращающие даты: Если ваш API возвращает даты в строковом формате "yyyy-MM-dd", то функции для преобразования строк в даты будут необходимы.
//Если у вас есть другие классы или функции, работающие с датами: Если у вас есть другие части кода, которые требуют преобразования между Date, LocalDate и строками, то этот файл будет удобным местом для хранения таких функций.
//Рекомендации
//Проверка на необходимость: Если вы не используете эти функции в своем проекте или у вас есть альтернативные способы работы с датами (например, использование библиотеки Java Time), вы можете рассмотреть возможность удаления этого файла.
//Совместимость: Убедитесь, что ваш минимальный уровень API поддерживает использование классов и методов, которые вы используете. Например, функции, использующие LocalDate, требуют API уровня 26 и выше.
//Заключение
//В общем, если ваш проект работает с датами и вам нужно выполнять преобразования между различными форматами и типами данных, то этот файл будет полезен. Если же вы не используете эти функции или у вас уже есть другой способ обработки дат, тогда его можно удалить.