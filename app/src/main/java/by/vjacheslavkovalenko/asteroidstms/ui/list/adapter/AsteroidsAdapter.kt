package by.vjacheslavkovalenko.asteroidstms.ui.list.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import by.vjacheslavkovalenko.asteroidstms.databinding.ItemAsteroidsBinding
import by.vjacheslavkovalenko.asteroidstms.model.Asteroids
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

//class AsteroidsAdapter(
//    private val onClick: (asteroids: Asteroids) -> Unit
//) : PagingDataAdapter<Asteroids, AsteroidsViewHolder>(
//    object : DiffUtil.ItemCallback<Asteroids>() {
//        override fun areItemsTheSame(oldItem: Asteroids, newItem: Asteroids): Boolean {
//            return oldItem == newItem
//        }
//
//        override fun areContentsTheSame(oldItem: Asteroids, newItem: Asteroids): Boolean {
//            return oldItem.asteroidId == newItem.asteroidId
//        }
//    }
//) {

class AsteroidsAdapter(
    private val onClick: (Asteroids) -> Unit // Обработчик клика на астероид
) : PagingDataAdapter<Asteroids, AsteroidsViewHolder>(
    object : DiffUtil.ItemCallback<Asteroids>() {
        override fun areItemsTheSame(oldItem: Asteroids, newItem: Asteroids): Boolean {
            return oldItem.asteroidId == newItem.asteroidId // Сравнение по уникальному идентификатору.
        }

        override fun areContentsTheSame(oldItem: Asteroids, newItem: Asteroids): Boolean {
            return oldItem == newItem // Сравнение содержимого объектов астероидов.
        }
    }
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AsteroidsViewHolder {
        return AsteroidsViewHolder(
            ItemAsteroidsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

//    override fun onBindViewHolder(holder: AsteroidsViewHolder, position: Int) {
//        getItem(position)?.let { asteroids: Asteroids ->
//            holder.bind(asteroids)
//            holder.itemView.setOnClickListener {
//                onClick(asteroids)
//            }
//        }
//    }
//}

    override fun onBindViewHolder(holder: AsteroidsViewHolder, position: Int) {
        getItem(position)?.let { asteroid ->
            holder.bind(asteroid) // Привязка данных к ViewHolder.
            holder.itemView.setOnClickListener {
                onClick(asteroid) // Вызываем обработчик клика.
            }
        }
    }
}