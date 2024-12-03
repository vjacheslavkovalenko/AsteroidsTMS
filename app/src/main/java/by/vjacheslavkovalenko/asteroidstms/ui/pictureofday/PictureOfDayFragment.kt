package by.vjacheslavkovalenko.asteroidstms.ui.pictureofday

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import by.vjacheslavkovalenko.asteroidstms.databinding.FragmentPictureOfDayBinding
import by.vjacheslavkovalenko.asteroidstms.utils.loadUrl
import com.bumptech.glide.Glide
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@AndroidEntryPoint
class PictureOfDayFragment : Fragment() {

    private var binding: FragmentPictureOfDayBinding? = null

    private val viewModel: PictureOfDayViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPictureOfDayBinding.inflate(inflater)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.picture.observe(viewLifecycleOwner) {
//            Glide.with(requireContext()).load(it.url).into(binding?.imagePictureOfDay)
            binding?.imagePictureOfDay?.loadUrl(it.url)
//            binding?.errorText?.visibility = View.GONE
//            binding?.tryAgainButton?.visibility = View.GONE
//            binding?.image?.visibility = View.VISIBLE
        }
//        viewModel.showError = {
//            binding?.errorText?.visibility = View.VISIBLE
//            binding?.tryAgainButton?.visibility = View.VISIBLE
//            binding?.image?.visibility = View.GONE
//        }
//        binding?.tryAgainButton?.setOnClickListener {
//            viewModel.loadDogImage()
//        }
        viewModel.loadPictureOfDay()
    }
}
//
//
//@AndroidEntryPoint
//class DogImageFragment : Fragment() {
//
//    private var binding: FragmentDogImageBinding? = null
//
//    private val viewModel: DogImageViewModel by viewModels()
//
//    override fun onCreateView(
//        inflater: LayoutInflater,
//        container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        binding = FragmentDogImageBinding.inflate(inflater)
//        return binding?.root
//    }
//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//        viewModel.image.observe(viewLifecycleOwner) {
//            binding?.image?.loadUrl(it.message)
//            binding?.errorText?.visibility = View.GONE
//            binding?.tryAgainButton?.visibility = View.GONE
//            binding?.image?.visibility = View.VISIBLE
//        }
//        viewModel.showError = {
//            binding?.errorText?.visibility = View.VISIBLE
//            binding?.tryAgainButton?.visibility = View.VISIBLE
//            binding?.image?.visibility = View.GONE
//        }
//        binding?.tryAgainButton?.setOnClickListener {
//            viewModel.loadDogImage()
//        }
//        viewModel.loadDogImage()
//    }
//}
