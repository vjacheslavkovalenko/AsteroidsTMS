package by.vjacheslavkovalenko.asteroidstms.ui.details.domain

import by.vjacheslavkovalenko.asteroidstms.model.AsteroidDetails

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