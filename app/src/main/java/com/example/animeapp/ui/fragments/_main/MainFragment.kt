package com.example.animeapp.ui.fragments._main

import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.animeapp.R
import com.example.animeapp.databinding.FragmentMainBinding
import com.example.animeapp.ui.adapters.Adapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : Fragment(R.layout.fragment_main) {

    private val viewModel: MainViewModel by viewModels()
    private val binding by viewBinding(FragmentMainBinding::bind)
    private val mainAdapter = Adapter(this::onClickListeners)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initial()
        setupObserves()
    }

    private fun initial() = with(binding) {
        recyclerView.adapter = mainAdapter
    }

    private fun setupObserves() {
        viewModel.fetchAnime().observe(viewLifecycleOwner) {
            mainAdapter.submitList(it.data)
        }
    }

    private fun onClickListeners(id: String) {
        findNavController().navigate(MainFragmentDirections.actionMainFragmentToDetailFragment(id.toInt()))
    }
}