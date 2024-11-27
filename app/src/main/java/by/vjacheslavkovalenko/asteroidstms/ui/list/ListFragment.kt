package by.vjacheslavkovalenko.asteroidstms.ui.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
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
        binding = FragmentListBinding.inflate(inflater, container, false)
        return binding?.root ?: throw IllegalStateException("Binding is null")
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()

        lifecycleScope.launch {
            viewModel.state.collectLatest { state ->
                when (state) {
                    ListFragmentState.Init -> {}
                    is ListFragmentState.ListLoaded -> {
                        state.flowPagingData.collectLatest { pagingData ->
                            setList(pagingData)
                        }
                    }

                    is ListFragmentState.Error -> {
                        showError(state.message) // Обработка состояния ошибки.
                    }

                    ListFragmentState.Loading -> {}
                }
            }
        }
        viewModel.loadData() // Загрузка данных при создании фрагмента.
    }

    private fun setupRecyclerView() {
        binding?.recyclerView?.layoutManager = LinearLayoutManager(requireContext())

//        val adapter = AsteroidsAdapter { asteroid ->
//            val action =
//                ListFragmentDirections.actionListFragmentToDetailsFragment(asteroid.asteroidId)
//            findNavController().navigate(action)
//        }

        val adapter = AsteroidsAdapter { _ ->
            val action =
                ListFragmentDirections.actionListFragmentToDetailsFragment()
            findNavController().navigate(action)
        }

        binding?.recyclerView?.adapter = adapter
    }

    private suspend fun setList(pagingData: PagingData<Asteroids>) {
        (binding?.recyclerView?.adapter as? AsteroidsAdapter)?.submitData(pagingData)
    }

    private fun showError(message: String) {
        // Здесь можно добавить логику для отображения ошибки в UI (например, через Toast или TextView).
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}
