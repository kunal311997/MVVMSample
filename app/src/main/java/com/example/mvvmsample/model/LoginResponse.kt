package com.example.mvvmsample.model

data class LoginResponse(
    val code: Int?,
    val message: String?,
    val result: Result?
)

data class Result(
    val active: Int,
    val countryCode: String,
    val date: String,
    val email: String,
    val forgot_token: String,
    val geotag: String,
    val id: Int,
    val is_admin: Int,
    val is_principle: Int,
    val login_otp: String,
    val name: String,
    val ngo: String,
    val ngo_id: Int,
    val password: String,
    val phone: String,
    val pwd_time: String,
    val roleid: Int,
    val student_uid: String,
    val temp_pwd: String,
    val token: String,
    val typeUser: Int,
    val user_id: Int
)