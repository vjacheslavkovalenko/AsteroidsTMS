package by.vjacheslavkovalenko.asteroidstms.ui.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import by.vjacheslavkovalenko.asteroidstms.domain.LoadAsteroidsListUseCase
import by.vjacheslavkovalenko.asteroidstms.ui.list.domain.ListFragmentState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import androidx.paging.cachedIn
import javax.inject.Inject
import kotlinx.coroutines.flow.StateFlow
import by.vjacheslavkovalenko.asteroidstms.utils.DateUtils
import by.vjacheslavkovalenko.asteroidstms.model.Asteroids
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import by.vjacheslavkovalenko.asteroidstms.network.entity.AsteroidResponse
import androidx.lifecycle.viewModelScope



//555
class ListViewModel @Inject constructor(
    private val loadAsteroidsListUseCase: LoadAsteroidsListUseCase
) : ViewModel() {

    private val stateLiveData = MutableLiveData<ListFragmentState>()
    val state: LiveData<ListFragmentState> = stateLiveData

    fun fetchAsteroids(apiKey: String) {
        stateLiveData.value = ListFragmentState.Loading // Устанавливаем состояние загрузки

        viewModelScope.launch {
            try {
                val startDate = DateUtils.getTodayDate()
                val endDate = DateUtils.getEndDate()
                val response = loadAsteroidsListUseCase(startDate, endDate, apiKey)
                stateLiveData.value = ListFragmentState.Success(response.nearEarthObjects) // Успешно получены данные
            } catch (e: Exception) {
                stateLiveData.value = ListFragmentState.Error(e.message ?: "Unknown error") // Ошибка при получении данных
            }
        }
    }
}

//
//Объяснение кода
//Пакет: Класс находится в пакете by.vjacheslavkovalenko.asteroidstms.ui.list, как вы указали.
//Импорт утилиты: Импортируется DateUtils, который содержит методы для получения текущей даты и даты через 6 дней.
//LiveData:
//asteroidsListLiveData — это MutableLiveData, которое хранит данные о списке астероидов.
//asteroidsList — это публичное свойство, которое позволяет наблюдать за изменениями в данных.
//Метод fetchAsteroids:
//Этот метод получает ключ API и использует утилиту для получения стартовой и конечной дат.
//Запускает корутину, чтобы вызвать Use Case для получения списка астероидов и обновляет значение asteroidsListLiveData.
//Заключение
//Теперь класс ListViewModel полностью соответствует вашим требованиям, автоматически устанавливает сегодняшнюю дату как стартовую и добавляет 6 дней к конечной дате запроса.


//
//@HiltViewModel
//class ListViewModel @Inject constructor(
//    private val loadAsteroidsListUseCase: LoadAsteroidsListUseCase
//) : ViewModel() {
//    // Используем StateFlow для состояния, чтобы UI мог наблюдать за изменениями
////    private val listFragmentStateFlow = MutableStateFlow<ListFragmentState>(ListFragmentState.Init)
////    val state: StateFlow<ListFragmentState> get() = listFragmentStateFlow // Публичный доступ только для чтения
//
//    //    fun loadData() {
////        viewModelScope.launch(Dispatchers.IO) {
////            listFragmentStateFlow.value =
////                ListFragmentState.Loading // Устанавливаем состояние загрузки
////
//    private val stateFlow = MutableStateFlow<ListFragmentState>(ListFragmentState.Init)
//    val state: StateFlow<ListFragmentState> get() = stateFlow // Публичный доступ только для чтения.
//
//
//
//    fun loadData() {
//        viewModelScope.launch(Dispatchers.IO) {
//            stateFlow.value = ListFragmentState.Loading // Устанавливаем состояние загрузки
//
//            try {
//                val startDateString = DateUtils.getCurrentDate() // Получаем сегодняшнюю дату.
//                val endDateString =
//                    DateUtils.getEndDate(startDateString) // Получаем конечную дату через 6 дней.
//
//                val apiKey = Constants.APIKEY
//
////                loadAsteroidsListUseCase.execute(apiKey, startDateString, endDateString)
////                    .collect { asteroids ->
////                        stateFlow.value =
////                            ListFragmentState.ListLoaded(asteroids) // Устанавливаем состояние с загруженными данными.
////                    }
//
//                loadAsteroidsListUseCase.execute(apiKey, startDateString, endDateString)
//                .collect { pagingData ->
//                    stateFlow.value = ListFragmentState.ListLoaded(pagingData) // Устанавливаем состояние с загруженными данными.
//                }
//
//            } catch (e: Exception) {
//                stateFlow.value = ListFragmentState.Error(
//                    e.message ?: "Unknown error"
//                ) // Устанавливаем состояние ошибки.
//            }
//        }
//    }
//}
////            try {
////                // Получаем данные и кэшируем их в viewModelScope
////                val pagingData = loadAsteroidsListUseCase.loadData().cachedIn(viewModelScope)
////                listFragmentStateFlow.value =
////                    ListFragmentState.ListLoaded(pagingData) // Устанавливаем состояние с загруженными данными
////            } catch (e: Exception) {
////                listFragmentStateFlow.value = ListFragmentState.Error(
////                    e.message ?: "Unknown error"
////                ) // Устанавливаем состояние ошибки
////            }
////        }
////    }
////}