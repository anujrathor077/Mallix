package com.example.mallix.MyBag.CheckoutViewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue


class CheckoutViewModel : ViewModel() {

    // 🔹 User Address Info
    var fullName by mutableStateOf("")
        private set

    var address by mutableStateOf("")
        private set

    var city by mutableStateOf("")
        private set

    var state by mutableStateOf("")
        private set

    var zipCode by mutableStateOf("")
        private set


    // 🔹 Price Info
    var orderPrice by mutableStateOf(112)
        private set

    var deliveryPrice by mutableStateOf(15)
        private set


    // 🔹 Update Functions (Best Practice)

    fun updateFullName(value: String) {
        fullName = value
    }

    fun updateAddress(value: String) {
        address = value
    }

    fun updateCity(value: String) {
        city = value
    }

    fun updateState(value: String) {
        state = value
    }

    fun updateZipCode(value: String) {
        zipCode = value
    }


    fun updateOrderPrice(value: Int) {
        orderPrice = value
    }

    fun updateDeliveryPrice(value: Int) {
        deliveryPrice = value
    }


    // 🔹 Total Price
    fun totalPrice(): Int {
        return orderPrice + deliveryPrice
    }
}
