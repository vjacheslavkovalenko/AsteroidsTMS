package by.vjacheslavkovalenko.asteroidstms.ui.pictureofday.domain

import by.vjacheslavkovalenko.asteroidstms.model.PictureOfDay

sealed class PictureFragmentState {
    data object Init : PictureFragmentState()
    data class PictureLoaded(val picture: PictureOfDay) : PictureFragmentState()
    data class Error(val message: String) : PictureFragmentState()
}