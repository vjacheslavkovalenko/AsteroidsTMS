package by.vjacheslavkovalenko.asteroidstms.ui.details.domain

import androidx.paging.PagingData
import by.vjacheslavkovalenko.asteroidstms.model.AsteroidDetails
import by.vjacheslavkovalenko.asteroidstms.model.Asteroids
import kotlinx.coroutines.flow.Flow

sealed class DetailsFragmentState {

    data object Init : DetailsFragmentState() // Начальное состояние

    data object DetailsLoading : DetailsFragmentState() // Состояние загрузки

    data class DetailsLoaded(
        val asteroidDetails: AsteroidDetails
    ) : DetailsFragmentState() // Успешно загруженные данные

    data class Error(
        val message: String
    ) : DetailsFragmentState() // Ошибка при загрузке данных

}



//
//sealed class ListFragmentState {
//
//    data object Init : ListFragmentState()
//
//    data class ListLoaded(
//        val flowPagingData: Flow<PagingData<Asteroids>>
//    ) : ListFragmentState()
//}