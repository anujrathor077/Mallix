package com.example.mallix.MainScreens.mainpage1_module

import retrofit2.http.GET

interface ApiService {
    @GET("products")
    suspend fun getProducts(): List<Product>
}