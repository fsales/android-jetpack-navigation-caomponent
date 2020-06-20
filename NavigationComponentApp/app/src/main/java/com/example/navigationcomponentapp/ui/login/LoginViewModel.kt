package com.example.navigationcomponentapp.ui.login

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.navigationcomponentapp.R

class LoginViewModel : ViewModel() {

    sealed class AuthenticationState {
        class InvalidAuthentication(val fields: List<Pair<String, Int>>) : AuthenticationState()
    }

    val authenticationStateEvent = MutableLiveData<AuthenticationState>()

    fun autentication(userName: String, password: String) {
        if (isValidForm(userName, password)) {
            // autenticado
        }
    }

    private fun isValidForm(userName: String, password: String): Boolean {
        val invalidFields = arrayListOf<Pair<String, Int>>()

        if (userName.isEmpty()) {
            invalidFields.add(INPUT_USERNAME)
        }

        if (password.isEmpty()) {
            invalidFields.add(INPUT_PASSWORD)
        }

        if (invalidFields.isNotEmpty()) {
            authenticationStateEvent.value =
                AuthenticationState.InvalidAuthentication(invalidFields)
            return false
        }

        return true
    }

    companion object {
        val INPUT_USERNAME = "INPUT_USERNAME" to R.string.login_input_layout_error_invalid_username
        val INPUT_PASSWORD = "INPUT_PASSWORD" to R.string.login_input_layout_error_invalid_password
    }

}