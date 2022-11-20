package com.example.donadela

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.donadela.R.layout.activity_product_details
import com.example.donadela.components.ProductDetailsFragment

class ProductDetails : AppCompatActivity() {

    private val productId: Long by lazy { intent.getLongExtra(EXTRA_PRODUCT_ID, -1) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activity_product_details)
        supportActionBar!!.hide()
        if (savedInstanceState == null) {
            showProductDetailsFragment()
        }
    }

    private fun showProductDetailsFragment() {
        val fragment = ProductDetailsFragment.newInstance(productId)
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.details, fragment, ProductDetailsFragment.TAG_DETAILS)
            .commit()
    }

    companion object {
        private const val EXTRA_PRODUCT_ID = "product_id"
        fun open(context: Context, productId: Long) {
            context.startActivity(Intent(
                context,
                ProductDetails::class.java
            ).apply {
                putExtra(EXTRA_PRODUCT_ID, productId)
            })
        }
    }
}