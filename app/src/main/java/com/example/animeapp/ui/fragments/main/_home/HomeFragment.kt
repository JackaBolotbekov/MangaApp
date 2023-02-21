package com.example.animeapp.ui.fragments.main._home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.animeapp.R
import com.example.animeapp.databinding.FragmentHomeBinding
import com.example.animeapp.ui.adapters.PagerAdapter
import com.google.android.material.tabs.TabLayoutMediator

class HomeFragment : Fragment(R.layout.fragment_home) {

    private val binding by viewBinding(FragmentHomeBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
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