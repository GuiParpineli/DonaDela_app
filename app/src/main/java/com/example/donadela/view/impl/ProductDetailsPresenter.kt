package com.example.donadela.view.impl

import com.example.donadela.repository.ProductRepository
import com.example.donadela.view.ProductsDetailsView

class ProductDetailsPresenter(
    private val view: ProductsDetailsView,
    private val repository: ProductRepository
) {
    fun loadProductDetails(id: Long) {
        repository.productById(id) { product ->
            if (product != null) {
                view.showProductsDetails(product)
            } else {
                view.errorProductNotFound()
            }
        }
    }
}