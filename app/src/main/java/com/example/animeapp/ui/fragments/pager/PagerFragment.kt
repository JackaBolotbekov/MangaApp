package com.example.animeapp.ui.fragments.pager

import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.animeapp.R
import com.example.animeapp.base.BaseFragment
import com.example.animeapp.databinding.FragmentPagerBinding
import com.example.animeapp.ui.adapters.PagerAdapter
import com.example.animeapp.ui.fragments.anime.AnimeFragment
import com.example.animeapp.ui.fragments.manga.MangaFragment

class PagerFragment : BaseFragment<FragmentPagerBinding, PagerViewModel>(R.layout.fragment_pager) {

    override val binding by viewBinding(FragmentPagerBinding::bind)
    override val viewModel by viewModels<PagerViewModel>()

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