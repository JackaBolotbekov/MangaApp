package com.example.animeapp.ui.adapters

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.animeapp.ui.fragments.anime.AnimeFragment
import com.example.animeapp.ui.fragments.manga.MangaFragment

class PagerAdapter(fragment: Fragment) :
    FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> AnimeFragment()
            else -> MangaFragment()
        }
    }
}