package com.example.animeapp.ui.fragments.sign.`in`

import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.animeapp.R
import com.example.animeapp.base.BaseFragment
import com.example.animeapp.data.locale.preferences.userdata.UserPreferencesData
import com.example.animeapp.data.models.auth.AuthModel
import com.example.animeapp.databinding.FragmentSignInBinding
import com.example.animeapp.extensions.showText
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class SignInFragment :
    BaseFragment<FragmentSignInBinding, SignInViewModel>(R.layout.fragment_sign_in) {

    @Inject
    lateinit var userPreferencesData: UserPreferencesData
    override val binding by viewBinding(FragmentSignInBinding::bind)
    override val viewModel: SignInViewModel by viewModels()

    override fun setupSubscribes() = with(binding) {
        binding.fabNext.setOnClickListener {
            val email = etEnterName.text.toString()
            val password = etEnterPassword.text.toString()
            val authModel = AuthModel("password", email, password)
            viewModel.postUserData(authModel).subscribe(
                onError = { showText("Error") },
                onSuccess = {
                    userPreferencesData.apply {
                        isAuthorized = true
                        accessToken = accessToken
                        refreshToken = refreshToken
                    }

                    requireActivity().findNavController(R.id.nav_host_fragment).navigate(
                        R.id.action_signFlowFragment_to_mainFlowFragment
                    )
                }
            )
        }
    }
}