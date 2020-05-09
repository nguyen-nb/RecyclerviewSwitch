package com.sau.recyclerviewswitch

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class SimpleAdapter() : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var type = ViewType.LIST

    enum class ViewType {
        LIST,
        SMALL,
        BIG
    }

    fun getType(): Int {
        return type.ordinal
    }

    fun switchType(_newType: Int) {
        type = when (_newType) {
            ViewType.LIST.ordinal -> ViewType.LIST
            ViewType.SMALL.ordinal -> ViewType.SMALL
            else -> ViewType.BIG
        }
        notifyItemRangeChanged(0, itemCount)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            ViewType.LIST.ordinal ->
                DetailedViewHolder(parent)
            else ->
                SimpleViewHolder(parent)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, p1: Int) {
        if (holder is DetailedViewHolder) holder.bind()
        else (holder as SimpleViewHolder).bind()
    }

    override fun getItemCount() = 5

    override fun getItemViewType(position: Int) = when (type) {
        ViewType.LIST -> ViewType.LIST.ordinal
        ViewType.SMALL -> ViewType.SMALL.ordinal
        else -> ViewType.BIG.ordinal
    }
}