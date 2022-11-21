package com.example.donadela.components

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.donadela.LingerieActivity
import com.example.donadela.ProductsAndToys
import com.example.donadela.databinding.FragmentBottomBarBinding

class BottomBarFragment : Fragment(){

    private var _binding: FragmentBottomBarBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentBottomBarBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.iconShoppingBottom.setOnClickListener{
            val intent = Intent(requireContext(), ProductsAndToys::class.java)
            startActivity(intent)
        }
        binding.textShopping.setOnClickListener{
            val intent = Intent(requireContext(), ProductsAndToys::class.java)
            startActivity(intent)
        }
        binding.lingerieActive.setOnClickListener{
            val intent = Intent(requireContext(), LingerieActivity::class.java)
            startActivity(intent)
        }
        binding.lingerieText.setOnClickListener{
            val intent = Intent(requireContext(), LingerieActivity::class.java)
            startActivity(intent)
        }

        binding.productsBottomBar.visibility = View.INVISIBLE
        binding.lingerieActive.visibility = View.VISIBLE
    }
}