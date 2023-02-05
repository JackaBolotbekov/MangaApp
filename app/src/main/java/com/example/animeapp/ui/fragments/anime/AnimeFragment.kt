package com.example.animeapp.ui.fragments.anime

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.animeapp.R
import com.example.animeapp.base.BaseFragment
import com.example.animeapp.databinding.FragmentAnimeBinding
import com.example.animeapp.extensions.showText
import com.example.animeapp.ui.adapters.AnimeAdapter
import com.example.animeapp.utils.Resource
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AnimeFragment : BaseFragment<FragmentAnimeBinding, AnimeViewModel>(
    R.layout.fragment_anime
) {
    override val binding by viewBinding(FragmentAnimeBinding::bind)
    override val viewModel: AnimeViewModel by viewModels()
    private val animeAdapter = AnimeAdapter(this::onClickListeners)

    override fun initialize() {
        initial()
    }

    override fun setupSubscribes() {
        setupObserves()
    }

    private fun initial() = with(binding) {
        recyclerView.adapter = animeAdapter
    }

    private fun setupObserves() {
        viewModel.fetchAnime().observe(viewLifecycleOwner) {
            when (it) {
                is Resource.Error -> {
                    showText("Error")
                }
                is Resource.Loading -> {
                    showText("Loading")
                }
                is Resource.Success -> {
                    animeAdapter.submitList(it.data?.data)
                }
            }
        }
    }

    private fun onClickListeners(id: String) {
        findNavController().navigate(
            AnimeFragmentDirections.actionAnimeFragmentToAnimeDetailFragment(
                id.toInt()
            )
        )
    }
}