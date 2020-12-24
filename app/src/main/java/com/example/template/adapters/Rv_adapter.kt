package com.example.template.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.example.template.repository.API.BrawlerModel
import com.example.template.R

/**
 * Created by Mehul Bisht on 22-12-2020
 */

class rv_adapter(val context: Context, val brawlerItemList: ArrayList<BrawlerModel>) :
    RecyclerView.Adapter<rv_adapter.ItemViewHolder>() {

    inner class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val icon: ImageView = itemView.findViewById(R.id.brawlerIcon)
        val name: TextView = itemView.findViewById(R.id.name)
        val rarity: TextView = itemView.findViewById(R.id.rarity)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val viewHolder = ItemViewHolder(
            LayoutInflater.from(context)
            .inflate(R.layout.rv_item, parent, false)
        )

        return viewHolder
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val currentBrawler = brawlerItemList[position]
        holder.name.text = currentBrawler.name
        holder.rarity.text = currentBrawler.rarity

        Glide.with(context).setDefaultRequestOptions(
            RequestOptions()
                .placeholder(R.drawable.ic_launcher_foreground)
                .error(R.drawable.ic_launcher_foreground)
                .diskCacheStrategy(DiskCacheStrategy.DATA))
            .load(currentBrawler.imageUrl)
            .into(holder.icon)
    }

    override fun getItemCount(): Int {
        return brawlerItemList.size
    }
}