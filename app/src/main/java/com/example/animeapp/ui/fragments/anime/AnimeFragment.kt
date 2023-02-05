package com.example.animeapp.ui.fragments.anime

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.animeapp.R
import com.example.animeapp.databinding.FragmentAnimeBinding
import com.example.animeapp.ui.adapters.AnimeAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AnimeFragment : Fragment(R.layout.fragment_anime) {

    private val viewModel: AnimeViewModel by viewModels()
    private val binding by viewBinding(FragmentAnimeBinding::bind)
    private val animeAdapter = AnimeAdapter(this::onClickListeners)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initial()
        setupObserves()
    }

    private fun initial() = with(binding) {
        recyclerView.adapter = animeAdapter
    }

    private fun setupObserves() {
        viewModel.fetchAnime().observe(viewLifecycleOwner) {
            animeAdapter.submitList(it.data)
        }
    }

    private fun onClickListeners(id: String) {
        findNavController().navigate(AnimeFragmentDirections.actionAnimeFragmentToAnimeDetailFragment(id.toInt()))
    }
}