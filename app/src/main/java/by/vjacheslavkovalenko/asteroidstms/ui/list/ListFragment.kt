package by.vjacheslavkovalenko.asteroidstms.ui.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.paging.PagingData
import androidx.recyclerview.widget.LinearLayoutManager
import by.vjacheslavkovalenko.asteroidstms.databinding.FragmentListBinding
import by.vjacheslavkovalenko.asteroidstms.model.Asteroids
import by.vjacheslavkovalenko.asteroidstms.ui.list.adapter.AsteroidsAdapter
import by.vjacheslavkovalenko.asteroidstms.ui.list.domain.ListFragmentState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class ListFragment : Fragment() {

    private var binding: FragmentListBinding? = null

    private val viewModel: ListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
//        return FragmentListBinding.inflate(layoutInflater, container, false).also {
//            binding = it
//        }.root
        binding = FragmentListBinding.inflate(inflater, container, false)
        return binding?.root ?: throw IllegalStateException("Binding is null")
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Инициализация RecyclerView
        setupRecyclerView()
        lifecycleScope.launch {
            viewModel.state.collectLatest { state ->
                when (state) {
                    ListFragmentState.Init -> {
                        // Можно добавить логику для начального состояния, если нужно
                    }

                    is ListFragmentState.ListLoaded -> {
// Сбор данных из потока и установка в адаптер
                        state.flowPagingData.collectLatest { pagingData ->
                            setList(pagingData)
                        }
                    }
                }
            }
        }
    }

    private fun setupRecyclerView() {
        binding?.recyclerView?.layoutManager = LinearLayoutManager(requireContext())
        binding?.recyclerView?.adapter = AsteroidsAdapter { asteroid ->
            // Обработка клика на астероид (например, переход к DetailsFragment)
            // Используйте NavController для навигации с передачей ID астероида.
        }
    }

    private suspend fun setList(pagingData: PagingData<Asteroids>) {
        (binding?.recyclerView?.adapter as? AsteroidsAdapter)?.submitData(pagingData)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null // Освобождение привязки при уничтожении представления
    }
}