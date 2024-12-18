package by.vjacheslavkovalenko.asteroidstms.utils

import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.loadUrl(url: String) {
    Glide.with(context)
        .load(url)
        .into(this)
}

//Вызов из любого места:
//binding?.image?.loadUrl(it.message)