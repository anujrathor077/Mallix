package com.example.mallix.MainScreens.mainpage1_module

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
class AllViewModel : ViewModel() {

    private val repository = Repository()

    private val _products = MutableStateFlow<List<Product>>(emptyList())
    val products = _products.asStateFlow()

    private val _selectedProduct = MutableStateFlow<Product?>(null)
    val selectedProduct = _selectedProduct.asStateFlow()

    // ⭐ AUTO LOAD PRODUCTS
    init {
        fetchAll()
    }

    fun selectProduct(product: Product) {
        _selectedProduct.value = product
    }

     fun fetchAll() {
        viewModelScope.launch {
            _products.value = repository.getProducts()
        }
    }
}