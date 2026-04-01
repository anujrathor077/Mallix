package com.example.mallix

import com.example.mallix.MainScreens.mainpage1_module.ProductApi

fun ProductApi.toProductItem(): ProductItem {
    return ProductItem(
        id = id,
        image = this.image,
        brand = "Zara",
        title = title,
        price = price,
        rating = 4
    )
}
