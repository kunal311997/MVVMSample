package com.example.mvvmsample.network

import android.util.Log
import com.example.mvvmsample.Utils.ApiException
import org.json.JSONException
import org.json.JSONObject
import retrofit2.Response

abstract class SafeApiRequest {
    suspend fun <T : Any> apiRequest(call: suspend () -> Response<T>): T {

        try {
            val response = call.invoke()
            if (response.isSuccessful) {
                return response.body()!!
            } else {
                val error = response.errorBody()?.string()
                Log.e("errorbody2", response.errorBody()?.string())
                val message = StringBuilder()
                error.let {
                    try {
                        message.append(JSONObject(it.toString()).get("message"))
                    } catch (e: JSONException) {
                    }
                    message.append("\n")
                }
                message.append("Error Code :" + response.code())
                throw ApiException(message.toString())
            }
        } catch (e: Exception) {
        }
        throw ApiException("Something went wrong.")
    }
}