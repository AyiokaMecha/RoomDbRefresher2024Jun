package com.androidpractice.roompractice

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.androidpractice.roompractice.roomdatabase.Product
import com.androidpractice.roompractice.roomdatabase.ProductRoomDatabase

class MainViewModel(application: Application): ViewModel() {
    val allProducts: LiveData<List<Product>>
    private val repository: Repository
    val searchResults: MutableLiveData<List<Product>>

    init {
        val productDb = ProductRoomDatabase.getInstance(application)
        val productDao = productDb.productDao()
        repository = Repository(productDao)
        allProducts = repository.getAllProducts()
        searchResults = repository.searchResults

    }

    fun insertProduct(product: Product) {
        repository.insertProduct(product)
    }

    fun findProduct(name: String) {
        repository.findProduct(name)
    }

    fun deleteProduct(name: String) {
        repository.deleteProduct(name)
    }
}