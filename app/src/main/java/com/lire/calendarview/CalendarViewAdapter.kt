package com.lire.calendarview

import android.content.Context
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import java.util.*

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

    fun resetData(data : List<BangumiMsg>) {
        this.data = data
        notifyDataSetChanged()
    }

    companion object {
        fun createObjs() : List<BangumiMsg> {
            val lst = mutableListOf<BangumiMsg>()
            val ran = Random()
            repeat(10) {
                lst.add(BangumiMsg("qwq", "qwq", "qwq", ran.nextInt(100), "qwq", 233.3))
            }
            return lst
        }
    }

}