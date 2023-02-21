package com.example.animeapp.base

import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import androidx.viewbinding.ViewBinding

abstract class BaseFlowFragment<VB : ViewBinding>(
    @LayoutRes layoutId: Int
) : Fragment(layoutId) {

    abstract val binding: VB
    abstract val fragmentContainer: Int

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupNavigation()
    }

    protected open fun setupNavigation() {
        val navHostFragment =
            childFragmentManager.findFragmentById(fragmentContainer) as NavHostFragment
        val navController = navHostFragment.navController
    }
}