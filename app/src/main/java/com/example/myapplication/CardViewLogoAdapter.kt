package com.example.myapplication

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.myapplication.databinding.ItemCardviewLogoBinding

class CardViewLogoAdapter (private val listLogo: ArrayList<Logo>) : RecyclerView.Adapter<CardViewLogoAdapter.CardViewViewHolder>() {
    private var onItemClickCallback: CardViewLogoAdapter.OnItemClickCallback? = null
    fun setOnItemClickCallback(onItemClickCallback: CardViewLogoAdapter.OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }
    inner class CardViewViewHolder (private val binding: ItemCardviewLogoBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(logo: Logo) {
            with(binding) {
                Glide.with(itemView.context)
                        .load(logo.brand_logo)
                        .apply(RequestOptions().override(350, 550))
                        .into(imgItemLogobrand)
                tvItemNameBrand.text = logo.brand_name
                tvItemDescription.text = logo.brand_description
                btnSetFavorite.setOnClickListener { Toast.makeText(itemView.context, "Favorite ${logo.brand_name}", Toast.LENGTH_SHORT).show() }
                btnSetShare.setOnClickListener { Toast.makeText(itemView.context, "Share ${logo.brand_name}", Toast.LENGTH_SHORT).show() }
                itemView.setOnClickListener { Toast.makeText(itemView.context, "Kamu memilih ${logo.brand_name}", Toast.LENGTH_SHORT).show() }

            }
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): CardViewViewHolder {
        val binding = ItemCardviewLogoBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)
        return CardViewViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CardViewViewHolder, position: Int) {
        holder.bind(listLogo[position])
    }

    override fun getItemCount(): Int = listLogo.size

    interface OnItemClickCallback {
        fun onItemClicked(data: Logo)
    }


}