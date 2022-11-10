package com.example.donadela

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.donadela.R.id.button_lingerie
import com.example.donadela.R.id.button_products

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar!!.hide()

        val btnProducts = findViewById<Button>(button_products)
        val btnLingerie = findViewById<Button>(button_lingerie)

        btnProducts.setOnClickListener {
            val intent = Intent(this, ProductsAndToys::class.java)
            startActivity(intent)
        }

        btnLingerie.setOnClickListener {
            val intent = Intent(this, LingerieActivity::class.java)
            startActivity(intent)
        }
    }
}
