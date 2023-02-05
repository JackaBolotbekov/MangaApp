package com.example.animeapp.ui.fragments.anime.detail

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.bumptech.glide.Glide
import com.example.animeapp.R
import com.example.animeapp.base.BaseFragment
import com.example.animeapp.databinding.FragmentAnimeDetailBinding
import com.example.animeapp.extensions.showText
import com.example.animeapp.utils.Resource
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AnimeDetailFragment : BaseFragment<FragmentAnimeDetailBinding, AnimeDetailViewModel>(
    R.layout.fragment_anime_detail
) {
    override val viewModel: AnimeDetailViewModel by viewModels()
    override val binding by viewBinding(FragmentAnimeDetailBinding::bind)
    private val args by navArgs<AnimeDetailFragmentArgs>()

    override fun initialize() {
        initial()
    }

    private fun initial() = with(binding) {
        viewModel.fetchAnimeDetail(args.id).observe(viewLifecycleOwner) {
            when (it) {
                is Resource.Error -> {
                    showText("Error")
                }
                is Resource.Loading -> {
                    showText("Loading")
                }
                is Resource.Success -> {
                    Glide.with(ivFullscreen.context)
                        .load(it.data?.data?.attributes?.posterImage?.original)
                        .into(ivFullscreen)
                    tvNameDetail.text = it.data?.data?.attributes?.titles?.enJp
                }
            }
        }
    }
}
