package com.example.mallix.MainScreens.mainpage1_module

import com.example.mallix.ProductItem
import com.google.android.gms.analytics.ecommerce.Product
import retrofit2.http.GET

interface ApiService {
    @GET("products")
    suspend fun getProducts(): List<ProductApi>
}