package com.example.donadela

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.donadela.R.layout.lingerie_activity
import com.example.donadela.R.layout.products_list
import com.example.donadela.components.ProductListFragment
import com.example.donadela.model.Product

class LingerieActivity : AppCompatActivity(), ProductListFragment.OnProductClickListener {

    private val listFragment: ProductListFragment by lazy {
        supportFragmentManager.findFragmentById(R.id.fragmentList) as ProductListFragment
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(lingerie_activity)
        supportActionBar!!.hide()

/*
        val produtcsBar = findViewById<ImageView>(R.id.icon_shopping_bottom)
        val textShopping = findViewById<TextView>(R.id.text_shopping)

        produtcsBar.setOnClickListener {
            val intent = Intent(this, ProductsAndToys::class.java)
            startActivity(intent)
        }
        textShopping.setOnClickListener {
            val intent = Intent(this, ProductsAndToys::class.java)
            startActivity(intent)
        }
*/

    }

    override fun onProductClick(product: Product) {
        showDetailsActivity(product.id!!)
    }
    
    private fun showDetailsActivity(productId: Long){
        ProductDetails.open(this, productId)
    }
}