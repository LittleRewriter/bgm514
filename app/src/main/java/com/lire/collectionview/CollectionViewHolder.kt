package com.lire.collectionview

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
import com.lire.userinfo.UserCollection

class CollectionViewHolder private constructor(itemView : View) : RecyclerView.ViewHolder(itemView){
    private val collectionPicture = itemView.findViewById<ImageView>(R.id.collectionPicture)
    private var collectionName = itemView.findViewById<TextView>(R.id.collectionName)
    private var collectionDoAmount = itemView.findViewById<TextView>(R.id.collectionDoAmount)

    fun bind(item : UserCollection, context : Context) {
        collectionName.text = item.name
        collectionDoAmount.text = String.format("在看：%d", item.doing)
        collectionPicture.load(item.images)
        itemView.setOnClickListener {
            val intent = Intent(context, SubjectActivity::class.java).apply {
                putExtra("targetID", item.id)
            }
            context.startActivity(intent)
        }
    }

    companion object {
        fun from(parent : ViewGroup) : CollectionViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val root = layoutInflater.inflate(R.layout.list_item_collection, parent, false)
            return CollectionViewHolder(root)
        }
    }
}