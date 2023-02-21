package com.example.animeapp.ui.fragments.signup

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.animeapp.R
import com.example.animeapp.base.BaseFragment
import com.example.animeapp.data.locale.preferences.userdata.UserPreferencesData
import com.example.animeapp.data.models.auth.AuthModel
import com.example.animeapp.databinding.FragmentSignUpBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class SignUpFragment :
    BaseFragment<FragmentSignUpBinding, SignUpViewModel>(R.layout.fragment_sign_up) {

    @Inject
    lateinit var userPreferencesData: UserPreferencesData
    override val binding by viewBinding(FragmentSignUpBinding::bind)
    override val viewModel: SignUpViewModel by viewModels()

    override fun setupSubscribes() = with(binding) {

        binding.fabNext.setOnClickListener {
            val email = etEnterName.text.toString()
            val password = etEnterPassword.text.toString()
            val authModel = AuthModel("password", email, password)

            viewModel.postUserData(authModel).observe(viewLifecycleOwner) {
                userPreferencesData.apply {
                    isAuthorized = true
                    accessToken = accessToken
                    refreshToken = refreshToken
                }

                findNavController().navigate(
                    R.id.action_signUpFragment_to_homeFragment
                )
            }
        }
    }
}