package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_my_view_model.*

class MyViewModel : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_view_model)
        supportActionBar?.title = "My View Model Module"

        setMyButtonEnable()

        my_edit_text.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
            }
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                setMyButtonEnable()
            }
            override fun afterTextChanged(s: Editable) {
            }
        })
        my_button.setOnClickListener { Toast.makeText(this@MyViewModel, my_edit_text.text, Toast.LENGTH_SHORT).show() }
    }


    private fun setMyButtonEnable() {
        val result = my_edit_text.text
        my_button.isEnabled = result != null && result.toString().isNotEmpty()
    }
}