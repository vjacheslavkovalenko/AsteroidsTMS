package by.vjacheslavkovalenko.asteroidstms.database

import android.content.Context
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import by.vjacheslavkovalenko.asteroidstms.database.entity.AsteroidDetailsEntity
import by.vjacheslavkovalenko.asteroidstms.database.entity.AsteroidsEntity
import by.vjacheslavkovalenko.asteroidstms.database.entity.PictureOfDayEntity
import androidx.room.Room

//*****
@Database(
    entities = [AsteroidsEntity::class, AsteroidDetailsEntity::class, PictureOfDayEntity::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(Converters::class) // Указываем класс конвертеров для Room
abstract class AsteroidsDataBase : RoomDatabase() {

    abstract fun getAsteroidsDao(): AsteroidsDao // Метод для получения DAO для астероидов

    abstract fun getAsteroidDetailsDao(): AsteroidDetailsDao // Метод для получения DAO для деталей астероидов

    abstract fun getPictureOfDayDao(): PictureOfDayDao // Метод для получения DAO для картины дня

    companion object {
        @Volatile
        private var INSTANCE: AsteroidsDataBase? = null

        fun getDatabase(context: Context): AsteroidsDataBase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AsteroidsDataBase::class.java,
                    "asteroids_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
//Переименованы методы доступа к DAO на getAsteroidsDao(), getAsteroidDetailsDao() и getPictureOfDayDao(), как вы и указали.
//Объяснение кода
//Аннотация @Database:
//Указывает, что этот класс является базой данных Room.
//Параметр entities содержит список сущностей, которые будут храниться в базе данных.
//Параметр version указывает версию базы данных.
//Параметр exportSchema указывает, нужно ли экспортировать схему базы данных.
//Аннотация @TypeConverters:
//Указывает класс конвертеров, который будет использоваться для преобразования сложных типов данных (например, списков) в формат, который может быть сохранен в базе данных.
//Абстрактные методы:
//asteroidsDao(), asteroidDetailsDao(), и pictureOfDayDao() возвращают соответствующие DAO для работы с данными.
//Синглтон:
//Реализован паттерн синглтона для обеспечения того, чтобы база данных создавалась только один раз.
//Метод getDatabase() проверяет, существует ли уже экземпляр базы данных; если нет, он создает новый.
//Этот класс будет использоваться в вашем приложении для доступа к локальной базе данных и взаимодействия с данными о астероидах и картине дня.


//@Database(
//    entities = [AsteroidsEntity::class, AsteroidDetailsEntity::class, PictureOfDayEntity::class],
//    version = 1,
//    //exportSchema = false // Рекомендуется отключить экспорт схемы на этапе разработки
//)
//@TypeConverters(Converters::class)
//abstract class AsteroidsDataBase : RoomDatabase() {
//    abstract fun getAsteroidsDao(): AsteroidsDao
//    abstract fun getAsteroidDetailsDao(): AsteroidDetailsDao
//    abstract fun getPictureOfDayDao(): PictureOfDayDao
//}