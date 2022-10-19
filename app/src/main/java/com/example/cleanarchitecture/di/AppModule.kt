package com.example.cleanarchitecture.di

import android.content.Context
import com.example.cleanarchitecture.domain.usecase.GetUsernameUsecase
import com.example.cleanarchitecture.domain.usecase.SaveUsernameUsecase
import com.example.cleanarchitecture.presentation.MainViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class AppModule(val context: Context) {

    @Provides
    fun provideContext():Context {
        return context
    }

    @Provides
    fun provideMainViewModelFactory(getUsernameUsecase: GetUsernameUsecase,
    saveUsernameUsecase: SaveUsernameUsecase) :MainViewModelFactory {
        return MainViewModelFactory(getUsernameUsecase,saveUsernameUsecase)
    }

}