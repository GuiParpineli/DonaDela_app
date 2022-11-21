package com.example.donadela.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.donadela.R
import com.example.donadela.model.Product

class AdapterLingerie(private val context: Context, private val lingeries: MutableList<Product>) :
    RecyclerView.Adapter<AdapterLingerie.LingerieViewHolder>() {

    var onItemClick: ((Product) -> Unit)? = null

    inner class LingerieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image = itemView.findViewById<ImageView>(R.id.image_product)!!
        val name: TextView = itemView.findViewById(R.id.name_product)
        val description: TextView = itemView.findViewById(R.id.product_description)

        init {
            itemView.setOnClickListener{
                onItemClick?.invoke(lingeries[adapterPosition])
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LingerieViewHolder {
        val itemList = LayoutInflater.from(context).inflate(R.layout.lingerie_item, parent, false)
        return LingerieViewHolder(itemList)
    }



    override fun onBindViewHolder(holder: LingerieViewHolder, position: Int) {
        holder.image.setImageResource(lingeries[position].image)
        holder.name.text = lingeries[position].name
        holder.description.text = lingeries[position].description
    }

    override fun getItemCount(): Int = lingeries.size

}