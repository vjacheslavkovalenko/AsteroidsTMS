package by.vjacheslavkovalenko.asteroidstms.ui.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import by.vjacheslavkovalenko.asteroidstms.domen.LoadAsteroidsListUseCase
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