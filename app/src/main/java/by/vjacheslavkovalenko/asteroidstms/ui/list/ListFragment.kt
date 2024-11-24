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
import by.vjacheslavkovalenko.asteroidstms.database.entity.AsteroidsEntity
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
        return FragmentListBinding.inflate(layoutInflater, container, false).also {
            binding = it
        }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        lifecycleScope.launch {
            viewModel.state.collectLatest { state ->
                when (state) {
                    ListFragmentState.Init -> {}
                    is ListFragmentState.ListLoaded -> {
                        state.flowPagingData.collectLatest {
                            setList(it)
                        }
                    }
                }
            }
        }
    }

    private suspend fun setList(list: PagingData<Asteroids>) {
        binding?.recyclerView?.run {
            if (adapter == null) {
                layoutManager = LinearLayoutManager(requireContext())
                adapter = AsteroidsAdapter {

                }
            }
            (adapter as? AsteroidsAdapter)?.submitData(list)
        }

    }
}

