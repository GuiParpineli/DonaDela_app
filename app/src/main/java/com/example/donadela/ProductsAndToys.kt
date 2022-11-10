package com.example.donadela

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.donadela.R.layout.products_and_toys

class ProductsAndToys : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(products_and_toys)
        supportActionBar!!.hide()

        val oral = findViewById<Button>(R.id.item1)
        val analProducts = findViewById<Button>(R.id.item2)
        val gelsProducts = findViewById<Button>(R.id.item3)
        val accessoriesProducts = findViewById<Button>(R.id.item4)

        oral.setOnClickListener {
            val intent = Intent(this, OralProducts::class.java)
            startActivity(intent)
        }

        analProducts.setOnClickListener{
            val intent = Intent(this, AnalProducts::class.java)
            startActivity(intent)
        }

        gelsProducts.setOnClickListener {
            val intent = Intent(this, GelsProducts::class.java)
            startActivity(intent)
        }

        accessoriesProducts.setOnClickListener {
            val intent = Intent(this, AccessoriesProducts::class.java)
            startActivity(intent)
        }

        val goLingeries = findViewById<ImageView>(R.id.icon_lingerie)
        val goLingeriestxt = findViewById<TextView>(R.id.lingerie_text)

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