package com.example.lab1.controllers

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.lab1.R
import com.example.lab1.entities.DataItem
import com.example.lab1.entities.HeaderItem
import com.example.lab1.entities.Item
import com.example.lab1.entities.TariffItem


class ItemAdapter : ListAdapter<Item, ItemAdapter.ViewHolder>(CardDiffCallback()) {

    class ViewHolder(private var view: View) : RecyclerView.ViewHolder(view) {

        fun bind(item: Item) = when (item) {
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

    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = when (currentList[viewType]) {
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