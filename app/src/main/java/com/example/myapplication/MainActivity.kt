package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.title = "Modul 2 Application UI dan UX"

        btn_MyViewModel.setOnClickListener{
            val movePageMyViewModel = Intent (this@MainActivity, MyViewModel::class.java)
            startActivity(movePageMyViewModel)
        }

        btn_MyRecyclerView.setOnClickListener{
            val movePageMyRecyclerView = Intent (this@MainActivity, MyRecyclerView::class.java)
            startActivity(movePageMyRecyclerView)
        }

        btn_MyNavigation.setOnClickListener{
            val movePageMyNavigation = Intent (this@MainActivity, MyNavigation::class.java)
            startActivity(movePageMyNavigation)
        }

        btn_MyActionBar.setOnClickListener{
            val movePageMyActionBar = Intent (this@MainActivity, MyActionBar::class.java)
            startActivity(movePageMyActionBar)
        }
    }
}