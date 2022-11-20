package com.example.donadela.view

import com.example.donadela.model.Product

interface ProductsListView {
    fun showProducts(products: List<Product>)
    fun showProductDetails(product: Product)
}