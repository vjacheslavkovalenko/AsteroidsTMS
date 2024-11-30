package by.vjacheslavkovalenko.asteroidstms.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import by.vjacheslavkovalenko.asteroidstms.database.entity.PictureOfDayEntity
import androidx.room.OnConflictStrategy

//*****
@Dao
interface PictureOfDayDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPictureOfDay(pictureOfDay: PictureOfDayEntity)

    @Query("SELECT * FROM PictureOfDay LIMIT 1")
    suspend fun getPictureOfDay(): PictureOfDayEntity?
}
//Объяснение кода
//Аннотация @Dao: Указывает, что этот интерфейс является Data Access Object (DAO) для работы с базой данных.
//Метод insertPictureOfDay:
//Использует аннотацию @Insert для вставки данных о картине дня в базу данных.
//Параметр onConflict = OnConflictStrategy.REPLACE указывает, что при конфликте (например, если запись с таким же идентификатором уже существует) новая запись заменит старую.
//Метод getPictureOfDay:
//Использует аннотацию @Query для выполнения SQL-запроса, который извлекает данные о картине дня из базы данных.
//Запрос возвращает только одну запись (LIMIT 1), так как предполагается, что в базе данных будет храниться только одна картина дня за раз.
//Метод возвращает объект типа PictureOfDayEntity, который представляет данные о картине дня, или null, если данные отсутствуют.

//Вот код для интерфейса PictureOfDayDao, который определяет методы для доступа к данным о картине дня в локальной базе данных.


//
//@Dao
//interface PictureOfDayDao {
//
//    @Insert
//    suspend fun insertPictureOfDay(pictureOfDay: PictureOfDayEntity)
//
//    @Query("SELECT * FROM PictureOfDay LIMIT 1")
//    suspend fun getPictureOfDay(): PictureOfDayEntity?
//}