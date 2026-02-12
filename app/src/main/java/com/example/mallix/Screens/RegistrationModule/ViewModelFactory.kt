package com.example.mallix.Screens.RegistrationModule



import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mallix.data.SharedPrefManager
import com.example.mallix.viewmodel.UserViewModel

class UserViewModelFactory(
    private val context: Context
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(UserViewModel::class.java)) {
            val prefs = SharedPrefManager(context)
            return UserViewModel(prefs) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}