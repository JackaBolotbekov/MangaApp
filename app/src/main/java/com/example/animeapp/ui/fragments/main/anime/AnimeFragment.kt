package com.example.animeapp.ui.fragments.main.anime

import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.animeapp.R
import com.example.animeapp.base.BaseFragment
import com.example.animeapp.databinding.FragmentAnimeBinding
import com.example.animeapp.ui.adapters.AnimeAdapter
import com.example.animeapp.ui.fragments.main._home.HomeFragmentDirections
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class AnimeFragment : BaseFragment<FragmentAnimeBinding, AnimeViewModel>(
    R.layout.fragment_anime
) {
    override val binding by viewBinding(FragmentAnimeBinding::bind)
    override val viewModel: AnimeViewModel by viewModels()
    private val animeAdapter = AnimeAdapter(this::onClickListeners)

    override fun initialize() {
        setupRecycler()
    }

    override fun setupSubscribes() {
        subscribeToAnime()
    }

    private fun setupRecycler() = with(binding.recyclerView) {
        layoutManager = GridLayoutManager(requireContext(), 3)
        adapter = animeAdapter
    }

    private fun subscribeToAnime() {
        viewModel.fetchAnime().observe(viewLifecycleOwner) {
            lifecycleScope.launch { animeAdapter.submitData(it) }
        }
    }

    private fun onClickListeners(id: String) {
        findNavController().navigate(
            HomeFragmentDirections.actionHomeFragmentToAnimeDetailFragment(
                id.toInt()
            )
        )
    }
}