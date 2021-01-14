package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.myapplication.databinding.ItemGridLogoBinding

class GridLogoAdapter(private val listLogo: ArrayList<Logo>) : RecyclerView.Adapter<GridLogoAdapter.GridViewHolder>() {
    private var onItemClickCallback: GridLogoAdapter.OnItemClickCallback? = null
    fun setOnItemClickCallback(onItemClickCallback: GridLogoAdapter.OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): GridViewHolder {
        val binding = ItemGridLogoBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)
        return GridViewHolder(binding)

    }

    override fun onBindViewHolder(holder: GridViewHolder, position: Int) {
        holder.bind(listLogo[position])
    }

    override fun getItemCount(): Int = listLogo.size

    inner class GridViewHolder(private val binding: ItemGridLogoBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(logo: Logo) {
            with(binding){
                Glide.with(itemView.context)
                    .load(logo.brand_logo)
                    .apply(RequestOptions().override(350, 550))
                    .into(imgItemLogobrand)

                itemView.setOnClickListener { Toast.makeText(itemView.context, "Kamu memilih ${logo.brand_name}", Toast.LENGTH_SHORT).show() }
            }
        }
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: Logo)
    }

}