package com.lire.baseappearance

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.view.children
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.OrientationHelper
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.lire.baseappearance.databinding.FragmentTimelineBinding
import com.lire.calendarview.BangumiMsgManager
import com.lire.calendarview.CalendarViewAdapter
import com.lire.netdatahandler.CalendarJsonHandler
import com.lire.netdatahandler.testJson
import java.util.*

class TimelineFragment:Fragment() {

    private lateinit var binding : FragmentTimelineBinding

    fun getFirstDayOfWeek() : Calendar {
        val calendar = Calendar.getInstance()
        Log.d("TAG", calendar.toString())
        while(true) {
            if (calendar.get(Calendar.DAY_OF_WEEK) == 2)
                break
            calendar.add(Calendar.DATE, -1)
        }
//        Log.d("TAG", calendar.get(Calendar.MONTH).toString())
        calendar.get(Calendar.MONTH).toString()
        return calendar
    }

    fun getTargetString(id: Int) : String {
        when(id) {
            1 -> return getString(R.string.monday)
            2 -> return getString(R.string.tuesday)
            3 -> return getString(R.string.wednesday)
            4 -> return getString(R.string.thursday)
            5 -> return getString(R.string.friday)
            6 -> return getString(R.string.saturday)
            7 -> return getString(R.string.sunday)
            else -> return ""
        }
    }

    fun updateBottomName(firstDay : Calendar, adapter: CalendarViewAdapter) {
        with(binding) {
            val children : Sequence<View> = TimeTable.children
            var t = 1
            for ((idx, ele) in children.withIndex()) {
                val pattern = getTargetString(t)
                (ele as Button).text = String.format(pattern, firstDay.get(Calendar.MONTH)+1, firstDay.get(Calendar.DAY_OF_MONTH))
                (ele as Button).setOnClickListener {
                    adapter.resetData(BangumiMsgManager.getInstance().getMsgsForWeekDay(idx))
                }
                firstDay.add(Calendar.DATE, 1)
                ++t
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        binding = FragmentTimelineBinding.inflate(layoutInflater)
//        binding.week1.text = "qaq"
//        val root = inflater.inflate(R.layout.fragment_timeline, container, false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()

        val d = getFirstDayOfWeek()

        Log.d("TAG", getString(R.string.bangumi_calender_list_ranking))
//        binding.timelineRecycleView.layoutManager = LinearLayoutManager(this.context)
        // this is just for test

        var handler = CalendarJsonHandler(testJson)
        handler.parseJson()

        val adapter = CalendarViewAdapter(CalendarViewAdapter.createObjs())
        binding.timelineRecycleView.layoutManager = StaggeredGridLayoutManager(2, OrientationHelper.VERTICAL)
        binding.timelineRecycleView.adapter = adapter

        updateBottomName(d, adapter)

    }
}