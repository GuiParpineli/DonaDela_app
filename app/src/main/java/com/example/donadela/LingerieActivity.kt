package com.example.donadela

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.donadela.R.layout.lingeries
import com.example.donadela.adapter.AdapterLingerie
import com.example.donadela.model.Lingerie

class LingerieActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(lingeries)
        supportActionBar!!.hide()

        val recyclerView_lingerie = findViewById<RecyclerView>(R.id.list_lingerie_products)
        recyclerView_lingerie.layoutManager = LinearLayoutManager(this)
        recyclerView_lingerie.setHasFixedSize(true)

        val listLingerie: MutableList<Lingerie> = mutableListOf()
        val adapterLingerie = AdapterLingerie(this, listLingerie)
        recyclerView_lingerie.adapter = adapterLingerie

        val lingerie1 = Lingerie(
            R.drawable.ling01, "Lingerie sexy preta",
            "Lingerie linda para apimentar as coisas",
            "R$29,90"
        )
        val lingerie2 = Lingerie(
            R.drawable.ling02, "Lingerie sexy preta",
            "Lingerie linda para apimentar as coisas",
            "R$29,90"
        )
        val lingerie3 = Lingerie(
            R.drawable.lin03, "Lingerie sexy preta",
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

    }
}