package com.example.mvvmsample.activities

import android.util.Log
import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvmsample.data.repositories.UserRepository
import com.example.mvvmsample.model.LoginResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import retrofit2.Response

class LoginViewModel(private val userRepository: UserRepository) : ViewModel() {
    var email: String? = "";
    var password: String? = "";

    var loginResult = MutableLiveData<LoginResponse>()
    var loginForm = MutableLiveData<String>()
    var isLoading: MutableLiveData<Boolean> = MutableLiveData(true)

    fun onLoginButtonClicked(view: View) {
        isLoading.value = true
        if (!email.toString().equals("")) {
            if (!password.equals("")) {
                login(email.toString(), password.toString())
                loginForm.value = "valid"
            } else {
                loginForm.value = "invalid pass"

            }
        } else {
            loginForm.value = "invalid email"

        }
    }

    fun login(email: String, password: String) {
        isLoading.value = true
        main {
            val result: Response<LoginResponse> = userRepository.userLogin(email, password)
            isLoading.postValue(false)
            if (result.isSuccessful) {
                loginResult.postValue(result.body())
            } else {
                loginForm.postValue(result.message())
            }
            Log.e("reretrtsrtr", result.toString())
        }

    }

    override fun onCleared() {
        super.onCleared()
        CoroutineScope(Dispatchers.IO).coroutineContext.cancel()
    }

    fun main(work: suspend (() -> Unit)) {
        CoroutineScope(Dispatchers.IO).launch {
            work()
        }
    }
}