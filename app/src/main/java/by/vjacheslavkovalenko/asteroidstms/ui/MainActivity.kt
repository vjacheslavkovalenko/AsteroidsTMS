package by.vjacheslavkovalenko.asteroidstms.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import by.vjacheslavkovalenko.asteroidstms.R
import dagger.hilt.android.AndroidEntryPoint
import by.vjacheslavkovalenko.asteroidstms.databinding.ActivityMainBinding
import by.vjacheslavkovalenko.asteroidstms.ui.pictureofday.PictureOfDayFragment

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, PictureOfDayFragment())
            .commit()
    }
}



//@AndroidEntryPoint
//class MainActivity : AppCompatActivity() {
//
//    private var binding: ActivityMainBinding? = null
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        binding = ActivityMainBinding.inflate(layoutInflater)
//        setContentView(binding?.root)
//
//        // Настройка NavHostFragment для навигации между фрагментами.
//        val navHostFragment =
//            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment?
//        navHostFragment?.navController?.setGraph(R.navigation.main_nav_graph)
//    }
//
//    override fun onDestroy() {
//        super.onDestroy()
//        binding = null
//    }
//}