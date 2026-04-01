package com.example.mallix.MainScreens.mainpage1_module

import com.example.mallix.ProductItem
import com.example.mallix.R
class Repository {

    private val api = RetrofitClient.api

    suspend fun getProducts(): List<ProductApi> {
        return api.getProducts()
    }
}