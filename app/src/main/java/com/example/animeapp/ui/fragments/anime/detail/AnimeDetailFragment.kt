package com.example.animeapp.ui.fragments.anime.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.bumptech.glide.Glide
import com.example.animeapp.R
import com.example.animeapp.databinding.FragmentAnimeDetailBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AnimeDetailFragment : Fragment(R.layout.fragment_anime_detail) {

    private val viewModel: AnimeDetailViewModel by viewModels()
    private val binding by viewBinding(FragmentAnimeDetailBinding::bind)
    private val args by navArgs<AnimeDetailFragmentArgs>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initial()
    }

    private fun initial() = with(binding) {
        viewModel.fetchAnimeDetail(args.id).observe(viewLifecycleOwner) {
            Glide.with(ivFullscreen.context)
                .load(it.data.attributes.posterImage.original)
                .into(ivFullscreen)
            tvNameDetail.text = it.data.attributes.titles.enJp
        }
    }
}
