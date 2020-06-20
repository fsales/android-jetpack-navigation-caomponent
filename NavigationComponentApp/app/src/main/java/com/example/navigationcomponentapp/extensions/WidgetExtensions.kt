package com.example.navigationcomponentapp.extensions

import com.google.android.material.textfield.TextInputLayout
import kotlinx.android.synthetic.main.login_fragment.*

fun TextInputLayout.dismissError(){
    this.error = null
    this.isErrorEnabled = false
}