package com.example.cleanarchitecture.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.cleanarchitecture.domain.usecase.GetUsernameUsecase
import com.example.cleanarchitecture.domain.usecase.SaveUsernameUsecase
import javax.inject.Inject

class MainViewModelFactory @Inject constructor(val getUsernameUsecase: GetUsernameUsecase,
                                               val saveUsernameUsecase: SaveUsernameUsecase
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(
            getUsernameUsecase = getUsernameUsecase,
            saveUsernameUsecase = saveUsernameUsecase
        ) as T
    }

}