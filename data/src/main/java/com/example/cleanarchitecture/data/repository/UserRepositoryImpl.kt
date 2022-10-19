package com.example.cleanarchitecture.data.repository

import com.example.cleanarchitecture.data.storage.UserStorage
import com.example.cleanarchitecture.data.storage.models.User
import com.example.cleanarchitecture.domain.models.SaveUsernameParam
import com.example.cleanarchitecture.domain.models.Username
import com.example.cleanarchitecture.domain.repository.UserRepository


class UserRepositoryImpl(private val userStorage: UserStorage) : UserRepository {

    override fun saveName(saveUsernameParam: SaveUsernameParam): Boolean {

        val user = mapToStorage(saveUsernameParam)
        return userStorage.save(user)
    }

    override fun getName() : Username {

        val user = userStorage.get()
        return mapToDomain(user)
    }

    private fun mapToStorage(saveUsernameParam: SaveUsernameParam) : User {
        return User(firstName = saveUsernameParam.name, lastName = "")
    }

    private fun mapToDomain(user: User) : Username {
        return Username(firstName = user.firstName, lastName = user.lastName)
    }
}