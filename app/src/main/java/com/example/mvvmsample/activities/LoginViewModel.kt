package com.example.mvvmsample.activities

import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvmsample.data.repositories.UserRepository
import com.example.mvvmsample.model.LoginResponse

class LoginViewModel(private val userRepository: UserRepository) : ViewModel() {
    var email: String? = null;
    var password: String? =null;

    var loginResult = MutableLiveData<LoginResponse>()
    var loginForm = MutableLiveData<String>()

    fun onLoginButtonClicked(view: View) {

        if (email.toString().equals("") || password.equals("")) {
            loginForm.value = "empty"
        } else {
            login(email.toString(), password.toString())
            loginForm.value = "valid"
        }
    }

    fun login(email: String, password: String) {
        val result = userRepository.userLogin(email, password)
        loginResult.value = result.value
    }
}