package com.example.mallix.viewmodel

import androidx.lifecycle.ViewModel
import com.example.mallix.data.SharedPrefManager

class UserViewModel(
    private val prefs: SharedPrefManager
) : ViewModel() {

    fun saveUser(name: String, email: String, password: String): Boolean {
        if (name.isBlank() || email.isBlank() || password.isBlank()) {
            return false
        }

        prefs.name = name
        prefs.email = email
        prefs.password = password
        return true
    }

    fun getUsername(): String {
        return prefs.name ?: ""
    }

    fun getEmail(): String {
        return prefs.email ?: ""
    }

    fun logout() {
        prefs.clear()
    }
}