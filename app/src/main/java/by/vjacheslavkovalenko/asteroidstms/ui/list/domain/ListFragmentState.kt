package by.vjacheslavkovalenko.asteroidstms.ui.list.domain

import androidx.paging.PagingData
import by.vjacheslavkovalenko.asteroidstms.database.entity.AsteroidsEntity
import by.vjacheslavkovalenko.asteroidstms.model.Asteroids
import kotlinx.coroutines.flow.Flow

sealed class ListFragmentState {

    data object Init : ListFragmentState() // Начальное состояние

    data object Loading : ListFragmentState() // Состояние загрузки

    data class ListLoaded(
        val flowPagingData: Flow<PagingData<Asteroids>>
    ) : ListFragmentState()

    data class Error(val message: String) : ListFragmentState() // Состояние ошибки
}


//ии написал:
//package by.vjacheslavkovalenko.asteroidstms.ui.list.domain
//
//import androidx.paging.PagingData
//import by.vjacheslavkovalenko.asteroidstms.model.Asteroids
//import kotlinx.coroutines.flow.Flow
//
//// sealed class для управления состояниями фрагмента списка
//sealed class ListFragmentState {
//
//    // Начальное состояние
//    object Init : ListFragmentState()
//
//    // Состояние, когда список загружен
//    data class ListLoaded(
//        val flowPagingData: Flow<PagingData<Asteroids>>
//    ) : ListFragmentState()
//}