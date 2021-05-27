package com.lire.calendarview

import android.content.Context
import android.content.Intent
import android.content.res.Resources
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.lire.baseappearance.R
import com.lire.baseappearance.SubjectActivity

class CalendarViewHolder private constructor(itemView : View)
    : RecyclerView.ViewHolder(itemView){
    private val bangumiPic = itemView.findViewById<ImageView>(R.id.bangumiPicture)
    private val bangumiName = itemView.findViewById<TextView>(R.id.bangumiName)
    private val bangumiRank = itemView.findViewById<TextView>(R.id.bangumiRank)

    fun bind(item : BangumiMsg, context: Context) {
        bangumiName.text = item.bangumiName
//        Log.d("TAG", "after")
//        Log.d("TAG", Resources.getSystem().getString(R.string.bangumi_calender_list_ranking))
        bangumiRank.text = "均分：${item.avgScore}  在看：${item.collection}"

        itemView.setOnClickListener {
            val intent = Intent(context, SubjectActivity::class.java).apply {
                putExtra("targetID", item.id)
            }
            context.startActivity(intent)
        }
//        bangumiRank.text = Resources.getSystem().getString(R.string.bangumi_calender_list_ranking, item.avgScore.toString(), item.collection.toString())
//        bangumiRank.text = "qwq"

    }

    companion object {
        fun from(parent : ViewGroup) : CalendarViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val root = layoutInflater.inflate(R.layout.list_item_nama, parent, false)
            return CalendarViewHolder(root)
        }
    }

}