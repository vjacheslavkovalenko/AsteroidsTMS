package by.vjacheslavkovalenko.asteroidstms.utils

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import by.vjacheslavkovalenko.asteroidstms.R
import com.bumptech.glide.Glide

@BindingAdapter("statusIcon")
fun bindAsteroidStatusImage(imageView: ImageView, isHazardous: Boolean) {
    val resource = if (isHazardous) {
        R.drawable.asteroid_hazardous // Иконка для потенциально опасного астероида
    } else {
        R.drawable.asteroid_safe // Иконка для безопасного астероида
    }
    imageView.setImageResource(resource)
}

@BindingAdapter("imageUrl")
fun loadImage(imageView: ImageView, url: String?) {
    if (!url.isNullOrEmpty()) {
        Glide.with(imageView.context)
            .load(url)
            .into(imageView)
    } else {
        imageView.visibility = View.GONE // Скрыть изображение, если URL пустой
    }
}

@BindingAdapter("astronomicalUnitText")
fun bindAstronomicalUnitText(textView: TextView, value: Double) {
    textView.text = String.format("%.2f au", value)
}

@BindingAdapter("kmUnitText")
fun bindKmUnitText(textView: TextView, value: Double) {
    textView.text = String.format("%.2f km", value)
}

@BindingAdapter("velocityText")
fun bindVelocityText(textView: TextView, value: Double) {
    textView.text = String.format("%.2f km/s", value)
}