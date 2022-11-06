package com.example.donadela

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageSwitcher
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.example.donadela.R.layout.products_details
import com.example.donadela.model.Lingerie
import java.io.Serializable

class ProductDetails : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(products_details)
        supportActionBar!!.hide()

        val goLingeries = findViewById<ImageView>(R.id.icon_lingerie)
        val goLingeriestxt = findViewById<TextView>(R.id.lingerie_text)
        val productsBar = findViewById<ImageView>(R.id.icon_shopping_bottom)
        val textShopping = findViewById<TextView>(R.id.text_shopping)

        productsBar.setOnClickListener {
            val intent = Intent(this, ProductsAndToys::class.java)
            startActivity(intent)
        }
        textShopping.setOnClickListener {
            val intent = Intent(this, ProductsAndToys::class.java)
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

        val text = findViewById<TextView>(R.id.text_name_of_product)

        val lingerie = intent.getParcelableExtra<Lingerie>("item")

        text.text = lingerie?.name.toString()
        val image = lingerie!!.image

        val items = intArrayOf(image, R.drawable.ling02)
        var index = 0

        val imageSwitcher = findViewById<ImageSwitcher>(R.id.image_product_details)

        imageSwitcher.setFactory {
            val imgView = ImageView(applicationContext)
            imgView.scaleType = ImageView.ScaleType.FIT_CENTER
            imgView
        }

        imageSwitcher?.setImageResource(items[index])

        val btnPrev = findViewById<Button>(R.id.btn_prev_image)
        val btnNext = findViewById<Button>(R.id.btn_nex_image)

        val imgIn = AnimationUtils.loadAnimation(
            this, android.R.anim.slide_in_left
        )
        imageSwitcher?.inAnimation = imgIn

        val imgOut = AnimationUtils.loadAnimation(
            this, android.R.anim.slide_out_right
        )
        imageSwitcher?.outAnimation = imgOut

        btnPrev.setOnClickListener {
            index = if (index - 1 >= 0) index - 1 else items.size -1
            imageSwitcher?.setImageResource(items[index])
        }

        btnNext.setOnClickListener {
            index = if (index + 1 < items.size) index + 1 else 0
            imageSwitcher?.setImageResource(items[index])
        }

    }
}