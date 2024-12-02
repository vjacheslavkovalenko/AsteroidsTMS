package by.vjacheslavkovalenko.asteroidstms.main

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import by.vjacheslavkovalenko.asteroidstms.R
import dagger.hilt.android.AndroidEntryPoint
import by.vjacheslavkovalenko.asteroidstms.databinding.ActivityMainBinding

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private var binding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater) // Инициализация привязки данных
        setContentView(binding?.root) // Используем безопасное обращение

        // Настройка NavHostFragment для навигации между фрагментами.
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment?
        navHostFragment?.navController?.setGraph(R.navigation.main_nav_graph)
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}