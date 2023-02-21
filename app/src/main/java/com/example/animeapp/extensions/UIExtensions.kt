package com.example.animeapp.extensions

import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide

fun Fragment.showText(text: String) {
    Toast.makeText(requireContext(), text, Toast.LENGTH_SHORT).show()
}
fun ImageView.glideWith(url: String) {
    Glide.with(this.context).load(url).into(this)
}
