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

@HiltViewModel
class ListViewModel @Inject constructor(
    private val loadAsteroidsListUseCase: LoadAsteroidsListUseCase
) : ViewModel() {

    val state = MutableStateFlow<ListFragmentState>(ListFragmentState.Init)

    fun LoadData() {
        viewModelScope.launch(Dispatchers.IO) {
            state.emit(
                ListFragmentState.ListLoaded(
                    loadAsteroidsListUseCase.loadData().cachedIn(viewModelScope)))
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
//package by.vjacheslavkovalenko.asteroids.ui.list
//
//import androidx.lifecycle.ViewModel
// import androidx.lifecycle.viewModelScope
// import by.vjaceslavkovalenko.domain.LoadAstroidsListUseCase