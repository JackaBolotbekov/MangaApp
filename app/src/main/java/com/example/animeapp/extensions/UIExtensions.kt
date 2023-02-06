package com.example.animeapp.extensions

import android.widget.Toast
import com.example.animeapp.ui.fragments.anime.AnimeFragment
import com.example.animeapp.ui.fragments.anime.detail.AnimeDetailFragment
import com.example.animeapp.ui.fragments.manga.MangaFragment
import com.example.animeapp.ui.fragments.manga.detail.MangaDetailFragment

fun AnimeFragment.showText(text: String) {
    Toast.makeText(requireContext(), text, Toast.LENGTH_SHORT).show()
}

fun AnimeDetailFragment.showText(text: String) {
    Toast.makeText(requireContext(), text, Toast.LENGTH_SHORT).show()
}

fun MangaFragment.showText(text: String) {
    Toast.makeText(requireContext(), text, Toast.LENGTH_SHORT).show()
}

fun MangaDetailFragment.showText(text: String) {
    Toast.makeText(requireContext(), text, Toast.LENGTH_SHORT).show()
}
