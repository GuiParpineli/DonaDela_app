package com.example.donadela

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.donadela.R.id.button_products

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnProducts = findViewById<Button>(button_products)

        btnProducts.setOnClickListener {
            val intent = Intent(this, ProductsAndToys::class.java)
            startActivity(intent)
        }
    }
}