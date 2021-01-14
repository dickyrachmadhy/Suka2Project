package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.example.myapplication.databinding.ActivityMyActionBarBinding

class MyActionBar : AppCompatActivity() {
    private lateinit var binding: ActivityMyActionBarBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_action_bar)
        supportActionBar?.title = "Modul 2 : MyActionBar"
        binding = ActivityMyActionBarBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.options_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu1 -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, MenuFragment())
                    .addToBackStack(null)
                    .commit()
                return true
            }
            R.id.menu2 -> {
                val i = Intent(this, MenuActivity::class.java)
                startActivity(i)
                return true
            }
            else -> return true
        }
    }
}