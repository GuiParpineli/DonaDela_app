package com.example.donadela.repository

import com.example.donadela.model.Product

interface ProductRepository {
    fun save(product: Product)
    fun remove(vararg products: Product)
    fun productById(id: Long, callback: (Product?) -> Unit)
    fun search(term: String, callback: (List<Product>) -> Unit)
}