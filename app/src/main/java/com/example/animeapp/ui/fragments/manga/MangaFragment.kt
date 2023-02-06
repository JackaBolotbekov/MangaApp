package com.example.animeapp.ui.fragments.manga

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.animeapp.R
import com.example.animeapp.base.BaseFragment
import com.example.animeapp.databinding.FragmentMangaBinding
import com.example.animeapp.extensions.showText
import com.example.animeapp.ui.adapters.MangaAdapter
import com.example.animeapp.ui.fragments.pager.PagerFragmentDirections
import com.example.animeapp.utils.Resource
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MangaFragment : BaseFragment<FragmentMangaBinding, MangaViewModel>(R.layout.fragment_manga) {

    override val binding by viewBinding(FragmentMangaBinding::bind)
    override val viewModel: MangaViewModel by viewModels()
    private val mangaAdapter = MangaAdapter(this::onClickListeners)

    override fun initialize() {
        initial()
    }

    override fun setupSubscribes() {
        setupObserves()
    }

    private fun initial() = with(binding) {
        recyclerView.adapter = mangaAdapter
    }

    private fun setupObserves() {
        viewModel.fetchManga().observe(viewLifecycleOwner) {
            when (it) {
                is Resource.Error -> {
                    showText("Error")
                }
                is Resource.Loading -> {
                    showText("Loading")
                }
                is Resource.Success -> {
                    mangaAdapter.submitList(it.data?.data)
                }
            }
        }
    }

    private fun onClickListeners(id: String) {
        findNavController().navigate(
            PagerFragmentDirections.actionPagerFragmentToMangaDetailFragment(
                id.toInt()
            )
        )
    }
}