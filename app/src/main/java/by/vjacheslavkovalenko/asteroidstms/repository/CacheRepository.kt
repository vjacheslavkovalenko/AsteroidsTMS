package by.vjacheslavkovalenko.asteroidstms.repository

import by.vjacheslavkovalenko.asteroidstms.database.entity.AsteroidDetailsEntity
import by.vjacheslavkovalenko.asteroidstms.database.entity.AsteroidsEntity
import by.vjacheslavkovalenko.asteroidstms.database.entity.PictureOfDayEntity
import kotlinx.coroutines.flow.Flow
import androidx.paging.PagingData
import by.vjacheslavkovalenko.asteroidstms.model.AsteroidDetails
import by.vjacheslavkovalenko.asteroidstms.model.PictureOfDay
import by.vjacheslavkovalenko.asteroidstms.model.Asteroids

//*****
interface CacheRepository {
    suspend fun getAsteroidDetails(asteroidId: String): AsteroidDetails?
    suspend fun saveAsteroidDetails(asteroidDetails: AsteroidDetails)
    suspend fun getListAsteroids(): List<Asteroids> // Метод переименован
    suspend fun saveAsteroids(asteroids: List<Asteroids>)
    suspend fun getPictureOfDay(): PictureOfDay?
    suspend fun savePictureOfDay(pictureOfDay: PictureOfDay)
}

//
//Интерфейс CacheRepository будет определять методы для работы с кэшированными данными, такими как данные, сохраненные в локальной базе данных. Этот интерфейс будет использоваться для доступа к кэшированным данным о астероидах и картине дня.
//Объяснение методов
//getAsteroidDetails(asteroidId: String):
//Возвращает детали астероида по его идентификатору. Если данные отсутствуют, возвращает null.
//saveAsteroidDetails(asteroidDetails: AsteroidDetails):
//Сохраняет детали астероида в кэше.
//getAllAsteroids():
//Возвращает список всех астероидов, сохраненных в кэше.
//saveAsteroids(asteroids: List<Asteroids>):
//Сохраняет список астероидов в кэше.
//getPictureOfDay():
//Возвращает информацию о картине дня из кэша. Если данные отсутствуют, возвращает null.
//savePictureOfDay(pictureOfDay: PictureOfDay):
//Сохраняет информацию о картине дня в кэше.
//Этот интерфейс будет реализован в классе CacheRepositoryImpl, который будет содержать логику для доступа к данным, хранящимся в базе данных или других кэшах.
//
//
//Почему в interface CacheRepository suspend fun getListAsteroids(): List<Asteroids> , а не suspend fun getListAsteroids(): List<AsteroidsEntity> ?
//В интерфейсе `CacheRepository` метод `suspend fun getListAsteroids(): List<Asteroids>` возвращает список объектов типа `Asteroids`, а не `AsteroidsEntity`, по следующим причинам:
//
//1. **Слой модели**:
//   - `Asteroids` представляет собой модель данных, которая используется в бизнес-логике и пользовательском интерфейсе. Это абстракция, которая может содержать только необходимые для отображения данные, а также методы и логику, специфичные для приложения.
//   - `AsteroidsEntity`, с другой стороны, представляет собой сущность базы данных, которая используется для хранения данных в локальной базе данных. Она может содержать дополнительные поля или структуру, которые не нужны в UI.
//
//2. **Разделение ответственности**:
//   - Использование моделей (`Asteroids`) в репозиториях позволяет отделить бизнес-логику от логики доступа к данным. Это упрощает тестирование и поддержку кода.
//   - Если вы будете возвращать `AsteroidsEntity` из репозитория, это приведет к тому, что слой представления будет зависеть от структуры базы данных, что нарушает принцип инкапсуляции.
//
//3. **Гибкость**:
//   - Если в будущем потребуется изменить структуру базы данных или добавить новые поля в `AsteroidsEntity`, это не повлияет на слой представления, если он работает с моделью `Asteroids`. Вы сможете адаптировать маппинг между сущностями и моделями без изменения интерфейсов.
//
//### Рекомендация
//Если вам нужно получить данные из базы данных и преобразовать их в модели для использования в приложении, вы можете создать методы в репозитории или использовать мапперы для преобразования между сущностями и моделями.
//
//Если вам нужно больше информации о том, как организовать эти преобразования или любые другие аспекты вашего проекта, дайте знать!
//
//Citations:
//[1] https://ppl-ai-file-upload.s3.amazonaws.com/web/direct-files/15126032/703db4c1-8cde-4c76-9aef-d14f14d42149/shemaRis.txt
//[2] https://ppl-ai-file-upload.s3.amazonaws.com/web/direct-files/15126032/75bbd519-88f4-4bd0-8551-11bff48ade46/shemaText.txt
//[3] https://ppl-ai-file-upload.s3.amazonaws.com/web/direct-files/15126032/bcd37266-1108-4116-a86b-c785796e1e4a/shemaKod.txt
//


//
//interface CacheRepository {
//
//    suspend fun loadPictureOfDay(title: String): PictureOfDayEntity
//
//    suspend fun getListAsteroids(): List<AsteroidsEntity>
//
//    // метод для получения списка астероидов как Flow<PagingData<Asteroids>>
////    fun getPagedListAsteroids(): Flow<PagingData<Asteroids>>
//
//    // Метод для получения списка астероидов как Flow<PagingData<AsteroidsEntity>>
//    fun getPagedListAsteroids(): Flow<PagingData<AsteroidsEntity>>
//
//    //для теста (это по id получение конкретного астероида):
//    suspend fun loadAsteroidDetails(asteroidId: String): AsteroidDetailsEntity
//
//    suspend fun saveAsteroidsList(list: List<AsteroidsEntity>)
//
//    suspend fun savePictureOfDay(pictureOfDay: PictureOfDayEntity)
//
//}