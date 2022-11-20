package com.example.donadela.components

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.donadela.R
import com.example.donadela.adapter.AdapterLingerie
import com.example.donadela.databinding.ProductsDetailsBinding
import com.example.donadela.databinding.ProductsListBinding
import com.example.donadela.model.Product
import com.example.donadela.service.MemoryRepository
import com.example.donadela.view.ProductsListView
import com.example.donadela.view.impl.ProductListPresenter

class ProductListFragment : Fragment(), ProductsListView {
    private val presenter = ProductListPresenter(this, MemoryRepository)
    private var listProduct: MutableList<Product> = mutableListOf()
    private var _binding: ProductsListBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter.searchProducts("")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = ProductsListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recyclerView = requireView().findViewById<RecyclerView>(R.id.list_lingerie_products)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.setHasFixedSize(true)
        val adapter = AdapterLingerie(requireContext(),listProduct)
        recyclerView.adapter = adapter

        adapter.onItemClick = { listProduct ->
            val item  = Product(listProduct.id, listProduct.image, listProduct.name, listProduct.description, listProduct.price)
            presenter.showProductDetails(item)
        }
    }


    override fun showProducts(products: List<Product>) {
        listProduct = products as MutableList<Product>
    }

    override fun showProductDetails(product: Product) {
        if (activity is OnProductClickListener) {
            val listener = activity as OnProductClickListener
            listener.onProductClick(product)
        }
    }

    interface OnProductClickListener {
        fun onProductClick(product: Product)
    }

    fun clearSearch() {
    }

}