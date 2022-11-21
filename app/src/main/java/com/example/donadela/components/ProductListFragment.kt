package com.example.donadela.components

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.donadela.adapter.AdapterLingerie
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
        presenter.searchProducts("")
    }

    override fun showProducts(products: List<Product>) {
        listProduct.addAll(products)
        _binding!!.listLingerieProducts.layoutManager = LinearLayoutManager(requireContext())
        val adapter = AdapterLingerie(requireView().context, products as MutableList<Product>)
        _binding?.listLingerieProducts?.adapter = adapter
        adapter.onItemClick = { listProduct ->
            val item = Product(
                listProduct.id,
                listProduct.image,
                listProduct.name,
                listProduct.description,
                listProduct.price
            )
            presenter.showProductDetails(item)
        }
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

    fun search(text: String){
        presenter.searchProducts(text)
    }

    fun clearSearch() {
        presenter.searchProducts("")
    }

}