package com.example.mallix.MainScreens.mainpage1_module

import com.example.mallix.ProductItem
import com.example.mallix.R

class Repository {

    suspend fun getProducts(): List<ProductItem> {

        return listOf(

            ProductItem(
                id = 1,
                image = R.drawable.eveningdress,
                brand = "Zara",
                title = "Short Dress",
                price = 1999.0,
                size = "M",
                rating = 4
            ),

            ProductItem(
                id = 2,
                image = R.drawable.eveningdress,
                brand = "H&M",
                title = "Party Dress",
                price = 2499.0,
                size = "L",
                rating = 5
            ),

            ProductItem(
                id = 3,
                image = R.drawable.eveningdress,
                brand = "Forever21",
                title = "Casual Dress",
                price = 1799.0,
                size = "S",
                rating = 4
            )
        )
    }
}
