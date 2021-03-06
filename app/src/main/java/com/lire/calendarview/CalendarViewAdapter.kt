package com.lire.calendarview

import android.content.Context
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import java.util.*

/**
 * Calendar的View Apater
 *
 * @property data 数据
 * @property context 绑定到的context
 */

class CalendarViewAdapter(private var data:List<BangumiMsg>, private val context : Context):
    RecyclerView.Adapter<CalendarViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CalendarViewHolder {

        return CalendarViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: CalendarViewHolder, position: Int) {
        holder.bind(data[position], context)

    }

    override fun getItemCount(): Int {
        return data.size
    }

    /**
     * 重新设定data
     *
     * @param data 数据
     */

    fun resetData(data : List<BangumiMsg>) {
        this.data = data
        notifyDataSetChanged()
    }

    companion object {
        fun createObjs() : List<BangumiMsg> {
            val lst = mutableListOf<BangumiMsg>()
            return lst
        }
    }

}