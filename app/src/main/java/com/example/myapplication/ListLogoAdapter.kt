package com.example.myapplication

import android.R
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputBinding
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.myapplication.databinding.ItemRowLogoBinding

class ListLogoAdapter (private val listLogo: ArrayList<Logo>) : RecyclerView.Adapter<ListLogoAdapter.ListViewHolder>() {
    private var onItemClickCallback: OnItemClickCallback? = null
    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }
    class ListViewHolder(private val binding: ItemRowLogoBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(logo: Logo) {
            with(binding) {
                Glide.with(itemView.context)
                    .load(logo.brand_logo)
                    .apply(RequestOptions().override(50, 50))
                    .into(imgItemLogobrand)
//                imgItemLogobrand.setImageResource(logo.brand_logo)
                Log.d("TAG","$logo ")
                tvItemNameBrand.text = logo.brand_name
                tvItemDescription.text = logo.brand_description

                itemView.setOnClickListener { Toast.makeText(itemView.context, "Kamu memilih ${logo.brand_name}", Toast.LENGTH_SHORT).show() }

            }
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ListViewHolder {
        val binding = ItemRowLogoBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)

        return ListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {

        Log.d("TAG","$position")
        holder.bind(listLogo[position])
    }

    override fun getItemCount(): Int = listLogo.size

    interface OnItemClickCallback {
        fun onItemClicked(data: Logo)
    }

}