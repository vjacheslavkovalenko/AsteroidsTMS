package by.vjacheslavkovalenko.asteroidstms.ui.list.domain

import androidx.paging.PagingData
import by.vjacheslavkovalenko.asteroidstms.database.entity.AsteroidsEntity
import by.vjacheslavkovalenko.asteroidstms.model.Asteroids
import kotlinx.coroutines.flow.Flow
import by.vjacheslavkovalenko.asteroidstms.network.entity.NearEarthObject

//555
sealed class ListFragmentState {
    data object Loading : ListFragmentState() // Состояние загрузки
    data class Success(val asteroids: List<NearEarthObject>) : ListFragmentState() // Успешное получение данных
    data class Error(val message: String) : ListFragmentState() // Ошибка при получении данных
}
//
//Объяснение кода
//Пакет: Класс находится в пакете by.vjacheslavkovalenko.asteroidstms.ui.list.domain, как вы указали.
//sealed class: Используется sealed class, что позволяет определить ограниченный набор подклассов, представляющих различные состояния.
//Состояния:
//Loading: Объект, представляющий состояние загрузки. Это состояние может быть использовано для отображения индикатора загрузки в пользовательском интерфейсе.
//Success: Данные класса, который содержит список астероидов (List<NearEarthObject>). Это состояние используется, когда данные успешно загружены.
//Error: Данные класса, который содержит сообщение об ошибке (String). Это состояние используется, когда возникает ошибка при загрузке данных.
//

//sealed class ListFragmentState {
//
//    data object Init : ListFragmentState() // Начальное состояние
//
//    data object Loading : ListFragmentState() // Состояние загрузки
//
////    data class ListLoaded(
////        val flowPagingData: Flow<PagingData<AsteroidsEntity>>
////    ) : ListFragmentState()
//
//    data class ListLoaded(
//        val flowPagingData: Flow<PagingData<Asteroids>>
//    ) : ListFragmentState()
//
//    data class Error(val message: String) : ListFragmentState() // Состояние ошибки
//}