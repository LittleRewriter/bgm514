package com.lire.calendarview

import android.content.res.Resources
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.lire.baseappearance.R

class CalendarViewHolder private constructor(itemView : View)
    : RecyclerView.ViewHolder(itemView){
    private val bangumiPic = itemView.findViewById<ImageView>(R.id.bangumiPicture)
    private val bangumiName = itemView.findViewById<TextView>(R.id.bangumiName)
    private val bangumiRank = itemView.findViewById<TextView>(R.id.bangumiRank)

    fun bind(item : BangumiMsg) {
        bangumiName.text = item.bangumiName
//        bangumiRank.text = Resources.getSystem().getString(R.string.bangumi_calender_list_ranking, item.avgScore.toString(), item.ranking.toString())
        bangumiRank.text = "qwq"
    }

    companion object {
        fun from(parent : ViewGroup) : CalendarViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val root = layoutInflater.inflate(R.layout.list_item_nama, parent, false)
            return CalendarViewHolder(root)
        }
    }

}