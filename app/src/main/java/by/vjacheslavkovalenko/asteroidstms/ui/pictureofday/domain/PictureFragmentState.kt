package by.vjacheslavkovalenko.asteroidstms.ui.pictureofday.domain

import by.vjacheslavkovalenko.asteroidstms.database.entity.PictureOfDayEntity

//555
sealed class PictureFragmentState {
    data object Loading : PictureFragmentState() // Состояние загрузки

    //    data class Success(val pictureUrl: String, val title: String, val explanation: String) : PictureFragmentState() // Успешно полученные данные
    data class Success(val picture: PictureOfDayEntity) :
        PictureFragmentState() // Успешно полученные данные

    data class Error(val message: String) : PictureFragmentState() // Ошибка при получении данных
}
//sealed class PictureFragmentState {
//    data object Init : PictureFragmentState()
//    data class PictureLoaded(val picture: PictureOfDayEntity) : PictureFragmentState()
//    data class Error(val message: String) : PictureFragmentState()
//}

//Этот класс будет определять различные состояния, которые может принимать фрагмент, такие как загрузка данных, успешное получение данных и ошибка.
//
//
//