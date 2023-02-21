package com.example.animeapp.ui.fragments.anime.detail

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.animeapp.R
import com.example.animeapp.base.BaseFragment
import com.example.animeapp.databinding.FragmentAnimeDetailBinding
import com.example.animeapp.extensions.glideWith
import com.example.animeapp.extensions.showText
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AnimeDetailFragment : BaseFragment<FragmentAnimeDetailBinding, AnimeDetailViewModel>(
    R.layout.fragment_anime_detail
) {
    override val viewModel: AnimeDetailViewModel by viewModels()
    override val binding by viewBinding(FragmentAnimeDetailBinding::bind)
    private val args by navArgs<AnimeDetailFragmentArgs>()

    override fun setupSubscribes() {
        subscribeToAnimeById()
    }

    private fun subscribeToAnimeById() = with(binding) {
        viewModel.fetchAnimeDetail(args.id).subscribe(
            onError ={
                showText(it)
            },
            onSuccess = {
                it.data.let { anime ->
                    binding.ivFullscreen.glideWith(anime.attributes.posterImage.original)
                    tvNameDetail.text = anime.attributes.titles.enJp
                }
            }
        )
    }
}