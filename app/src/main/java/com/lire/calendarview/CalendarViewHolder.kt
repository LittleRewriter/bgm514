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
import coil.load
import com.lire.baseappearance.R
import com.lire.baseappearance.SubjectActivity

/**
 * RecycleView的Holder
 *
 */

class CalendarViewHolder private constructor(itemView : View)
    : RecyclerView.ViewHolder(itemView){

    // 图片
    private val bangumiPic = itemView.findViewById<ImageView>(R.id.bangumiPicture)
    // 名称
    private val bangumiName = itemView.findViewById<TextView>(R.id.bangumiName)
    // 排名
    private val bangumiRank = itemView.findViewById<TextView>(R.id.bangumiRank)

    /**
     * 将数据类进行绑定
     *
     * @param item 数据
     * @param context context
     */

    fun bind(item : BangumiMsg, context: Context) {
        bangumiName.text = item.bangumiName
        bangumiRank.text = "均分：${item.avgScore}  在看：${item.collection}"
        bangumiPic.load(item.picURL)
        itemView.setOnClickListener {
            val intent = Intent(context, SubjectActivity::class.java).apply {
                putExtra("targetID", item.id)
            }
            context.startActivity(intent)
        }

    }

    companion object {
        fun from(parent : ViewGroup) : CalendarViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val root = layoutInflater.inflate(R.layout.list_item_nama, parent, false)
            return CalendarViewHolder(root)
        }
    }

}