package com.example.animeapp.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.animeapp.R
import com.example.animeapp.data.locale.preferences.userdata.UserPreferencesData
import com.example.animeapp.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity(R.layout.activity_main) {

    @Inject
    lateinit var userPreferencesData: UserPreferencesData
    private val binding by viewBinding(ActivityMainBinding::bind)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setupNavigation()
    }

    private fun setupNavigation() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController

        val navGraph = navController.navInflater.inflate(R.navigation.nav_graph)

        when {
            userPreferencesData.isAuthorized -> {
                navGraph.setStartDestination(R.id.mainFlowFragment)
            }
            else -> {
                navGraph.setStartDestination(R.id.signFlowFragment)
            }
        }
        navController.graph = navGraph
    }
}