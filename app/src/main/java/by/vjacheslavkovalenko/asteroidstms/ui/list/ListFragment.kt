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

//----------


//
//    private fun setupRecyclerView() {
//        binding?.recyclerView?.layoutManager = LinearLayoutManager(requireContext())
//        binding?.recyclerView?.adapter = AsteroidsAdapter { asteroid ->
//            // Обработка клика на астероид (например, переход к DetailsFragment)
//            // Используйте NavController для навигации с передачей ID астероида.
//        }
//    }
//
//    private suspend fun setList(pagingData: PagingData<Asteroids>) {
//        (binding?.recyclerView?.adapter as? AsteroidsAdapter)?.submitData(pagingData)
//    }
//
//    override fun onDestroyView() {
//        super.onDestroyView()
//        binding = null // Освобождение привязки при уничтожении представления
//    }
//}


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
//                        private suspend fun setList(list: PagingData<Asteroids>) {
//                            binding?.recyclerView?.run {
//                                if (adapter == null) {
//                                    layoutManager = LinearLayoutManager(requireContext())
//                                    adapter = AsteroidsAdapter {
//
//                                    }
//                                }
//                                (adapter as? AsteroidsAdapter)?.submitData(list)
//                            }
//
//                        }
//                    }

//ии написал:
//package by.vjacheslavkovalenko.asteroidstms.ui.list
//
//import android.os.Bundle
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import androidx.fragment.app.Fragment
//import androidx.fragment.app.viewModels
//import androidx.lifecycle.lifecycleScope
//import androidx.paging.PagingData
//import androidx.recyclerview.widget.LinearLayoutManager
//import by.vjacheslavkovalenko.asteroidstms.database.entity.AsteroidsEntity
//import by.vjacheslavkovalenko.asteroidstms.databinding.FragmentListBinding
//import by.vjacheslavkovalenko.asteroidstms.model.Asteroids
//import by.vjacheslavkovalenko.asteroidstms.ui.list.adapter.AsteroidsAdapter
//import by.vjacheslavkovalenko.asteroidstms.ui.list.domain.ListFragmentState
//import dagger.hilt.android.AndroidEntryPoint
//import kotlinx.coroutines.flow.collectLatest
//import kotlinx.coroutines.launch
//
//@AndroidEntryPoint
//class ListFragment : Fragment() {
//
//    private var _binding: FragmentListBinding? = null // Приватное свойство для привязки
//    private val binding get() = _binding!! // Публичное свойство с безопасной привязкой
//
//    private val viewModel: ListViewModel by viewModels()
//
//    override fun onCreateView(
//        inflater: LayoutInflater,
//        container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View {
//        _binding = FragmentListBinding.inflate(inflater, container, false)
//        return binding.root
//    }
//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//        setupRecyclerView() // Инициализация RecyclerView
//
//        lifecycleScope.launch {
//            viewModel.state.collectLatest { state ->
//                when (state) {
//                    ListFragmentState.Init -> {
//                        // Можно добавить логику для состояния инициализации, если необходимо
//                    }
//                    is ListFragmentState.ListLoaded -> {
//                        state.flowPagingData.collectLatest { pagingData ->
//                            setList(pagingData)
//                        }
//                    }
//                }
//            }
//        }
//    }
//
//    private fun setupRecyclerView() {
//        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
//        binding.recyclerView.adapter = AsteroidsAdapter { asteroid ->
//            // Обработка клика на астероид, если необходимо
//        }
//    }
//
//    private suspend fun setList(list: PagingData<Asteroids>) {
//        (binding.recyclerView.adapter as? AsteroidsAdapter)?.submitData(list)
//    }
//
//    override fun onDestroyView() {
//        super.onDestroyView()
//        _binding = null // Освобождение привязки при уничтожении представления
//    }
//}


//***PERPLEX***
//
//package by.vjacheslavkovalenko.asteroidstms.ui.list
//
//import android.os.Bundle
// import android.view.LayoutInflater
// import android.view.View
// import android.view.ViewGroup
// import androidx.fragment.app.Fragment
// import androidx.fragment.app.viewModels
// import androidx.lifecycle.lifecycleScope
// import androidx.paging.PagingData
// import androidx.recyclerview.widget.LinearLayoutManager
// import by.vjacheslavkovalenko.asteroidstms.databinding.FragmentListBinding
// import by.vjacheslavkovalenko.asteroidstms.model.Asteroids
// import by.vjacheslavkovalenko.asteroids.ui.list.adapter.AsteroidsAdapter
// import by.vjacheslavkovalenko.asteroids.ui.list.domain.ListFragmentState
// import dagger.hilt.android.AndroidEntryPoint
// import kotlinx.coroutines.flow.collectLatest
// import kotlinx.coroutines.launch
//
//@AndroidEntryPoint
//class ListFragment : Fragment() {
//
//      private var _binding: FragmentListBinding? = null
//      private val binding get() = _binding!!
//
//      private val viewModel: ListViewModel by viewModels()
//
//      override fun onCreateView(
//          inflater: LayoutInflater,
//          container: ViewGroup?,
//          savedInstanceState: Bundle?
//      ): View {
//          _binding = FragmentListBinding.inflate(inflater, container, false)
//          return binding.root
//      }
//
//      override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//          super.onViewCreated(view, savedInstanceState)
//
//          lifecycleScope.launch {
//              viewModel.state.collectLatest { state ->
//                  when (state) {
//                      ListFragmentState.Init -> {}
//                      is ListFragmentState.ListLoaded -> {
//                          setList(state.flowPagingData.collectLatest())
//                      }
//                  }
//              }
//          }
//
//          setupRecyclerView() // Инициализация RecyclerView
//      }
//
//      private fun setupRecyclerView() {
//          binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
//          binding.recyclerView.adapter = AsteroidsAdapter {
//              // Обработка клика на астероид (например, переход к DetailsFragment)
//              // Используйте NavController для навигации с передачей ID астероида.
//          }
//      }
//
//      private suspend fun setList(list: PagingData<Asteroids>) {
//          (binding.recyclerView.adapter as? AsteroidsAdapter)?.submitData(list)
//      }
//
//      override fun onDestroyView() {
//          super.onDestroyView()
//          _binding = null // Освобождение привязки при уничтожении представления
//      }
//}


//***PERPLEX***V3---попросил заменить private val binding get() = _binding!!
//
//Вы можете применить аналогичные изменения и к другим фрагментам, например, к ListFragment и PictureOfTheDayFragment.
//
//package by.vjacheslavkovalenko.asteroidstms.ui.list
//
//import android.os.Bundle
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import androidx.fragment.app.Fragment
//import androidx.fragment.app.viewModels
//import androidx.lifecycle.lifecycleScope
//import androidx.paging.PagingData
//import androidx.recyclerview.widget.LinearLayoutManager
//import by.vjacheslavkovalenko.asteroidstms.databinding.FragmentListBinding
//import by.vjacheslavkovalenko.asteroidstms.model.Asteroids
//import by.vjacheslavkovalenko.asteroidstms.ui.list.adapter.AsteroidsAdapter
//import by.vjacheslavkovalenko.asteroidstms.ui.list.domain.ListFragmentState
//import dagger.hilt.android.AndroidEntryPoint
//import kotlinx.coroutines.flow.collectLatest
//import kotlinx.coroutines.launch
//
//@AndroidEntryPoint
//class ListFragment : Fragment() {
//
//    private var binding: FragmentListBinding? = null // Привязка будет храниться здесь
//
//    private val viewModel: ListViewModel by viewModels()
//
//    override fun onCreateView(
//        inflater: LayoutInflater,
//        container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View {
//        binding = FragmentListBinding.inflate(inflater, container, false)
//        return binding?.root ?: throw IllegalStateException("Binding is null")
//    }
//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//
//        lifecycleScope.launch {
//            viewModel.state.collectLatest { state ->
//                when (state) {
//                    ListFragmentState.Init -> {}
//                    is ListFragmentState.ListLoaded -> {
//                        setList(state.flowPagingData)
//                    }
//                }
//            }
//        }
//
//        setupRecyclerView() // Инициализация RecyclerView
//    }
//
//    private fun setupRecyclerView() {
//        binding?.recyclerView?.layoutManager = LinearLayoutManager(requireContext())
//        binding?.recyclerView?.adapter = AsteroidsAdapter { asteroid ->
//            // Обработка клика на астероид (например, переход к DetailsFragment)
//            // Используйте NavController для навигации с передачей ID астероида.
//        }
//    }
//
//    private suspend fun setList(list: PagingData<Asteroids>) {
//        (binding?.recyclerView?.adapter as? AsteroidsAdapter)?.submitData(list)
//    }
//
//    override fun onDestroyView() {
//        super.onDestroyView()
//        binding = null // Освобождение привязки при уничтожении представления
//    }
//}

//Теперь в коде нет символа подчеркивания (_), и использование привязки более безопасно благодаря проверкам на null. Вы можете применить эти изменения ко всем вашим фрагментам и классам, где используется привязка.
//

