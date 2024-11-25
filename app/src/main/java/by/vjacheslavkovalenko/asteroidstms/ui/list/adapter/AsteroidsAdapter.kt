package by.vjacheslavkovalenko.asteroidstms.ui.list.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import by.vjacheslavkovalenko.asteroidstms.database.entity.AsteroidsEntity
import by.vjacheslavkovalenko.asteroidstms.databinding.ItemAsteroidsBinding
import by.vjacheslavkovalenko.asteroidstms.model.Asteroids

class AsteroidsAdapter(
    private val onClick: (asteroids: Asteroids) -> Unit
) : PagingDataAdapter<Asteroids, AsteroidsViewHolder>(
    object : DiffUtil.ItemCallback<Asteroids>() {
        override fun areItemsTheSame(oldItem: Asteroids, newItem: Asteroids): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Asteroids, newItem: Asteroids): Boolean {
            return oldItem.asteroidId == newItem.asteroidId
        }
    }
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AsteroidsViewHolder {
        return AsteroidsViewHolder(
            ItemAsteroidsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: AsteroidsViewHolder, position: Int) {
        getItem(position)?.let { asteroids: Asteroids ->
            holder.bind(asteroids)
            holder.itemView.setOnClickListener {
                onClick(asteroids)
            }
        }
    }


}


//ии написал
//package by.vjacheslavkovalenko.asteroidstms.ui.list.adapter
//
//import android.view.LayoutInflater
//import android.view.ViewGroup
//import androidx.paging.PagingDataAdapter
//import androidx.recyclerview.widget.DiffUtil
//import by.vjacheslavkovalenko.asteroidstms.databinding.ItemAsteroidsBinding
//import by.vjacheslavkovalenko.asteroidstms.model.Asteroids
//
//class AsteroidsAdapter(
//    private val onClick: (Asteroids) -> Unit
//) : PagingDataAdapter<Asteroids, AsteroidsViewHolder>(
//    object : DiffUtil.ItemCallback<Asteroids>() {
//        override fun areItemsTheSame(oldItem: Asteroids, newItem: Asteroids): Boolean {
//            return oldItem.asteroidId == newItem.asteroidId // Сравнение по уникальному идентификатору
//        }
//
//        override fun areContentsTheSame(oldItem: Asteroids, newItem: Asteroids): Boolean {
//            return oldItem == newItem // Сравнение содержимого объектов
//        }
//    }
//) {
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AsteroidsViewHolder {
//        val binding = ItemAsteroidsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
//        return AsteroidsViewHolder(binding, onClick) // Передаем обработчик клика в ViewHolder
//    }
//
//    override fun onBindViewHolder(holder: AsteroidsViewHolder, position: Int) {
//        getItem(position)?.let { asteroids ->
//            holder.bind(asteroids)
//            // Установка обработчика клика уже происходит в ViewHolder
//        }
//    }
//}



// ии рекомендовал
//Вот обновленный код для вашего класса AsteroidsViewHolder, чтобы он принимал обработчик клика:
//package by.vjacheslavkovalenko.asteroidstms.ui.list.adapter
//
//import androidx.recyclerview.widget.RecyclerView
//import by.vjacheslavkovalenko.asteroidstms.databinding.ItemAsteroidsBinding
//import by.vjacheslavkovalenko.asteroidstms.model.Asteroids
//
//class AsteroidsViewHolder(
//    private val binding: ItemAsteroidsBinding,
//    private val onClick: (Asteroids) -> Unit // Лямбда для обработки кликов
//) : RecyclerView.ViewHolder(binding.root) {
//
//    init {
//        binding.root.setOnClickListener {
//            // Получаем астероид по позиции и вызываем onClick
//            bindingAdapterPosition.takeIf { it != RecyclerView.NO_POSITION }?.let { position ->
//                onClick(getItem(position)) // Здесь нужно реализовать метод получения элемента по позиции
//            }
//        }
//    }
//
//    fun bind(asteroids: Asteroids) {
//        binding.nameTextView.text = asteroids.name // Предполагается, что у Asteroids есть поле name
//        // Здесь можно добавить другие поля, если они есть в Asteroids
//    }
//
//    private fun getItem(position: Int): Asteroids {
//        // Реализуйте логику получения элемента по позиции из адаптера или другого источника данных.
//        throw NotImplementedError("Implement getItem() to retrieve the asteroid item.")
//    }
//}



















