package com.lire.calendarview

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import java.util.*

class CalendarViewAdapter(private val data:List<BangumiMsg>):
    RecyclerView.Adapter<CalendarViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CalendarViewHolder {
        return CalendarViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: CalendarViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }

    companion object {
        fun createObjs() : List<BangumiMsg> {
            val lst = mutableListOf<BangumiMsg>()
            val ran = Random()
            repeat(10) {
                lst.add(BangumiMsg("qwq", "qwq", ran.nextInt(100), "qwq", 233.3))
            }
            return lst
        }
    }

}