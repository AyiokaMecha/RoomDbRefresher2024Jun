package com.androidpractice.roompractice.roomdatabase

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ProductDao {
    @Insert
    fun insertProduct(product: Product)

    @Query("SELECT * FROM products WHERE productName = :name")
    fun findProduct(name: String):List<Product>

    @Query("DELETE FROM products WHERE productName = :name")
    fun deleteProduct(name: String)

    @Query("SELECT * FROM products")
    fun getAllProducts(): LiveData<List<Product>>

}

@Dao
interface SupplierDao {
    @Insert
    fun insertSuppier(supplier: Supplier)

    @Query("SELECT * FROM supplier WHERE supplier_name = :name")
    fun findSupplier(name: String):List<Product>

    @Query("DELETE FROM supplier WHERE supplier_name = :name")
    fun deleteSupplier(name: String)

    @Query("SELECT * FROM supplier")
    fun getAllSuppliers(): LiveData<Supplier>

}