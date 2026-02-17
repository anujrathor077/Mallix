package com.example.mallix



data class ProductItem(
    val id: Int,
    val image: Int,      // drawable
    val brand: String,
    val title: String,
    val price: Double,   // Double (important)
    val size: String = "M",

    val oldPrice: String = "",
    val rating: Int,
    val reviewCount: Int = 0,
    val discount: String? = null,
    val isSoldOut: Boolean = false
)

data class CartItem(
    val id: Int,
    val title: String,
    val image: Int,      // drawable
    val price: Double,   // Double
    val size: String,
    val quantity: Int = 1
)
