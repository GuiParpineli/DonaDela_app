package com.example.donadela

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.donadela.R.layout.products_list
import com.example.donadela.adapter.AdapterLingerie
import com.example.donadela.model.Lingerie

class LingerieActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(products_list)
        supportActionBar!!.hide()

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

        val recyclerviewLingerie = findViewById<RecyclerView>(R.id.list_lingerie_products)
        recyclerviewLingerie.layoutManager = LinearLayoutManager(this)
        recyclerviewLingerie.setHasFixedSize(true)

        val listLingerie: MutableList<Lingerie> = mutableListOf()
        val adapterLingerie = AdapterLingerie(this, listLingerie)
        recyclerviewLingerie.adapter = adapterLingerie

        val lingerie1 = Lingerie(
            R.drawable.ling01, "Lingerie 01",
            "Lingerie linda para apimentar as coisas",
            "R$29,90",
        )
        val lingerie2 = Lingerie(
            R.drawable.ling02, "Lingerie 02",
            "Lingerie linda para apimentar as coisas",
            "R$29,90"
        )
        val lingerie3 = Lingerie(
            R.drawable.lin03, "Lingerie 03",
            "Lingerie linda para apimentar as coisas",
            "R$29,90"
        )
        val lingerie4 = Lingerie(
            R.drawable.ling04, "Lingerie sexy preta",
            "Lingerie linda para apimentar as coisas",
            "R$29,90"
        )

        listLingerie.add(lingerie1)
        listLingerie.add(lingerie2)
        listLingerie.add(lingerie3)
        listLingerie.add(lingerie4)
        listLingerie.add(lingerie4)

        adapterLingerie.onItemClick = { lingeries ->
            val item =
                Lingerie(lingeries.image, lingeries.name, lingeries.description, lingeries.price)
            Log.d("TAG", item.toString())
            val intent = Intent(this, ProductDetails::class.java)
            intent.putExtra("item", item)
            startActivity(intent)
        }
    }
}