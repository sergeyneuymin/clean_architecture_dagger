package com.example.cleanarchitecture.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.cleanarchitecture.data.repository.UserRepositoryImpl
import com.example.cleanarchitecture.data.storage.sharedprefs.SharedPrefUserStorage
import com.example.cleanarchitecture.domain.models.SaveUsernameParam
import com.example.cleanarchitecture.domain.models.Username
import com.example.cleanarchitecture.domain.usecase.GetUsernameUsecase
import com.example.cleanarchitecture.domain.usecase.SaveUsernameUsecase

class MainViewModel(private val getUsernameUsecase:GetUsernameUsecase,
                    private val saveUsernameUsecase:SaveUsernameUsecase) : ViewModel() {

    private val resultLiveMutable = MutableLiveData<String>()
    val resultLive: LiveData<String> = resultLiveMutable

    init {
        Log.e("AAA", "vm created")
    }

    fun save(text: String) {
        val params = SaveUsernameParam(name = text)
        val result: Boolean = saveUsernameUsecase.execute(param = params)
        resultLiveMutable.value = "Save text = $result"
    }

    fun load() {
        val username: Username = getUsernameUsecase.execute()
        resultLiveMutable.value = "${username.firstName} ${username.lastName}"
    }

    override fun onCleared() {
        Log.e("AAA", "vm cleared")
        super.onCleared()
    }

}