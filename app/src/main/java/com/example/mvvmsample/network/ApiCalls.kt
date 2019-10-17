package com.example.mvvmsample.network

import com.example.mvvmsample.constants.ServerConstants
import com.example.mvvmsample.model.LoginResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiCalls {

    @POST(ServerConstants.LOGIN)
    suspend fun login(
        @Body map: HashMap<String, String>
    ): Response<LoginResponse>

    companion object {
        operator fun invoke(): ApiCalls? {
            return RetrofitClient.retrofitInstance?.create(ApiCalls::class.java)
        }
    }

}