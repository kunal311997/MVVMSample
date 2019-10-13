package com.example.mvvmsample.activities

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.Observable
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.mvvmsample.R
import com.example.mvvmsample.data.repositories.UserRepository
import com.example.mvvmsample.databinding.ActivityLoginBinding


class LoginActivity : AppCompatActivity() {


    lateinit var viewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val repository = UserRepository()
        val factory = LoginViewModelFactory(repository)

        val binding: ActivityLoginBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_login)
        viewModel = ViewModelProviders.of(this, factory).get(LoginViewModel::class.java)

        binding.viewmodel = viewModel
        setObservers()

    }

    private fun setObservers() {

        viewModel.loginResult.observe(this, Observer {
            if (it != null)
                Log.e("Main", it.toString())
        })

        viewModel.loginForm.observe(this, Observer {
            if (it != null)
                Log.e("error", it.toString())
        })
    }
}