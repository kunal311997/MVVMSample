package com.example.mvvmsample.di

import com.example.mvvmsample.data.repositories.UserRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class AppModule(val repository: UserRepository) {

    @Singleton
    @Provides
    fun provideRepository(): UserRepository {
        return repository
    }

}
