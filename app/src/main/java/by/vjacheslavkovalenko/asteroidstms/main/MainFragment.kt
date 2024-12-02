package by.vjacheslavkovalenko.asteroidstms.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import by.vjacheslavkovalenko.asteroidstms.databinding.FragmentMainBinding

@AndroidEntryPoint // Аннотация для поддержки Hilt.
class MainFragment : Fragment() {

    private var binding: FragmentMainBinding? = null // Привязка данных для фрагмента.
    private val viewModel: MainViewModel by viewModels() // Использование ViewModel с Hilt.
    private lateinit var adapter: MainAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding!!.root
    }

    override fun onViewCreated(view: android.view.View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()

        viewModel.asteroids.observe(viewLifecycleOwner) { asteroids ->
            adapter.submitList(asteroids)
            binding?.statusLoadingWheel?.visibility = if (asteroids.isEmpty()) View.VISIBLE else View.GONE
        }

        adapter.setOnItemClickListener { asteroid ->
            findNavController().navigate(MainFragmentDirections.actionShowDetail(asteroid))
        }

        viewModel.fetchAsteroids() // Запрос данных об астероидах.
    }

    private fun setupRecyclerView() {
        adapter = MainAdapter()
        binding?.asteroidRecycler?.layoutManager = LinearLayoutManager(requireContext())
        binding?.asteroidRecycler?.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}