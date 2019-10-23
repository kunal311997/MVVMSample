package com.example.mvvmsample

import android.app.Application
import com.example.mvvmsample.data.repositories.UserRepository
import com.example.mvvmsample.di.AppComponent
import com.example.mvvmsample.di.AppModule
import com.example.mvvmsample.di.DaggerAppComponent

class MVVMApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        component = DaggerAppComponent.builder().appModule(AppModule(UserRepository())).build()
    }

    companion object {
        lateinit var component: AppComponent
    }

}
