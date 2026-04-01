package com.example.mallix



data class ProductItem(
    val id: Int,
    val image: Any,   // ✅ Int se String kar diya
    val brand: String,
    val title: String,
    val price: Double,
    val size: String = "M",
    val oldPrice: String = "",
    val rating: Int,     // ye bhi fix kar diya
    val reviewCount: Int = 0,
    val discount: String? = null,
    val isSoldOut: Boolean = false
)
data class CartItem(
    val id: Int,
    val title: String,
    val image: Any,      // drawable
    val price: Double,   // Double
    val size: String,
    val quantity: Int = 1
)
