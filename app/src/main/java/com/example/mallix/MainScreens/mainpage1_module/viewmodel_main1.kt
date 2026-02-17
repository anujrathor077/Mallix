package com.example.mallix.MainScreens.mainpage1_module

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mallix.CartItem
import com.example.mallix.ProductItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class AllViewModel : ViewModel() {

    private val repository = Repository()

    // ================= PRODUCTS =================

    private val _products = MutableStateFlow<List<ProductItem>>(emptyList())
    val products = _products.asStateFlow()

    private val _selectedProduct = MutableStateFlow<ProductItem?>(null)
    val selectedProduct = _selectedProduct.asStateFlow()

    // ================= CART =================

    private val _cartList = MutableStateFlow<List<CartItem>>(emptyList())
    val cartList = _cartList.asStateFlow()

    // ================= ADDRESS =================

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

    // ================= PRICE =================

    var deliveryPrice by mutableStateOf(15)
        private set

    val orderPrice: Double
        get() = _cartList.value.sumOf {
            it.price * it.quantity
        }

    val totalPrice: Double
        get() = orderPrice + deliveryPrice


    // ================= INIT =================

    init {
        fetchAll()
    }

    // ================= PRODUCTS =================

    fun fetchAll() {
        viewModelScope.launch {
            _products.value = repository.getProducts()
        }
    }

    fun selectProduct(product: ProductItem) {
        _selectedProduct.value = product
    }

    // ================= CART =================

    fun addToCart(item: CartItem) {

        val list = _cartList.value.toMutableList()

        val index = list.indexOfFirst {
            it.id == item.id && it.size == item.size
        }

        if (index != -1) {

            val oldItem = list[index]

            list[index] = oldItem.copy(
                quantity = oldItem.quantity + 1
            )

        } else {
            list.add(item)
        }

        _cartList.value = list
    }

    fun increaseQty(item: CartItem) {

        _cartList.value = _cartList.value.map {

            if (it.id == item.id && it.size == item.size)
                it.copy(quantity = it.quantity + 1)
            else it
        }
    }

    fun decreaseQty(item: CartItem) {

        _cartList.value = _cartList.value.mapNotNull {

            if (it.id == item.id && it.size == item.size) {

                if (it.quantity > 1)
                    it.copy(quantity = it.quantity - 1)
                else null

            } else it
        }
    }

    fun removeFromCart(item: CartItem) {

        _cartList.value = _cartList.value.filter {

            it.id != item.id || it.size != item.size
        }
    }

    // ================= ADDRESS =================

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

}
