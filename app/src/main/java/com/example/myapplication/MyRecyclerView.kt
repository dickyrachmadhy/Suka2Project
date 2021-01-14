package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.databinding.ActivityMyRecyclerViewBinding

class MyRecyclerView : AppCompatActivity() {
    private lateinit var binding: ActivityMyRecyclerViewBinding
    private var title = "Mode List Brand Biznet"
    private val list = ArrayList<Logo>()
    private var mode: Int = 0

    companion object {
        private const val STATE_TITLE = "state_string"
        private const val STATE_LIST = "state_list"
        private const val STATE_MODE = "state_mode"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        supportActionBar?.title = "My Recycler View Module"
        binding = ActivityMyRecyclerViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvLogos.setHasFixedSize(true)

        if (savedInstanceState == null) {
            setActionBarTitle(title)
            list.addAll(getListLogos())
            showRecyclerList()
            mode = R.id.action_list
        } else {
            title = savedInstanceState.getString(STATE_TITLE).toString()
            val stateList = savedInstanceState.getParcelableArrayList<Logo>(STATE_LIST)
            val stateMode = savedInstanceState.getInt(STATE_MODE)

            setActionBarTitle(title)
            if (stateList != null) {
                list.addAll(stateList)
            }
            setMode(stateMode)
        }
    }

    private fun setActionBarTitle(title: String) {
        supportActionBar?.title = title
    }

    private fun showSelectedLogo(logo: Logo){
        Toast.makeText(this, "Kamu memilih ${logo.brand_name}", Toast.LENGTH_SHORT).show()
    }


    private fun getListLogos(): ArrayList<Logo> {
        val dataNameBrand = resources.getStringArray(R.array.data_name_logos)
        val dataDescriptionBrand = resources.getStringArray(R.array.data_description_logos)
        val dataLogoBrand = resources.getStringArray(R.array.data_logo_brand)


        val listLogo = ArrayList<Logo>()
        for (position in dataNameBrand.indices) {
            val logo = Logo(
                dataNameBrand[position],
                dataDescriptionBrand[position],
                dataLogoBrand[position]
            )
            listLogo.add(logo)
        }
        return listLogo
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(STATE_TITLE, title)
        outState.putParcelableArrayList(STATE_LIST, list)
        outState.putInt(STATE_MODE, mode)
    }

    private fun showRecyclerList() {
        binding.rvLogos.layoutManager = LinearLayoutManager(this)
        val listLogoAdapter = ListLogoAdapter(list)
        binding.rvLogos.adapter = listLogoAdapter

        listLogoAdapter.setOnItemClickCallback(object : ListLogoAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Logo) {
                showSelectedLogo(data)
            }
        })
    }

    private fun showRecyclerGrid() {
        binding.rvLogos.layoutManager = GridLayoutManager(this, 2)
        val gridLogoAdapter = GridLogoAdapter(list)
        binding.rvLogos.adapter = gridLogoAdapter

        gridLogoAdapter.setOnItemClickCallback(object : GridLogoAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Logo) {
                showSelectedLogo(data)
            }
        })
    }

    private fun showRecyclerCardView() {
        binding.rvLogos.layoutManager = LinearLayoutManager(this)
        val cardViewLogoAdapter = CardViewLogoAdapter(list)
        binding.rvLogos.adapter = cardViewLogoAdapter

        cardViewLogoAdapter.setOnItemClickCallback(object : CardViewLogoAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Logo) {
                showSelectedLogo(data)
            }
        })
    }


//    BUAT MENU
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        setMode(item.itemId)
        return super.onOptionsItemSelected(item)
    }
    private fun setMode(selectedMode: Int) {
        when (selectedMode) {
            R.id.action_list -> {
                title = "Mode List Brand Biznet"
                showRecyclerList()
            }
            R.id.action_grid -> {
                title = "Mode Grid Brand Biznet"
                showRecyclerGrid()
            }
            R.id.action_cardview -> {
                title = "Mode CardView Brand Biznet"
                showRecyclerCardView()
            }
        }
        mode = selectedMode
        setActionBarTitle(title)
    }
}