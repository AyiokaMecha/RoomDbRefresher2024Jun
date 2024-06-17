package com.androidpractice.roompractice.roomdatabase

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey


@Entity(tableName = "products")
class Product {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "productId")
    var id: Int = 0

    @ColumnInfo(name = "productName")
    var productName: String = ""


    var quantity: Int = 0

    constructor()
    constructor(productName: String, quantity: Int) {
        this.productName = productName
        this.quantity = quantity
    }

}

@Entity(
    tableName = "supplier",
    foreignKeys = [
        ForeignKey(
            entity = Product::class,
            parentColumns = ["id"],
            childColumns = ["product_id"],
            onUpdate = ForeignKey.CASCADE,
            onDelete = ForeignKey.SET_NULL
        )
    ]
)
data class Supplier(
    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "supplier_id")
    val id: Int = 0,
    val supplier_name: String,
    val product_id: Int
)