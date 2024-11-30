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
import by.vjacheslavkovalenko.asteroidstms.model.AsteroidDetails

//555
@HiltViewModel
class DetailsViewModel @Inject constructor(
    private val loadAsteroidDetailsUseCase: LoadAsteroidDetailsUseCase
) : ViewModel() {

    private val stateLiveData = MutableLiveData<DetailsFragmentState>()
    val state: LiveData<DetailsFragmentState> = stateLiveData

    fun fetchAsteroidDetails(asteroidId: String) {
        stateLiveData.value = DetailsFragmentState.Loading // Устанавливаем состояние загрузки

        viewModelScope.launch {
            try {
                val asteroidDetails = loadAsteroidDetailsUseCase(asteroidId)
                stateLiveData.value = DetailsFragmentState.Success(asteroidDetails) // Успешно получены данные
            } catch (e: Exception) {
                stateLiveData.value = DetailsFragmentState.Error(e.message ?: "Unknown error") // Ошибка при получении данных
            }
        }
    }
}

//Этот класс будет отвечать за загрузку данных о конкретном астероиде и управление состоянием для фрагмента деталей.

//Объяснение кода
//Конструктор с внедрением зависимостей: Используется Dagger Hilt для внедрения зависимости LoadAsteroidDetailsUseCase, который управляет логикой получения деталей астероида.
//LiveData:
//asteroidDetailsLiveData: Хранит данные о деталях астероида, которые будут наблюдаться во фрагменте.
//loadingStateLiveData: Указывает, идет ли процесс загрузки данных.
//errorStateLiveData: Хранит сообщение об ошибке, если она произошла во время загрузки.
//Метод loadAsteroidDetails:
//Устанавливает состояние загрузки в true.
//Запускает корутину для асинхронной загрузки данных.
//Внутри корутины вызывается метод execute из LoadAsteroidDetailsUseCase, который возвращает детали астероида по его идентификатору.
//Если данные успешно загружены, они сохраняются в asteroidDetailsLiveData, а errorStateLiveData сбрасывается.
//В случае ошибки устанавливается сообщение об ошибке.
//В конце загрузка завершается, устанавливая loadingStateLiveData в false.



//@HiltViewModel
//class DetailsViewModel @Inject constructor(
//    private val loadAsteroidDetailsUseCase: LoadAsteroidDetailsUseCase
//) : ViewModel() {
//
//    private val stateFlow = MutableLiveData<DetailsFragmentState>(DetailsFragmentState.Init)
//    val state: LiveData<DetailsFragmentState> get() = stateFlow
////    private val stateLiveData = MutableLiveData<DetailsFragmentState>(DetailsFragmentState.Init)
////    val state: LiveData<DetailsFragmentState> get() = stateLiveData
//
//    // Функция для загрузки деталей астероида по его ID
//    fun loadAsteroidDetails(asteroidId: String) {
////        stateLiveData.value =
//        stateFlow.value =
//            DetailsFragmentState.DetailsLoading // Устанавливаем состояние загрузки
//        viewModelScope.launch(Dispatchers.IO) {
//            try {
//                val details = loadAsteroidDetailsUseCase.loadAsteroidDetails(asteroidId)
////                stateLiveData.postValue(DetailsFragmentState.DetailsLoaded(details)) // Используем postValue для обновления из фона
//                stateFlow.postValue(DetailsFragmentState.DetailsLoaded(details)) // Успешно загруженные данные
//            } catch (e: Exception) {
////                stateLiveData.postValue(
//                stateFlow.postValue(
//                    DetailsFragmentState.Error(
//                        e.message ?: "Unknown error"
//                    )
//                )// Ошибка при загрузке данных
//            }
//        }
//    }
//}