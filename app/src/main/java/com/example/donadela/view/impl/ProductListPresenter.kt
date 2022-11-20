package com.example.donadela.view.impl

import com.example.donadela.model.Product
import com.example.donadela.repository.ProductRepository
import com.example.donadela.view.ProductsListView

class ProductListPresenter(
    private val view: ProductsListView,
    private val repository: ProductRepository
) {

    fun searchProducts(term: String) {
        repository.search(term) { products ->
            view.showProducts(products)
        }
    }

    fun showProductDetails(product: Product) {
        view.showProductDetails(product)
    }

}