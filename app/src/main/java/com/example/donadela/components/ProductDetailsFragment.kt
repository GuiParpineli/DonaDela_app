package com.example.donadela.components

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.example.donadela.R
import com.example.donadela.databinding.ProductsDetailsBinding
import com.example.donadela.model.Product
import com.example.donadela.service.MemoryRepository
import com.example.donadela.view.ProductsDetailsView
import com.example.donadela.view.impl.ProductDetailsPresenter

class ProductDetailsFragment : Fragment(), ProductsDetailsView {

    private val presenter = ProductDetailsPresenter(this, MemoryRepository)
    private var product: Product? = null
    private var _binding: ProductsDetailsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = ProductsDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.loadProductDetails(arguments?.getLong(EXTRA_PRODUCT_ID, -1) ?: -1)
    }

    override fun showProductsDetails(product: Product) {
        this.product = product
        val image = product.image
        val items = intArrayOf(image, R.drawable.ling02)
        var index = 0

        val imageSwitcher = binding.imageProductDetails

        imageSwitcher.setFactory {
            val imgView = ImageView(requireContext())
            imgView.scaleType = ImageView.ScaleType.FIT_CENTER
            imgView
        }

        imageSwitcher.setImageResource(items[index])

        binding.textNameOfProduct.text = product.name
        binding.textDescription.text = product.description
    }

    override fun errorProductNotFound() {
        binding.imageProductDetails.visibility = View.GONE
        binding.textNameOfProduct.text = "Produto não encontrado"
        binding.textDescription.visibility = View.GONE
    }

    companion object{
        const val  TAG_DETAILS = "tagDetalhe"
        private const val EXTRA_PRODUCT_ID = "productId"


        fun newInstance(id: Long) = ProductDetailsFragment().apply {
            arguments = Bundle().apply {
                putLong(EXTRA_PRODUCT_ID, id)
            }
        }
    }
}