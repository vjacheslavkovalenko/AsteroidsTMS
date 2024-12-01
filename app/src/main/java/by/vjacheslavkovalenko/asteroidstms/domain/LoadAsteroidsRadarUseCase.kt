package by.vjacheslavkovalenko.asteroidstms.domain

import by.vjacheslavkovalenko.asteroidstms.model.Asteroids
import by.vjacheslavkovalenko.asteroidstms.repository.ApiRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Response
import java.time.LocalDate
import javax.inject.Inject

//class LoadAsteroidsRadarUseCase @Inject constructor(
//    private val apiRepository: ApiRepository
//) {
//    suspend fun execute(apiKey: String): Flow<List<Asteroids>> = flow {
//        // Получаем текущую дату и дату через 6 дней в формате "yyyy-MM-dd"
//        val startDate = LocalDate.now().toString() // Получаем текущую дату в формате yyyy-MM-dd
//        val endDate = LocalDate.now().plusDays(6).toString() // Получаем дату через 6 дней
//
//        // Вызываем метод API с параметрами и эмитим результат
//        apiRepository.getListAsteroids(apiKey, startDate, endDate).collect { asteroidsList ->
//            emit(asteroidsList) // Эмитим список астероидов
//        }
//    }
//}

//
//Нужно ли мне создавать class LoadAsteroidsRadarUseCase ?
//
//Создание класса `LoadAsteroidsRadarUseCase` зависит от того, какую функциональность вы хотите реализовать в вашем приложении и как вы планируете управлять данными о астероидах.
//
//### Когда стоит создавать `LoadAsteroidsRadarUseCase`?
//
//1. **Необходимость в бизнес-логике**: Если у вас есть специфическая логика, связанная с получением данных о радаре астероидов, которая не охватывается существующими классами использования (например, `LoadAsteroidsListUseCase`), то создание этого класса может быть оправданным.
//
//2. **Отдельный источник данных**: Если данные о радаре астероидов поступают из другого API или источника, отличного от тех, что используются в других классах использования, вам может понадобиться отдельный класс для управления этой логикой.
//
//3. **Упрощение кода**: Если вы хотите разделить ответственность и сделать код более чистым и понятным, создание отдельного класса использования для радаров может помочь в этом.
//
//### Когда не стоит создавать `LoadAsteroidsRadarUseCase`?
//
//1. **Избыточность**: Если текущие классы использования уже покрывают необходимую функциональность и могут быть адаптированы для работы с данными о радаре без значительных изменений, создание нового класса может быть избыточным.
//
//2. **Сложность управления зависимостями**: Каждый новый класс добавляет уровень сложности в управление зависимостями и тестирование. Если текущая архитектура уже сложна, стоит рассмотреть возможность упрощения.
//
//### Заключение
//
//Если у вас есть четкая необходимость в отдельной бизнес-логике для работы с данными о радаре астероидов, и это не дублирует существующий функционал, то создание класса `LoadAsteroidsRadarUseCase` будет оправданным. В противном случае, возможно, стоит рассмотреть возможность интеграции этой функциональности в существующие классы использования.
//
//Citations:
//[1] https://ppl-ai-file-upload.s3.amazonaws.com/web/direct-files/15126032/703db4c1-8cde-4c76-9aef-d14f14d42149/shemaRis.txt
//[2] https://ppl-ai-file-upload.s3.amazonaws.com/web/direct-files/15126032/75bbd519-88f4-4bd0-8551-11bff48ade46/shemaText.txt
//[3] https://ppl-ai-file-upload.s3.amazonaws.com/web/direct-files/15126032/bcd37266-1108-4116-a86b-c785796e1e4a/shemaKod.txt