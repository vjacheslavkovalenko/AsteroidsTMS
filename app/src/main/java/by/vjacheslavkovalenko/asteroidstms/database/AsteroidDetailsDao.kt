package by.vjacheslavkovalenko.asteroidstms.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import by.vjacheslavkovalenko.asteroidstms.database.entity.AsteroidDetailsEntity
import androidx.room.OnConflictStrategy

//*****
@Dao
interface AsteroidDetailsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAsteroidDetails(asteroidDetails: AsteroidDetailsEntity)

    @Query("SELECT * FROM AsteroidDetails WHERE asteroidId == :asteroidId LIMIT 1")
    suspend fun getAsteroidDetailsById(asteroidId: String): AsteroidDetailsEntity
}
//Объяснение кода
//Аннотация @Dao: Указывает, что этот интерфейс является Data Access Object (DAO) для работы с деталями астероидов.
//Метод insertAsteroidDetails:
//Использует аннотацию @Insert для вставки данных о деталях астероида в базу данных.
//Параметр onConflict = OnConflictStrategy.REPLACE указывает, что при конфликте (например, если запись с таким же идентификатором уже существует) новая запись заменит старую.
//Метод getAsteroidDetails:
//Использует аннотацию @Query для выполнения SQL-запроса, который извлекает детали астероида по его идентификатору.
//Запрос возвращает объект типа AsteroidDetailsEntity, представляющий данные о деталях астероида, или null, если данные отсутствуют.
//Этот интерфейс будет использоваться в вашем приложении для взаимодействия с локальной базой данных и получения информации о деталях астероидов.

//Интерфейс AsteroidDetailsDao будет определять методы для доступа к деталям астероидов в локальной базе данных. Он будет использоваться для получения и сохранения информации о деталях астероидов