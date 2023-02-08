package com.example.animeapp.ui.fragments.manga.detail

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.bumptech.glide.Glide
import com.example.animeapp.R
import com.example.animeapp.base.BaseFragment
import com.example.animeapp.databinding.FragmentMangaDetailBinding
import com.example.animeapp.extensions.showText
import com.example.animeapp.utils.Resource
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
        viewModel.fetchMangaDetail(args.id).observe(viewLifecycleOwner) {
            when (it) {
                is Resource.Error -> {
                    showText("Error")
                }
                is Resource.Loading -> {
                    showText("Loading")
                }
                is Resource.Success -> {
                    Glide.with(ivFullscreenManga.context)
                        .load(it.data?.data?.attributes?.posterImage?.original)
                        .into(ivFullscreenManga)
                    tvNameDetailManga.text = it.data?.data?.attributes?.titles?.enJp
                }
            }
        }
    }
}