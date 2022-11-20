package com.example.donadela.view

import com.example.donadela.model.Product

interface ProductsDetailsView {
    fun showProductsDetails(product: Product)
    fun errorProductNotFound()
}