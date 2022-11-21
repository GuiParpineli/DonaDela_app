package com.example.donadela.model

data class Product(
    var id: Long?,
    val image: Int = 0,
    val name: String = "",
    val description: String = "",
    val price: String = ""
) {
    override fun toString(): String = this.name
}
