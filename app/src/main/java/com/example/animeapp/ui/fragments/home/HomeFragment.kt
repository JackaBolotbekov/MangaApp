package com.example.animeapp.ui.fragments.home

import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.animeapp.R
import com.example.animeapp.base.BaseFragment
import com.example.animeapp.base.BaseViewModel
import com.example.animeapp.databinding.FragmentHomeBinding
import com.example.animeapp.ui.adapters.PagerAdapter
import com.google.android.material.tabs.TabLayoutMediator

class HomeFragment : BaseFragment<FragmentHomeBinding, BaseViewModel>(R.layout.fragment_home) {

    override val binding by viewBinding(FragmentHomeBinding::bind)
    override val viewModel by viewModels<BaseViewModel>()

    override fun initialize() {
        tabLayout()
    }

    private fun tabLayout() = with(binding) {
        viewPager.adapter = PagerAdapter(this@HomeFragment)
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, pos ->
            when (pos) {
                0 -> {
                    tab.text = "Anime"
                }
                1 -> {
                    tab.text = "Manga"
                }
            }
        }
    }.attach()
}