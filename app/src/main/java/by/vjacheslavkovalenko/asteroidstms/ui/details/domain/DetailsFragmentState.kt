package by.vjacheslavkovalenko.asteroidstms.ui.details.domain

import by.vjacheslavkovalenko.asteroidstms.model.AsteroidDetails

//555
sealed class DetailsFragmentState {
    object Loading : DetailsFragmentState() // Состояние загрузки
    data class Success(val asteroidDetails: AsteroidDetails) : DetailsFragmentState() // Успешное получение данных
    data class Error(val message: String) : DetailsFragmentState() // Ошибка при получении данных
}