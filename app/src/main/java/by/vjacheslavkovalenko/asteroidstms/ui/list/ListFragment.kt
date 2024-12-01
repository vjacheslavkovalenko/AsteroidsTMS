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
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import by.vjacheslavkovalenko.asteroidstms.R
import by.vjacheslavkovalenko.asteroidstms.utils.Constants.APIKEY

//555
@AndroidEntryPoint
class ListFragment : Fragment() {

    private var binding: FragmentListBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentListBinding.inflate(inflater, container, false)
        return binding!!.root // Возвращаем корневое представление
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val viewModel: ListViewModel by viewModels()

        binding!!.recyclerView.layoutManager = LinearLayoutManager(context)

        val adapter = AsteroidsAdapter { asteroidId ->
            // Обработка нажатия на элемент списка для перехода к деталям астероида
            val action = ListFragmentDirections.actionListFragmentToDetailsFragment()
            findNavController().navigate(action)
        }
        binding!!.recyclerView.adapter = adapter

        val apiKey = APIKEY
        viewModel.fetchAsteroids(apiKey)

        lifecycleScope.launch {
            viewModel.stateFlow.collectLatest { state ->
                when (state) {
                    is ListFragmentState.Loading -> {
                        // Показать индикатор загрузки
                    }
                    is ListFragmentState.Success -> {
                        // Обновите адаптер с полученными данными об астероидах
                        adapter.submitData(state.data) // Используйте submitData для обновления адаптера
                    }
                    is ListFragmentState.Error -> {
                        // Показать сообщение об ошибке
                    }
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null // Освобождаем привязку при уничтожении представления
    }
}
//
//Объяснение кода
//Пакет: Класс находится в пакете by.vjacheslavkovalenko.asteroidstms.ui.list.
//Импорт класса привязки:
//Импортируется класс FragmentListBinding, который автоматически генерируется на основе XML-файла макета fragment_list.xml.
//Переменная binding:
//Создается переменная binding, которая будет хранить экземпляр класса привязки.
//Метод onCreateView:
//В этом методе инициализируется привязка с помощью метода inflate, и возвращается корневое представление.
//Метод onViewCreated:
//Инициализируется ViewModel и RecyclerView.
//Устанавливается адаптер для RecyclerView и определяется обработчик кликов на элементы списка.
//Вызывается метод fetchAsteroids во ViewModel для загрузки данных об астероидах.
//Наблюдается за изменениями в списке астероидов и обновляется адаптер при получении новых данных.
//Метод onDestroyView:
//Освобождает ссылку на объект привязки, чтобы избежать утечек памяти.
//Заключение
//Теперь класс ListFragment полностью соответствует вашим требованиям, использует View Binding и не содержит символов подчеркивания в именах переменных.
//

//@AndroidEntryPoint
//class ListFragment : Fragment() {
//
//    private var binding: FragmentListBinding? = null
//
//    private val viewModel: ListViewModel by viewModels()
//
//    override fun onCreateView(
//        inflater: LayoutInflater,
//        container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        binding = FragmentListBinding.inflate(inflater, container, false)
//        return binding?.root ?: throw IllegalStateException("Binding is null")
//    }
//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//        setupRecyclerView()
//
//        lifecycleScope.launch {
//            viewModel.state.collectLatest { state ->
//                when (state) {
//                    ListFragmentState.Init -> {}
//                    is ListFragmentState.ListLoaded -> {
//                        state.flowPagingData.collectLatest { pagingData ->
//                            setList(pagingData)
//                        }
//                    }
//
//                    is ListFragmentState.Error -> {
//                        showError(state.message) // Обработка состояния ошибки.
//                    }
//
//                    ListFragmentState.Loading -> {}
//                }
//            }
//        }
//        viewModel.loadData() // Загрузка данных при создании фрагмента.
//    }
//
//    private fun setupRecyclerView() {
//        binding?.recyclerView?.layoutManager = LinearLayoutManager(requireContext())
//
////        val adapter = AsteroidsAdapter { Asteroids ->
////            val action =
////                ListFragmentDirections.actionListFragmentToDetailsFragment(asteroid.asteroidId)
////            findNavController().navigate(action)
////        }
//
//        val adapter = AsteroidsAdapter { _ ->
//            val action =
//                ListFragmentDirections.actionListFragmentToDetailsFragment()
//            findNavController().navigate(action)
//        }
//
//        binding?.recyclerView?.adapter = adapter
//    }
//
//    private suspend fun setList(pagingData: PagingData<Asteroids>) {
//        (binding?.recyclerView?.adapter as? AsteroidsAdapter)?.submitData(pagingData)
//    }
//
//    private fun showError(message: String) {
//        // Здесь можно добавить логику для отображения ошибки в UI (например, через Toast или TextView).
//    }
//
//    override fun onDestroyView() {
//        super.onDestroyView()
//        binding = null
//    }
//}
