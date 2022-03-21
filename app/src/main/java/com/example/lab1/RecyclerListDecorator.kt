package com.example.lab1

import android.graphics.Canvas
import android.graphics.Rect
import android.graphics.drawable.Drawable
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.children
import androidx.recyclerview.widget.RecyclerView


class RecyclerListDecorator(private val items: List<Item>, private val divider: Drawable) :
    RecyclerView.ItemDecoration() {

    private val dividerWidth = divider.intrinsicWidth
    private val dividerHeight = divider.intrinsicHeight

    override fun getItemOffsets(rect: Rect, v: View, parent: RecyclerView, s: RecyclerView.State) {
        parent.adapter?.let { adapter ->
            val childAdapterPosition = parent.getChildAdapterPosition(v)
                .let { if (it == RecyclerView.NO_POSITION) return else it }
            rect.bottom =
                if (childAdapterPosition == adapter.itemCount - 1) 0
                else dividerHeight
        }
    }

    override fun onDraw(canvas: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        super.onDraw(canvas, parent, state)
        parent.adapter?.let { adapter ->
            parent.children
                .forEach { view ->
                    val childAdapterPosition = parent.getChildAdapterPosition(view)
                        .let { if (it == RecyclerView.NO_POSITION) return else it }
                    if (childAdapterPosition != adapter.itemCount - 1 &&
                        childAdapterPosition != 0 &&
                        isItemsSame(childAdapterPosition, childAdapterPosition + 1)
                    ) {
                        val left = 120
                        val top = view.bottom
                        val right = left + dividerWidth
                        val bottom = view.bottom + dividerHeight
                        divider.bounds = Rect(left, top, right, bottom)
                        divider.draw(canvas)
                    }
                }
        }
    }

    private fun isItemsSame(firstElementPosition: Int, SecondElementPosition: Int): Boolean {
        when (items[firstElementPosition]) {
            is HeaderItem -> {
                if (items[SecondElementPosition] is HeaderItem)
                    return true
            }
            is DataItem -> {
                if (items[SecondElementPosition] is DataItem)
                    return true
            }
            is TariffItem -> {
                if (items[SecondElementPosition] is TariffItem)
                    return true
            }
        }
        return false
    }
}