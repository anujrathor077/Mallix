package com.example.mallix.MainScreens.mainpage1_module

class Repository {
    suspend fun getProducts(): List<Product> {
        return RetrofitInstance.api.getProducts()
    }
}