package by.vjacheslavkovalenko.asteroidstms.ui

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import by.vjacheslavkovalenko.asteroidstms.R
import by.vjacheslavkovalenko.asteroidstms.ui.pictureofday.PictureOfDayFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, PictureOfDayFragment())
            .commit()

        //это было вставлено изначально, удалил пока что
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }
    }
}

//***PERPLEX***V4***XML
//
//package by.vjacheslavkovalenko.asteroidstms.ui.main
//
//import android.os.Bundle
//import androidx.appcompat.app.AppCompatActivity
//import androidx.navigation.NavController
//import androidx.navigation.fragment.NavHostFragment
//import by.vjacheslavkovalenko.asteroidstms.R
//
//class MainActivity : AppCompatActivity() {
//
//    private lateinit var navController: NavController
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main) // Устанавливаем основной макет
//
//        // Настройка навигации
//        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
//        navController = navHostFragment.navController
//    }
//}