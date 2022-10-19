package com.example.cleanarchitecture.data.storage.sharedprefs

import android.content.Context
import com.example.cleanarchitecture.data.storage.UserStorage
import com.example.cleanarchitecture.data.storage.models.User

private const val SHARED_PREFS_NAME = "shared preferences name"
private const val KEY_FIRSTNAME = "firstname"
private const val KEY_LASTNAME = "lastname"
private const val DEFAULT_FIRSTNAME = "default firstname"
private const val DEFAULT_LASTNAME = "default lastname"

class SharedPrefUserStorage(context: Context): UserStorage {

    private val sharedPreferences = context.getSharedPreferences(SHARED_PREFS_NAME, Context.MODE_PRIVATE)

    override fun save(user: User): Boolean {
        sharedPreferences.edit().putString(KEY_FIRSTNAME,user.firstName).apply()
        sharedPreferences.edit().putString(KEY_LASTNAME,user.lastName).apply()
        return true
    }

    override fun get(): User {
        val firstname = sharedPreferences.getString(KEY_FIRSTNAME, DEFAULT_FIRSTNAME) ?: DEFAULT_FIRSTNAME
        val lastname = sharedPreferences.getString(KEY_LASTNAME, DEFAULT_LASTNAME) ?: DEFAULT_LASTNAME
        return User(firstName = firstname, lastName = lastname)
    }
}