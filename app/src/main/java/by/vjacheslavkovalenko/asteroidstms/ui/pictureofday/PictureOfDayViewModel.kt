package by.vjacheslavkovalenko.asteroidstms.ui.pictureofday

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import by.vjacheslavkovalenko.asteroidstms.domain.LoadAsteroidsListUseCase
import by.vjacheslavkovalenko.asteroidstms.domain.LoadPictureOfDayUseCase
import by.vjacheslavkovalenko.asteroidstms.ui.list.domain.ListFragmentState
import by.vjacheslavkovalenko.asteroidstms.ui.pictureofday.domain.PictureFragmentState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
 import kotlinx.coroutines.flow.MutableStateFlow
 import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class PictureOfDayViewModel @Inject constructor(
    private val loadPictureOfDayUseCase: LoadPictureOfDayUseCase
    ) : ViewModel() {

    private val stateFlow = MutableStateFlow<PictureFragmentState>(PictureFragmentState.Init)
    val state: StateFlow<PictureFragmentState> get() = stateFlow


    // Функция для загрузки картины дня
    fun loadPicture() {
        viewModelScope.launch {
            try {
                val result = loadPictureOfDayUseCase.loadPictureOfDay("title") // Укажите нужный заголовок или используйте API для получения заголовка.
                stateFlow.emit(PictureFragmentState.PictureLoaded(result))
            } catch (e: Exception) {
                stateFlow.emit(PictureFragmentState.Error(e.message ?: "Unknown error"))
            }
        }
    }
}

    //@HiltViewModel
//class DogImageViewModel @Inject constructor(
//    private val repository: DogRepository
//) : ViewModel() {
//
//    val image = MutableLiveData<DogImage>()
//
//    fun loadDogImage() {
//        viewModelScope.launch(Dispatchers.IO) {
//            val response: Response<DogImageResponse> = repository.getRandomDogImage()
//            if (response.isSuccessful) {
//                response.body()?.let { dogImageResponse ->
//                    image.postValue(dogImageResponse.message())
//                }
//            }
//        }
//    }
//}



//    private val loadAsteroidsListUseCase: LoadAsteroidsListUseCase
//    ) : ViewModel() {
//
//        val state = MutableStateFlow<ListFragmentState>(ListFragmentState.Init)
//
//        fun LoadData() {
//            viewModelScope.launch(Dispatchers.IO) {
//                state.emit(
//                    ListFragmentState.ListLoaded(
//                        loadAsteroidsListUseCase.loadData().cachedIn(viewModelScope)))
//            }
//        }



//---------27 урок---------

//private const val LOG_TAG = "DogImageViewModel"
//
//@HiltViewModel
//class DogImageViewModel @Inject constructor(
//    private val repository: DogRepository
//) : ViewModel() {
//
//    val image = MutableLiveData<DogImage>()
//
//    var showError: ((throwable: Throwable) -> Unit)? = null
//
//    private val coroutineExceptionHandler =
//        CoroutineExceptionHandler { coroutineContext, throwable ->
//            showError?.invoke(throwable)
//            Log.e(LOG_TAG, throwable.localizedMessage)
//        }
//
//    fun loadDogImage() {
//        viewModelScope.launch(Dispatchers.IO + coroutineExceptionHandler) {
//            val response: Response<DogImageResponse> = repository.getRandomDogImage()
//            if (response.isSuccessful) {
//                response.body()?.let { dogImageResponse ->
//                    image.postValue(dogImageResponse.toDogImage())
//                }
//            } else {
//                response.errorBody()
//                response.code()
//            }
//        }
//    }
//}


//------------самый первый код
//
//@HiltViewModel
//class DogImageViewModel @Inject constructor(
//    private val repository: DogRepository
//) : ViewModel() {
//
//    val image = MutableLiveData<DogImage>()
//
//    fun loadDogImage() {
//        viewModelScope.launch(Dispatchers.IO) {
//            val response: Response<DogImageResponse> = repository.getRandomDogImage()
//            if (response.isSuccessful) {
//                response.body()?.let { dogImageResponse ->
//                    image.postValue(dogImageResponse.message())
//                }
//            }
//        }
//    }
//}


//***PERPLEX***V2
//
//package by.vjacheslavkovalenko.asteroidstms.ui.pictureofday
//
//import androidx.lifecycle.ViewModel
// import androidx.lifecycle.viewModelScope
// import by.vjacheslavkovalenko.domain.LoadPictureOfDayUseCase
// import kotlinx.coroutines.flow.MutableStateFlow
// import kotlinx.coroutines.flow.StateFlow
// import kotlinx.coroutines.launch
// import javax.inject.Inject
//
//@HiltViewModel
//class PictureOfTheDayViewModel @Inject constructor(
//      private val loadPictureOfTheDayUseCase: LoadPictureOfThe DayUseCase
// ) : ViewModel() {
//
//      private val _state = MutableStateFlow<PictureFragmentState>(PictureFragmentState.Init)
//      val state: StateFlow<PictureFragmentState> get() = _state
//
//      // Функция для загрузки картины дня
//      fun loadPicture() {
//          viewModelScope.launch {
//              try {
//                  val result = loadPictureofThe DayUseCase.loadPictureofThe Day("title") // Укажите нужный заголовок или используйте API для получения заголовка.
//                  _state.emit(PictureFragmentState.PictureLoaded(result))
//              } catch (e: Exception) {
//                  _state.emit(PictureFragmentState.Error(e.message ?: "Unknown error"))
//              }
//          }
//      }
//}



