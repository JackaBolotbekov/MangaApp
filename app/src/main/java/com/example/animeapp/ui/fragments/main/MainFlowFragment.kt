package com.example.animeapp.ui.fragments.main

import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.animeapp.R
import com.example.animeapp.base.BaseFlowFragment
import com.example.animeapp.databinding.FragmentMainFlowBinding

class MainFlowFragment : BaseFlowFragment<FragmentMainFlowBinding>(R.layout.fragment_main_flow) {

    override val binding by viewBinding(FragmentMainFlowBinding::bind)
    override val fragmentContainer = R.id.main_nav_host_fragment
}