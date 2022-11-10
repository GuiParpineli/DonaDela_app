package com.example.donadela

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class AccessoriesProducts : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.products_list)
        supportActionBar!!.hide()

        val productsIcon = findViewById<View>(R.id.products_bottom_bar)
        val roupaIntima = findViewById<View>(R.id.lingerie_active)
        val goLingeries = findViewById<ImageView>(R.id.icon_lingerie)
        val goLingeriestxt = findViewById<TextView>(R.id.lingerie_text)

        productsIcon.setVisibility(View.VISIBLE)
        roupaIntima.setVisibility(View.INVISIBLE)

        productsIcon.setOnClickListener {
            val intent = Intent(this, ProductsAndToys::class.java)
            startActivity(intent)
        }
        goLingeries.setOnClickListener {
            val intent = Intent(this, LingerieActivity::class.java)
            startActivity(intent)
        }
        goLingeries.setOnClickListener {
            val intent = Intent(this, LingerieActivity::class.java)
            startActivity(intent)
        }
        goLingeriestxt.setOnClickListener {
            val intent = Intent(this, LingerieActivity::class.java)
            startActivity(intent)
        }
    }
}