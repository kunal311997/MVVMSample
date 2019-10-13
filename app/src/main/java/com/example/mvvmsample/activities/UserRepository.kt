package com.example.mvvmsample.data.repositories

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.mvvmsample.model.LoginResponse
import com.example.mvvmsample.network.ApiCalls
import com.example.mvvmsample.network.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserRepository(
) {
    fun userLogin(email: String, password: String): LiveData<LoginResponse> {
        val loginResponse = MutableLiveData<LoginResponse>()

        val map = HashMap<String, String>()
        map.put("email", email)
        map.put("password", password)

        val apiService = RetrofitClient.retrofitInstance?.create(ApiCalls::class.java)
        val call = apiService?.login(map)
        call?.enqueue(object : Callback<LoginResponse> {
            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                loginResponse.postValue(response.body())
            }

            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                loginResponse.value = null
            }

        })

        return loginResponse
    }
}