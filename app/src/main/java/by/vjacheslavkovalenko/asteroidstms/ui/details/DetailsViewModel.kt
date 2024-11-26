package by.vjacheslavkovalenko.asteroidstms.ui.details

import androidx.lifecycle.ViewModel
import by.vjacheslavkovalenko.asteroidstms.domain.LoadAsteroidDetailsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import androidx.lifecycle.viewModelScope
import by.vjacheslavkovalenko.asteroidstms.ui.details.domain.DetailsFragmentState
import javax.inject.Inject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope

@HiltViewModel
class DetailsViewModel @Inject constructor(
    private val loadAsteroidDetailsUseCase: LoadAsteroidDetailsUseCase
) : ViewModel() {

    private val stateLiveData = MutableLiveData<DetailsFragmentState>(DetailsFragmentState.Init)
    val state: LiveData<DetailsFragmentState> get() = stateLiveData

    // Функция для загрузки деталей астероида по его ID
    fun loadAsteroidDetails(asteroidId: String) {
        stateLiveData.value =
            DetailsFragmentState.DetailsLoading // Устанавливаем состояние загрузки
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val details = loadAsteroidDetailsUseCase.loadAsteroidDetails(asteroidId)
//                  stateLiveData.value = DetailsFragmentState.DetailsLoaded(details)
                stateLiveData.postValue(DetailsFragmentState.DetailsLoaded(details)) // Используем postValue для обновления из фона
            } catch (e: Exception) {
//                  stateLiveData.value = DetailsFragmentState.Error(e.message ?: "Unknown error")
                stateLiveData.postValue(
                    DetailsFragmentState.Error(
                        e.message ?: "Unknown error"
                    )
                )// Устанавливаем состояние ошибки
            }
        }
    }
}


//ии написал
//package by.vjacheslavkovalenko.asteroidstms.ui.details
//
//import androidx.lifecycle.ViewModel
//import androidx.lifecycle.viewModelScope
//import by.vjacheslavkovalenko.asteroidstms.domen.LoadAsteroidDetailsUseCase
//import by.vjacheslavkovalenko.asteroidstms.ui.details.domain.DetailsFragmentState
//import dagger.hilt.android.lifecycle.HiltViewModel
//import kotlinx.coroutines.Dispatchers
//import kotlinx.coroutines.flow.MutableStateFlow
//import kotlinx.coroutines.flow.StateFlow
//import kotlinx.coroutines.launch
//import javax.inject.Inject
//
//@HiltViewModel
//class DetailsViewModel @Inject constructor(
//    private val loadAsteroidDetailsUseCase: LoadAsteroidDetailsUseCase
//) : ViewModel() {
//
//    private val _state = MutableStateFlow<DetailsFragmentState>(DetailsFragmentState.Init)
//    val state: StateFlow<DetailsFragmentState> get() = _state
//
//    // Функция для загрузки деталей астероида по его ID
//    fun loadAsteroidDetails(asteroidId: String) {
//        viewModelScope.launch(Dispatchers.IO) {
//            // Здесь можно добавить обработку ошибок, если это необходимо
//            try {
//                val result = loadAsteroidDetailsUseCase.loadAsteroidDetails(asteroidId)
//                _state.emit(DetailsFragmentState.DetailsLoaded(result))
//            } catch (e: Exception) {
//                _state.emit(DetailsFragmentState.Error(e.message ?: "Unknown error"))
//            }
//        }
//    }
//}


//рекомендации ии
//Пример состояния DetailsFragmentState
//Вот пример того, как может выглядеть класс DetailsFragmentState, который будет использоваться в DetailsViewModel:
//
//package by.vjacheslavkovalenko.asteroidstms.ui.details.domain
//
//import by.vjacheslavkovalenko.asteroidstms.model.Asteroids
//
//sealed class DetailsFragmentState {
//    object Init : DetailsFragmentState()
//    data class DetailsLoaded(val asteroid: Asteroids) : DetailsFragmentState()
//    data class Error(val message: String) : DetailsFragmentState()
//}


//***PERPLEX***
//
//package by.vjacheslavkovalenko.asteroidstms.ui.details
//
//import androidx.lifecycle.ViewModel
// import androidx.lifecycle.viewModelScope
// import by.vjacheslavkovalenko.asteroidstms.domain.LoadAsteroidDetailsUseCase
// import by.vjaceslavkovalenko.asteroids.ui.details.domain.DetailsFragmentState
// import dagger.hilt.android.lifecycle.HiltViewModel
// import kotlinx.coroutines.Dispatchers
// import kotlinx.coroutines.flow.MutableStateFlow
// import kotlinx.coroutines.flow.StateFlow
// import kotlinx.coroutines.launch
// import javax.inject.Inject
//
//@HiltViewModel
//class DetailsViewModel @Inject constructor(
//      private val loadAsteroidDetailsUseCase: LoadAsteroidDetailsUseCase
// ) : ViewModel() {
//
//      private val _state = MutableStateFlow<DetailsFragmentState>(DetailsFragmentState.Init)
//      val state: StateFlow<DetailsFragmentState> get() = _state
//
//      // Функция для загрузки деталей астероида по его ID
//      fun loadAsteroidDetails(asteroidId: String) {
//          viewModelScope.launch(Dispatchers.IO) {
//              try {
//                  val result = loadAsteroidDetailsUseCase.loadAsteroidDetails(asteroidId)
//                  _state.emit(DetailsFragmentState.DetailsLoaded(result))
//              } catch (e: Exception) {
//                  _state.emit(DetailsFragmentState.Error(e.message ?: "Unknown error"))
//              }
//          }
//      }
//}


