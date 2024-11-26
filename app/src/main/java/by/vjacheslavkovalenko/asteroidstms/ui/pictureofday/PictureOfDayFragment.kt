package by.vjacheslavkovalenko.asteroidstms.ui.pictureofday

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import by.vjacheslavkovalenko.asteroidstms.databinding.FragmentPictureOfDayBinding
import by.vjacheslavkovalenko.asteroidstms.model.PictureOfDay
import by.vjacheslavkovalenko.asteroidstms.ui.pictureofday.domain.PictureFragmentState
import com.bumptech.glide.Glide
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class PictureOfDayFragment : Fragment() {

    private var binding: FragmentPictureOfDayBinding? = null
    private val viewModel: PictureOfDayViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
//        return FragmentPictureOfDayBinding.inflate(layoutInflater, container, false).also {
//            binding = it
//        }.root
        binding = FragmentPictureOfDayBinding.inflate(inflater, container, false)
        return binding?.root ?: throw IllegalStateException("Binding is null")
//        binding = FragmentPictureOfDayBinding.inflate(inflater)
//        return binding?.root
    }

    //    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//        lifecycleScope.launch {
//            viewModel.state.collectLatest { state ->
//                when (state) {
//                    ListFragmentState.Init -> {}
//                    is ListFragmentState.ListLoaded -> {
//                        state.flowPagingData.collectLatest {
//                            setList(it)
//                        }
//                    }
//                }
//            }
//        }
//    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        lifecycleScope.launch {
            viewModel.state.collectLatest { state ->
                when (state) {
                    is PictureFragmentState.Init -> {}
                    is PictureFragmentState.PictureLoaded -> {
                        displayPicture(state.picture)
                    }

                    is PictureFragmentState.Error -> {
                        showError(state.message)
                    }
                }
            }
        }

        // Загружаем картину дня при создании фрагмента
        viewModel.loadPicture()
    }

    private fun displayPicture(picture: PictureOfDay) {
        binding?.imageViewPictureOfDayDetail?.let { imageView ->
            Glide.with(this).load(picture.url)
                .into(imageView) //  библиотекa Glide для загрузки изображений
        }
        binding?.textViewDescription?.text = picture.explanation
    }

    private fun showError(message: String) {
        binding?.errorTextView?.text = message // Предполагается наличие TextView для ошибок
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null // Освобождение привязки при уничтожении представления
    }
}
