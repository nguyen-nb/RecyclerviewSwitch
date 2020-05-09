package com.sau.recyclerviewswitch

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.simple_item.view.*

class SimpleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    constructor(parent: ViewGroup)
            : this(LayoutInflater.from(parent.context).inflate(R.layout.simple_item, parent, false))

    fun bind() {

        with(itemView) {
            val resourceId: Int = itemView.context.resources.getIdentifier(
                "img$adapterPosition",
                "drawable",
                "com.sau.recyclerviewswitch"
            )
            image.setImageResource(resourceId)

            title.text = "title $adapterPosition"
            description.text = "description $adapterPosition"
        }
    }
}