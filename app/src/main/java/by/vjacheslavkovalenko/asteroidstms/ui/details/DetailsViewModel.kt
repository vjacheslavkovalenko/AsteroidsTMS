package by.vjacheslavkovalenko.asteroidstms.ui.details

import androidx.lifecycle.ViewModel
import by.vjacheslavkovalenko.asteroidstms.domain.LoadAsteroidDetailsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import androidx.lifecycle.viewModelScope
import by.vjacheslavkovalenko.asteroidstms.ui.details.domain.DetailsFragmentState
import javax.inject.Inject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

@HiltViewModel
class DetailsViewModel @Inject constructor(
    private val loadAsteroidDetailsUseCase: LoadAsteroidDetailsUseCase
) : ViewModel() {

    private val stateFlow = MutableLiveData<DetailsFragmentState>(DetailsFragmentState.Init)
    val state: LiveData<DetailsFragmentState> get() = stateFlow
//    private val stateLiveData = MutableLiveData<DetailsFragmentState>(DetailsFragmentState.Init)
//    val state: LiveData<DetailsFragmentState> get() = stateLiveData

    // Функция для загрузки деталей астероида по его ID
    fun loadAsteroidDetails(asteroidId: String) {
//        stateLiveData.value =
        stateFlow.value =
            DetailsFragmentState.DetailsLoading // Устанавливаем состояние загрузки
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val details = loadAsteroidDetailsUseCase.loadAsteroidDetails(asteroidId)
//                stateLiveData.postValue(DetailsFragmentState.DetailsLoaded(details)) // Используем postValue для обновления из фона
                stateFlow.postValue(DetailsFragmentState.DetailsLoaded(details)) // Успешно загруженные данные
            } catch (e: Exception) {
//                stateLiveData.postValue(
                stateFlow.postValue(
                    DetailsFragmentState.Error(
                        e.message ?: "Unknown error"
                    )
                )// Ошибка при загрузке данных
            }
        }
    }
}