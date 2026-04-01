package com.example.mallix.MainScreens.mainpage1_module



data class ProductApi(
    val id: Int,
    val title: String,
    val price: Double,
    val image: String
)


data class Rating(
    val rate: Double,
    val count: Int
)


