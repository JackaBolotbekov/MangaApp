package com.example.animeapp.ui.fragments.manga.detail

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.animeapp.R
import com.example.animeapp.base.BaseFragment
import com.example.animeapp.databinding.FragmentMangaDetailBinding
import com.example.animeapp.extensions.glideWith
import com.example.animeapp.extensions.showText
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MangaDetailFragment : BaseFragment<FragmentMangaDetailBinding, MangaDetailViewModel>(
    R.layout.fragment_manga_detail
) {
    override val viewModel: MangaDetailViewModel by viewModels()
    override val binding by viewBinding(FragmentMangaDetailBinding::bind)
    private val args by navArgs<MangaDetailFragmentArgs>()

    override fun setupSubscribes() {
        subscribeToMangaById()
    }

    private fun subscribeToMangaById() = with(binding) {
        viewModel.fetchMangaDetail(args.id).subscribe(
            onError = {
                showText(it)
            },
            onSuccess = {
                it.data.let { anime ->
                    ivFullscreenManga.glideWith(anime.attributes.posterImage.original)
                    tvNameDetailManga.text = anime.attributes.titles.enJp
                }
            }
        )
    }
}