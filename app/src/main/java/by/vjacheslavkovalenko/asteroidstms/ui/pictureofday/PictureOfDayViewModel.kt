package by.vjacheslavkovalenko.asteroidstms.ui.pictureofday

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import by.vjacheslavkovalenko.asteroidstms.model.PictureOfDay
import by.vjacheslavkovalenko.asteroidstms.network.entity.PictureOfDayResponse
import by.vjacheslavkovalenko.asteroidstms.repository.AllAsteroidsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class PictureOfDayViewModel @Inject constructor(
    private val repository: AllAsteroidsRepository
) : ViewModel() {

    val picture = MutableLiveData<PictureOfDay>()

        fun loadPictureOfDay() {
//        viewModelScope.launch(Dispatchers.IO + coroutineExceptionHandler) {
        viewModelScope.launch(Dispatchers.IO) {
            val response: Response<PictureOfDayResponse> = repository.getPictureOfDay()
            if (response.isSuccessful) {
                response.body()?.let { pictureOfDayResponse ->
//                    picture.postValue(pictureOfDayResponse.to())
                    picture.postValue(PictureOfDay(pictureOfDayResponse.url))
                }
            } else {
                response.errorBody()
                response.code()
            }
        }
    }
}




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
//