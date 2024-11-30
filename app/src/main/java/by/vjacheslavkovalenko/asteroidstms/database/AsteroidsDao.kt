package by.vjacheslavkovalenko.asteroidstms.database

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import by.vjacheslavkovalenko.asteroidstms.database.entity.AsteroidsEntity
import androidx.room.OnConflictStrategy

//*****
@Dao
interface AsteroidsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAsteroid(asteroid: AsteroidsEntity)

    @Query("SELECT * FROM Asteroids")
    suspend fun getListAsteroids(): List<AsteroidsEntity> // Метод возвращает список астероидов

    @Query("SELECT * FROM Asteroids WHERE asteroidId = :id LIMIT 1")
    suspend fun getAsteroidById(id: String): AsteroidsEntity? // Метод возвращает астероид по его идентификатору
}


//
//Интерфейс AsteroidsDao будет определять методы для доступа к данным об астероидах в локальной базе данных. Он будет использоваться для получения и сохранения информации о астероидах.
//Объяснение кода
//Аннотация @Dao: Указывает, что этот интерфейс является Data Access Object (DAO) для работы с данными об астероидах.
//Метод insertAsteroid:
//Использует аннотацию @Insert для вставки данных об астероиде в базу данных.
//Параметр onConflict = OnConflictStrategy.REPLACE указывает, что при конфликте (например, если запись с таким же идентификатором уже существует) новая запись заменит старую.
//Метод getListAsteroids:
//Использует аннотацию @Query для выполнения SQL-запроса, который извлекает все данные об астероидах из базы данных.
//Возвращает список объектов типа AsteroidsEntity.
//Метод getAsteroidById:
//Использует аннотацию @Query для выполнения SQL-запроса, который извлекает данные об астероиде по его идентификатору.
//Запрос возвращает объект типа AsteroidsEntity, представляющий данные об астероиде, или null, если данные отсутствуют.
//Этот интерфейс будет использоваться в вашем приложении для взаимодействия с локальной базой данных и получения информации о астероидах.

//Вот код для интерфейса AsteroidsDao, который определяет методы для работы с данными об астероидах в локальной базе данных.

//@Dao
//interface AsteroidsDao {
//
//    @Insert
//    suspend fun insertList(list: List<AsteroidsEntity>)
//
//    @Query("SELECT * FROM Asteroids")
//    suspend fun getListAsteroids(): List<AsteroidsEntity>
//
//    @Query("SELECT * FROM Asteroids")
//    fun pagingSource(): PagingSource<Int, AsteroidsEntity>
//
//    @Query("SELECT * FROM Asteroids WHERE asteroidId = :id LIMIT 1")
//    suspend fun getAsteroidById(id: String): AsteroidsEntity?
//}