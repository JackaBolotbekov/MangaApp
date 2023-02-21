package com.example.animeapp.ui.fragments.main.manga

import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.animeapp.R
import com.example.animeapp.base.BaseFragment
import com.example.animeapp.databinding.FragmentMangaBinding
import com.example.animeapp.ui.adapters.MangaAdapter
import com.example.animeapp.ui.fragments.main._home.HomeFragmentDirections
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MangaFragment : BaseFragment<FragmentMangaBinding, MangaViewModel>(R.layout.fragment_manga) {

    override val binding by viewBinding(FragmentMangaBinding::bind)
    override val viewModel: MangaViewModel by viewModels()
    private val mangaAdapter = MangaAdapter(this::onClickListeners)

    override fun initialize() {
        setupRecycler()
    }

    override fun setupSubscribes() {
        subscribeToManga()
    }

    private fun setupRecycler() = with(binding) {
        recyclerView.adapter = mangaAdapter
    }

    private fun subscribeToManga() {
        viewModel.fetchManga().observe(viewLifecycleOwner) {
            viewModel.fetchManga().observe(viewLifecycleOwner) {
                lifecycleScope.launch { mangaAdapter.submitData(it) }
            }
        }
    }

    private fun onClickListeners(id: String) {
        findNavController().navigate(
            HomeFragmentDirections.actionHomeFragmentToMangaDetailFragment(
                id.toInt()
            )
        )
    }
}