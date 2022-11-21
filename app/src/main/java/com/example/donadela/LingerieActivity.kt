package com.example.donadela

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.PersistableBundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.SearchView
import androidx.appcompat.app.AppCompatActivity
import com.example.donadela.R.layout.lingerie_activity
import com.example.donadela.components.BottomBarFragment
import com.example.donadela.components.ProductDetailsFragment
import com.example.donadela.components.ProductListFragment
import com.example.donadela.model.Product

class LingerieActivity : AppCompatActivity(), ProductListFragment.OnProductClickListener,
    SearchView.OnQueryTextListener, MenuItem.OnActionExpandListener {

    private var lastSearchTerm: String = ""
    private var searchView: SearchView? = null

    private val listFragment: ProductListFragment by lazy {
        supportFragmentManager.findFragmentById(R.id.fragmentList) as ProductListFragment
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(lingerie_activity)
        supportFragmentManager.findFragmentById(R.id.bottom_bar) as BottomBarFragment
    }

    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        super.onSaveInstanceState(outState, outPersistentState)
        outState.putString(EXTRA_SEARCH_TERM, lastSearchTerm)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        lastSearchTerm = savedInstanceState.getString(EXTRA_SEARCH_TERM) ?: ""
    }

    override fun onProductClick(product: Product) {
        if (isTablet()) {
            showDetailsFragment(product.id!!)
        } else {
            showDetailsActivity(product.id!!)
        }
    }

    private fun isTablet() = findViewById<View>(R.id.details) != null

    private fun showDetailsFragment(productId: Long) {
        searchView?.setOnQueryTextListener(null)
        val fragment = ProductDetailsFragment.newInstance(productId)
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.details, fragment, ProductDetailsFragment.TAG_DETAILS)
            .commit()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.donadela, menu)
        val searchItem = menu?.findItem(R.id.action_search)
        searchItem?.setOnActionExpandListener(this)
        searchView = searchItem?.actionView as SearchView
        searchView?.queryHint = getString(R.string.hint_search)
        searchView?.setOnQueryTextListener(this)
        if (lastSearchTerm.isNotEmpty()) {
             Handler(Looper.getMainLooper()).postDelayed({
                val query = lastSearchTerm
                searchItem.expandActionView()
                searchView?.setQuery(query, true)
                searchView?.clearFocus()
            }, 3000)
        }
        return true
    }

    override fun onQueryTextSubmit(query: String?) = true

    override fun onQueryTextChange(newText: String?): Boolean {
        lastSearchTerm = newText ?: ""
        listFragment.search(lastSearchTerm)
        return true
    }

    private fun showDetailsActivity(productId: Long) {
        ProductDetails.open(this, productId)
    }

    override fun onMenuItemActionExpand(p0: MenuItem?) = true

    override fun onMenuItemActionCollapse(p0: MenuItem?): Boolean {
        lastSearchTerm = ""
        listFragment.clearSearch()
        return true
    }

    companion object{
        const val EXTRA_SEARCH_TERM = "lastSearch"
    }
}