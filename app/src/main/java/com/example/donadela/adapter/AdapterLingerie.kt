package com.example.donadela.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.donadela.R
import com.example.donadela.model.Lingerie

class AdapterLingerie(private val context: Context, private val lingeries: MutableList<Lingerie>) :
    RecyclerView.Adapter<AdapterLingerie.LingerieViewHolder>() {

    inner class LingerieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image = itemView.findViewById<ImageView>(R.id.image_product)
        val name = itemView.findViewById<TextView>(R.id.name_product)
        val description = itemView.findViewById<TextView>(R.id.product_description)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LingerieViewHolder {
        val itemList = LayoutInflater.from(context).inflate(R.layout.lingerie_item, parent, false)
        val holder = LingerieViewHolder(itemList)
        return holder
    }

    override fun onBindViewHolder(holder: LingerieViewHolder, position: Int) {
        holder.image.setImageResource(lingeries[position].image)
        holder.name.text = lingeries[position].name
        holder.description.text = lingeries[position].description
    }

    override fun getItemCount(): Int = lingeries.size
}