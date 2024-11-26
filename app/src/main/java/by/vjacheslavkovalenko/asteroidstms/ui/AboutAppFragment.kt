package by.vjacheslavkovalenko.asteroidstms.ui
//***PERPLEX***V4***XML
//package by.vjacheslavkovalenko.asteroidstms.ui.aboutapp

import androidx.fragment.app.Fragment

class AboutAppFragment : Fragment() {

    private var binding : FragmentAboutAppBinding? = null

    override fun onCreateView(
        inflater : LayoutInflater,
        container : ViewGroup?,
        savedInstanceState : Bundle?
    ) : View {
        binding = FragmentAboutAppBinding.inflate(inflater, container, false)
        return binding?.root ?: throw IllegalStateException("Binding is null")
    }

    override fun onViewCreated(view : View, savedInstanceState : Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.textViewAboutApp?.text = "Данное приложение показывает фото дня и радар астероидов."
        // Здесь вы можете установить картинку дня так же, как в других фрагментах.
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null // Освобождение привязки при уничтожении представления
    }
}