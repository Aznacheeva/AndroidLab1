package com.example.lab1.controllers

import androidx.recyclerview.widget.DiffUtil
import com.example.lab1.entities.Item

class CardDiffCallback : DiffUtil.ItemCallback<Item>() {

    override fun areItemsTheSame(oldItem: Item, newItem: Item): Boolean = (oldItem == newItem)

    override fun areContentsTheSame(oldItem: Item, newItem: Item): Boolean = (oldItem == newItem)

}