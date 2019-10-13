package com.example.mvvmsample.network

import com.example.mvvmsample.constants.ServerConstants
import com.example.mvvmsample.model.LoginResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiCalls {

    @POST(ServerConstants.LOGIN)
    fun login(
        @Body map: HashMap<String, String>
    ): Call<LoginResponse>
}