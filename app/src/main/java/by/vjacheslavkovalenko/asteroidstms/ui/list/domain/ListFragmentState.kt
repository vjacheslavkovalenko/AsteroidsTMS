package by.vjacheslavkovalenko.asteroidstms.ui.list.domain

import androidx.paging.PagingData
import by.vjacheslavkovalenko.asteroidstms.database.entity.AsteroidsEntity
import by.vjacheslavkovalenko.asteroidstms.model.Asteroids
import kotlinx.coroutines.flow.Flow

sealed class ListFragmentState {

    data object Init : ListFragmentState()

    data class ListLoaded(
        val flowPagingData: Flow<PagingData<Asteroids>>
    ) : ListFragmentState()
}