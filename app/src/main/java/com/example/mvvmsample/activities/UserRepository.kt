package com.example.mvvmsample.data.repositories

import com.example.mvvmsample.model.LoginResponse
import com.example.mvvmsample.network.ApiCalls
import com.example.mvvmsample.network.RetrofitClient
import com.example.mvvmsample.network.SafeApiRequest
import retrofit2.Response

class UserRepository(
    val retrofit: RetrofitClient

) : SafeApiRequest() {


    /*fun userLogin(email: String, password: String): LiveData<LoginResponse> {
        val loginResponse = MutableLiveData<LoginResponse>()

        val map = HashMap<String, String>()
        map.put("email", email)
        map.put("password", password)


        //val apiService = retrofit.retrofitInstance?.create(ApiCalls::class.java)
        val call = ApiCalls()?.login(map)
        call?.enqueue(object : Callback<LoginResponse> {
            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                loginResponse.postValue(response.body())
            }

            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                loginResponse.value = null
            }

        })

        return loginResponse
    }*/


    suspend fun userLogin(email: String, password: String):  LoginResponse {
        val map = HashMap<String, String>()
        map.put("email", email)
        map.put("password", password)

        return  apiRequest {
              ApiCalls()!!.login(map)
        }

    }
}