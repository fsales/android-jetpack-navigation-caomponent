package com.example.navigationcomponentapp.ui.registration.profiledata

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.navigationcomponentapp.R
import com.example.navigationcomponentapp.ui.registration.RegistrationViewModel
import kotlinx.android.synthetic.main.fragment_profile_data.*


class ProfileDataFragment : Fragment() {


    private val registrationViewModel : RegistrationViewModel by activityViewModels<RegistrationViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_profile_data, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        registrationViewModel.registrationStateEvent.observe(viewLifecycleOwner, Observer { registrationState ->
            when (registrationState){
                is RegistrationViewModel.RegistrationState.CollectCredentials ->{
                    val name = inputProfileDataName.text.toString()
                    val directions = ProfileDataFragmentDirections
                        .actionProfileDataFragmentToChooseCredentialsFragment(name)

                    findNavController().navigate(directions)
                }
            }

        })
    }

}