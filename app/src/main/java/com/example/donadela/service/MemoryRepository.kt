package com.example.donadela.service

import com.example.donadela.R
import com.example.donadela.model.Product
import com.example.donadela.repository.ProductRepository

object MemoryRepository : ProductRepository {

    private var nextId = 1L
    private val productsList = mutableListOf<Product>()

    init {
        save(
            Product(
                0,
                R.drawable.ling01,
                "Product 01",
                "Product linda para apimentar as coisas",
                "R$29,90",
            )
        )
        save(
            Product(
                0,
                R.drawable.ling02,
                "Product 02",
                "Product linda para apimentar as coisas",
                "R$29,90"
            )
        )
        save(
            Product(
                0,
                R.drawable.lin03,
                "Product 03",
                "Product linda para apimentar as coisas",
                "R$29,90"
            )
        )
        save(
            Product(
                0,
                R.drawable.ling04,
                "Product sexy preta",
                "Product linda para apimentar as coisas",
                "R$29,90"
            )
        )
    }

    override fun save(product: Product) {
        if (product.id == 0L) {
            product.id = nextId++
            productsList.add(product)
        } else {
            val index = productsList.indexOfFirst { it.id == product.id }
            if (index > -1) {
                productsList[index] = product
            } else {
                productsList.add(product)
            }
        }
    }

    override fun remove(vararg products: Product) {
        productsList.removeAll(products)
    }

    override fun productById(id: Long, callback: (Product?) -> Unit) {
        callback(productsList.find { it.id == id })
    }

    override fun search(term: String, callback: (List<Product>) -> Unit) {
        callback(
            if (term.isEmpty()) productsList
            else productsList.filter {
                it.name.uppercase().contains(term.uppercase())
            }
        )
    }

}