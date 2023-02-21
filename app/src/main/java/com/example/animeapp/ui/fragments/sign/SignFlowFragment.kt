package com.example.animeapp.ui.fragments.sign

import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.animeapp.R
import com.example.animeapp.base.BaseFlowFragment
import com.example.animeapp.databinding.FragmentSignFlowBinding

class SignFlowFragment : BaseFlowFragment<FragmentSignFlowBinding>(R.layout.fragment_sign_flow) {

    override val binding by viewBinding(FragmentSignFlowBinding::bind)
    override val fragmentContainer = R.id.sign_nav_host_fragment
}