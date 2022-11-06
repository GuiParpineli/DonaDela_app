package com.example.donadela

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.donadela.R.layout.products_and_toys

class ProductsAndToys : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(products_and_toys)
        supportActionBar!!.hide()

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