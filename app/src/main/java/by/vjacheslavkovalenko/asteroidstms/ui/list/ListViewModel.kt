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

@HiltViewModel
class ListViewModel @Inject constructor(
    private val loadAsteroidsListUseCase: LoadAsteroidsListUseCase
) : ViewModel() {
    // Используем StateFlow для состояния, чтобы UI мог наблюдать за изменениями
    private val listFragmentStateFlow = MutableStateFlow<ListFragmentState>(ListFragmentState.Init)
    val state: StateFlow<ListFragmentState> get() = listFragmentStateFlow // Публичный доступ только для чтения

//    val state = MutableStateFlow<ListFragmentState>(ListFragmentState.Init)

    fun loadData() {
        viewModelScope.launch(Dispatchers.IO) {
//            state.emit(
//                ListFragmentState.ListLoaded(
//                    loadAsteroidsListUseCase.loadData().cachedIn(viewModelScope)))
            listFragmentStateFlow.value =
                ListFragmentState.Loading // Устанавливаем состояние загрузки

            try {
                // Получаем данные и кэшируем их в viewModelScope
                val pagingData = loadAsteroidsListUseCase.loadData().cachedIn(viewModelScope)
                listFragmentStateFlow.value =
                    ListFragmentState.ListLoaded(pagingData) // Устанавливаем состояние с загруженными данными
            } catch (e: Exception) {
                listFragmentStateFlow.value = ListFragmentState.Error(
                    e.message ?: "Unknown error"
                ) // Устанавливаем состояние ошибки
            }
        }
    }
}


//ии написал:
//package by.vjacheslavkovalenko.asteroidstms.ui.list
//
//import androidx.lifecycle.ViewModel
//import androidx.lifecycle.viewModelScope
//import by.vjacheslavkovalenko.asteroidstms.domen.LoadAsteroidsListUseCase
//import by.vjacheslavkovalenko.asteroidstms.ui.list.domain.ListFragmentState
//import dagger.hilt.android.lifecycle.HiltViewModel
//import kotlinx.coroutines.Dispatchers
//import kotlinx.coroutines.flow.MutableStateFlow
//import kotlinx.coroutines.flow.StateFlow
//import kotlinx.coroutines.launch
//import androidx.paging.cachedIn
//import javax.inject.Inject
//
//@HiltViewModel
//class ListViewModel @Inject constructor(
//    private val loadAsteroidsListUseCase: LoadAsteroidsListUseCase
//) : ViewModel() {
//
//    // Состояние UI, доступное для наблюдения
//    private val _state = MutableStateFlow<ListFragmentState>(ListFragmentState.Init)
//    val state: StateFlow<ListFragmentState> get() = _state // Экспонируем только StateFlow
//
//    // Функция для загрузки данных астероидов
//    fun loadData() {
//        viewModelScope.launch(Dispatchers.IO) {
//            // Здесь можно добавить обработку ошибок, если это необходимо
//            _state.emit(
//                ListFragmentState.ListLoaded(
//                    loadAsteroidsListUseCase.loadData().cachedIn(viewModelScope)
//                )
//            )
//        }
//    }
//}


//***PERPLEX***
//
//
