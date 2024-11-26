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

    fun loadData() {
        viewModelScope.launch(Dispatchers.IO) {
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