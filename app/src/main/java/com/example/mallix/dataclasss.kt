package com.example.mallix

data class ProductItem(
    val image: Int,
    val brand: String,
    val title: String,
    val price: String,
    val oldPrice: String = "",
    val rating: Int,
    val reviewCount: Int = 0,
    val discount: String? = null,
    val isSoldOut: Boolean = false
)
