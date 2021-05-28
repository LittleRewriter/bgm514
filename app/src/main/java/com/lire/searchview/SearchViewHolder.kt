package com.lire.searchview

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.lire.baseappearance.R
import com.lire.baseappearance.SubjectActivity
import com.lire.subject.SubjectInfo

class SearchViewHolder private constructor(itemView : View) : RecyclerView.ViewHolder(itemView){
    private val searchPicture = itemView.findViewById<ImageView>(R.id.searchPicture)
    private var searchName = itemView.findViewById<TextView>(R.id.searchName)
    private var searchType = itemView.findViewById<TextView>(R.id.searchType)

    fun bind(item : SearchResult, context : Context) {
        searchName.text = item.name
        searchType.text = item.type
        searchPicture.load(item.imgUrl)
        itemView.setOnClickListener {
            val intent = Intent(context, SubjectActivity::class.java).apply {
                putExtra("targetID", item.id)
            }
            context.startActivity(intent)
        }
    }

    companion object {
        fun from(parent : ViewGroup) : SearchViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val root = layoutInflater.inflate(R.layout.list_item_search, parent, false)
            return SearchViewHolder(root)
        }
    }
}