package com.example.animeapp.ui.fragments.home

import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.animeapp.R
import com.example.animeapp.base.BaseFragment
import com.example.animeapp.base.BaseViewModel
import com.example.animeapp.databinding.FragmentHomeBinding
import com.example.animeapp.ui.adapters.PagerAdapter
import com.example.animeapp.ui.fragments.anime.AnimeFragment
import com.example.animeapp.ui.fragments.manga.MangaFragment

class HomeFragment : BaseFragment<FragmentHomeBinding, BaseViewModel>(R.layout.fragment_home) {

    override val binding by viewBinding(FragmentHomeBinding::bind)
    override val viewModel by viewModels<BaseViewModel>()

    override fun initialize() {
        tabLayout()
    }

    private fun tabLayout() {
        val pagerAdapter = PagerAdapter(childFragmentManager)
        pagerAdapter.addFragment(AnimeFragment(), "Anime")
        pagerAdapter.addFragment(MangaFragment(), "Manga")

        binding.viewPager.adapter = pagerAdapter
        binding.tabLayout.setupWithViewPager(binding.viewPager)
    }
}