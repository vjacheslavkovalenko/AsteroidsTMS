package by.vjacheslavkovalenko.asteroidstms.ui.list.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import by.vjacheslavkovalenko.asteroidstms.databinding.ItemAsteroidsBinding
import by.vjacheslavkovalenko.asteroidstms.model.Asteroids
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import by.vjacheslavkovalenko.asteroidstms.databinding.ItemAsteroidBinding
import by.vjacheslavkovalenko.asteroidstms.network.entity.NearEarthObject

//555
class AsteroidsAdapter(
    private var asteroids: List<NearEarthObject>,
    private val onClick: (String) -> Unit // Функция обратного вызова для обработки кликов по астероидам
) : RecyclerView.Adapter<AsteroidsAdapter.AsteroidViewHolder>() {

    inner class AsteroidViewHolder(private val binding: ItemAsteroidBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(asteroid: NearEarthObject) {
            binding.textViewName.text = asteroid.nameAsteroid // Пример привязки данных к UI элементам
            binding.textViewDiameter.text = "Diameter: ${asteroid.estimatedDiameter.kilometers.estimatedDiameterMax} km" // Пример отображения диаметра

            itemView.setOnClickListener {
                onClick(asteroid.asteroidId) // Передаем идентификатор астероида при клике
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AsteroidViewHolder {
        val binding = ItemAsteroidBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AsteroidViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AsteroidViewHolder, position: Int) {
        holder.bind(asteroids[position])
    }

    override fun getItemCount(): Int = asteroids.size

    fun updateData(newAsteroids: List<NearEarthObject>) {
        asteroids = newAsteroids
        notifyDataSetChanged() // Обновляем адаптер с новыми данными
    }
}





//class AsteroidsAdapter(
//    private val onClick: (Asteroids) -> Unit // Обработчик клика на астероид
//) : PagingDataAdapter<Asteroids, AsteroidsViewHolder>(
//    object : DiffUtil.ItemCallback<Asteroids>() {
//        override fun areItemsTheSame(oldItem: Asteroids, newItem: Asteroids): Boolean {
//            return oldItem.asteroidId == newItem.asteroidId // Сравнение по уникальному идентификатору.
//        }
//
//        override fun areContentsTheSame(oldItem: Asteroids, newItem: Asteroids): Boolean {
//            return oldItem == newItem // Сравнение содержимого объектов астероидов.
//        }
//    }
//) {
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AsteroidsViewHolder {
//        return AsteroidsViewHolder(
//            ItemAsteroidsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
//        )
//    }
//
////    override fun onBindViewHolder(holder: AsteroidsViewHolder, position: Int) {
////        getItem(position)?.let { asteroids: Asteroids ->
////            holder.bind(asteroids)
////            holder.itemView.setOnClickListener {
////                onClick(asteroids)
////            }
////        }
////    }
////}
//
//    override fun onBindViewHolder(holder: AsteroidsViewHolder, position: Int) {
//        getItem(position)?.let { asteroid ->
//            holder.bind(asteroid) // Привязка данных к ViewHolder.
//            holder.itemView.setOnClickListener {
//                onClick(asteroid) // Вызываем обработчик клика.
//            }
//        }
//    }
//}