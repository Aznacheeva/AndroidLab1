package com.example.lab1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView


class ItemAdapter : ListAdapter<Item, ItemAdapter.ViewHolder>(CardDiffCallback()) {

    class ViewHolder(var view: View) : RecyclerView.ViewHolder(view) {

        fun bind(item: Item) {
            when(item){
                is HeaderItem -> {
                    val text = view.findViewById<TextView>(R.id.subtitle)
                    text.text = item.header
                }
                is DataItem -> {
                    val icon = view.findViewById<ImageView>(R.id.data_icon)
                    val text = view.findViewById<TextView>(R.id.data_text)
                    text.text = item.header
                    icon.setImageDrawable(item.source)
                }
                is TariffItem -> {
                    val title = view.findViewById<TextView>(R.id.tariff_main_text)
                    val cost = view.findViewById<TextView>(R.id.tariff_cost)
                    val description = view.findViewById<TextView>(R.id.tariff_description)
                    title.text = item.title
                    cost.text = item.cost
                    description.text = item.description
                }
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = when(currentList[viewType]){
            is HeaderItem -> {
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.header_item_layout, parent, false)
            }
            is DataItem -> {
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.data_item_layout, parent, false)
            }
            else -> {
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.tariff_item_layout, parent, false)
            }

        }

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(currentList[position])
    }

}

class CardDiffCallback : DiffUtil.ItemCallback<Item>() {

    override fun areItemsTheSame(oldItem: Item, newItem: Item): Boolean = oldItem == newItem

    override fun areContentsTheSame(oldItem: Item, newItem: Item): Boolean = oldItem == newItem

}