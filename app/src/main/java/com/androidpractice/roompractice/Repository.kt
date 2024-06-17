package com.androidpractice.roompractice

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.androidpractice.roompractice.roomdatabase.Product
import com.androidpractice.roompractice.roomdatabase.ProductDao
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class Repository(val productDao: ProductDao) {
    val searchResults = MutableLiveData<List<Product>>()
    private val coroutineScope = CoroutineScope(Dispatchers.Main)

    fun insertProduct(newProduct: Product) {
        coroutineScope.launch(Dispatchers.IO) {
            productDao.insertProduct(newProduct)
        }
    }

    fun deleteProduct(name: String) {
        coroutineScope.launch(Dispatchers.IO) {
            productDao.deleteProduct(name)
        }
    }

    fun findProduct(name: String)  {
        coroutineScope.launch(Dispatchers.Main) {
            searchResults.value = asyncFind(name).await()
        }
    }

    private fun asyncFind(name: String ): Deferred<List<Product>> =
    coroutineScope.async(Dispatchers.IO) {
        return@async productDao.findProduct(name)
    }

    fun getAllProducts(): LiveData<List<Product>> {
        return productDao.getAllProducts()
    }



}