package com.example.mvvmsample.di

import com.example.mvvmsample.activities.LoginActivity
import com.example.mvvmsample.activities.MainActivity
import com.example.mvvmsample.data.repositories.UserRepository
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {

    fun inject(loginActivity: LoginActivity)

}
