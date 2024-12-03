package by.vjacheslavkovalenko.asteroidstms.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import by.vjacheslavkovalenko.asteroidstms.databinding.FragmentMainBinding
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import by.vjacheslavkovalenko.asteroidstms.R

import by.vjacheslavkovalenko.asteroidstms.domain.Asteroid





@AndroidEntryPoint
class MainFragment : Fragment() {

    private var binding: FragmentMainBinding? = null
    private lateinit var viewModel: MainViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding!!.root // Возвращаем корневое представление привязки
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Инициализация ViewModel с использованием Hilt
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        // Настройка RecyclerView и адаптера
        binding?.asteroidRecycler?.layoutManager = LinearLayoutManager(requireContext())
        val adapter = MainAdapter { asteroid ->
            val bundle = Bundle().apply {
                putParcelable("selectedAsteroid", asteroid) // Передача астероида через Bundle
            }
            findNavController().navigate(R.id.detailFragment, bundle) // Навигация с передачей аргументов
        }

        binding?.asteroidRecycler?.adapter = adapter

        // Наблюдение за данными из ViewModel и обновление адаптера
        viewModel.asteroids.observe(viewLifecycleOwner, Observer { asteroids ->
            adapter.submitList(asteroids) // Обновляем адаптер с новыми данными

            // Управление видимостью индикатора загрузки
            binding?.statusLoadingWheel?.visibility = if (asteroids.isEmpty()) View.VISIBLE else View.GONE
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null // Освобождение ссылки при уничтожении фрагмента
    }
}


//
//@AndroidEntryPoint
//class MainFragment : Fragment() {
//
//    private var binding: FragmentMainBinding? = null
//    private lateinit var viewModel: MainViewModel
//
//    override fun onCreateView(
//        inflater: LayoutInflater,
//        container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View {
//        binding = FragmentMainBinding.inflate(inflater, container, false)
//        return binding!!.root
//    }
//
//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//
//        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
//
//        // Настройка RecyclerView и адаптера
//        binding?.asteroidRecycler?.layoutManager = LinearLayoutManager(requireContext())
//        val adapter = MainAdapter { asteroid ->
//            // Использую Directions для навигации
////            findNavController().navigate(MainFragmentDirections.actionShowDetail(asteroid))
//            findNavController().navigate(R.id.action_showDetail)
//        }
//        binding?.asteroidRecycler?.adapter = adapter
//
//
//        // Наблюдение за данными из ViewModel и обновление адаптера
//        viewModel.asteroids.observe(viewLifecycleOwner, Observer { asteroids ->
//            adapter.submitList(asteroids) // Обновляю адаптер с новыми данными
//
//            // Управление видимостью индикатора загрузки
//            binding?.statusLoadingWheel?.visibility =
//                if (asteroids.isEmpty()) View.VISIBLE else View.GONE
//        })
//    }
//
//    override fun onDestroyView() {
//        super.onDestroyView()
//        binding = null
//    }
//}
