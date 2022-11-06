package com.example.donadela

import android.os.Build
import android.os.Bundle
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.example.donadela.R.layout.products_details
import com.example.donadela.model.Lingerie

class Product_details : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(products_details)
        supportActionBar!!.hide()

        val text = findViewById<TextView>(R.id.text_details)
        val name = intent.getStringExtra("name")
        val lingerie = intent.getParcelableExtra("item",Lingerie::class.java)
        text.text = lingerie?.name.toString()
    }
}