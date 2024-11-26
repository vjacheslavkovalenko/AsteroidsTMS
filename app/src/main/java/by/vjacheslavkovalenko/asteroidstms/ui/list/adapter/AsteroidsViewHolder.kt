package by.vjacheslavkovalenko.asteroidstms.ui.list.adapter

import androidx.recyclerview.widget.RecyclerView.ViewHolder
import by.vjacheslavkovalenko.asteroidstms.database.entity.AsteroidsEntity
import by.vjacheslavkovalenko.asteroidstms.databinding.ItemAsteroidsBinding
import by.vjacheslavkovalenko.asteroidstms.model.Asteroids

class AsteroidsViewHolder(private val binding: ItemAsteroidsBinding) : ViewHolder(binding.root) {

    fun bind(asteroids: Asteroids) {
        binding.nameTextView.text = asteroids.asteroidId
    }
}



//ии написал
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
//        // Установка обработчика клика на элемент списка
//        binding.root.setOnClickListener {
//            bindingAdapterPosition.takeIf { it != RecyclerView.NO_POSITION }?.let { position ->
//                // Получаем астероид по позиции и вызываем onClick
//                onClick(getItem(position))
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
//        // Здесь необходимо реализовать логику получения элемента по позиции
//        // Например, если у вас есть ссылка на список астероидов в адаптере
//        // return asteroidsList[position]
//        throw NotImplementedError("Implement getItem() to retrieve the asteroid item.")
//    }
//}


//ии рекомендовал:
//Вот пример того, как можно использовать AsteroidsViewHolder в вашем адаптере:
//class AsteroidsAdapter(private val onClick: (Asteroids) -> Unit) : PagingDataAdapter<Asteroids, AsteroidsViewHolder>(AsteroidDiffCallback()) {
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AsteroidsViewHolder {
//        val binding = ItemAsteroidsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
//        return AsteroidsViewHolder(binding, onClick)
//    }
//
//    override fun onBindViewHolder(holder: AsteroidsViewHolder, position: Int) {
//        val asteroid = getItem(position)
//        if (asteroid != null) {
//            holder.bind(asteroid)
//        }
//    }
//}