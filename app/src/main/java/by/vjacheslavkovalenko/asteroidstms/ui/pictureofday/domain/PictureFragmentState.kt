package by.vjacheslavkovalenko.asteroidstms.ui.pictureofday.domain

class PictureFragmentState {
}


//***PERPLEX***V2
//
//файл и каталог созданы по рекомендации ии
//PictureFragmentState.kt (состояние для картины дня)
//
//вот сам код:
//
//package by.vjacheslavkovalenko.asteroidstms.ui.pictureofday.domain
//
//import by.vjacheslavkovalenko.asteroids.model.PictureofThe Day
//
//sealed class PictureFragmentState {
//    object Init : PictureFragmentState()
//    data class PictureLoaded(val picture: PictureofThe Day) : PictureFragmentState()
//    data class Error(val message: String) : PictureFragmentState()
//}