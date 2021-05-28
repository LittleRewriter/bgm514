package com.lire.searchview

import android.content.Context
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class SearchViewAdapter(private var data : List<SearchResult>, private val context : Context) : RecyclerView.Adapter<SearchViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        return SearchViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        val item = data[position]
        holder.bind(item, context)
    }

    override fun getItemCount(): Int {
        return data.size
    }


}