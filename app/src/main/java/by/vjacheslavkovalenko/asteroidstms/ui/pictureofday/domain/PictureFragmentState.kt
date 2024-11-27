package by.vjacheslavkovalenko.asteroidstms.ui.pictureofday.domain

import by.vjacheslavkovalenko.asteroidstms.database.entity.PictureOfDayEntity

sealed class PictureFragmentState {
    data object Init : PictureFragmentState()
    data class PictureLoaded(val picture: PictureOfDayEntity) : PictureFragmentState()
    data class Error(val message: String) : PictureFragmentState()
}