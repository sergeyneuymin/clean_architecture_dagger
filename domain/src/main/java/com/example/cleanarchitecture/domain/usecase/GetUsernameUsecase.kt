package com.example.cleanarchitecture.domain.usecase

import com.example.cleanarchitecture.domain.models.Username
import com.example.cleanarchitecture.domain.repository.UserRepository
import javax.inject.Inject

class GetUsernameUsecase @Inject constructor(val userRepository: UserRepository) {

    fun execute() : Username {
        return userRepository.getName()
    }

}