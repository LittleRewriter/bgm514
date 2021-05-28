package com.lire.collectionview

import android.content.Context
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.lire.userinfo.UserCollection

class CollectionViewAdapter(private val data : List<UserCollection>, private val context : Context) : RecyclerView.Adapter<CollectionViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CollectionViewHolder {
        return CollectionViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: CollectionViewHolder, position: Int) {
        val item = data[position]
        holder.bind(item, context)

    }

    override fun getItemCount(): Int {
        return data.size
    }
}