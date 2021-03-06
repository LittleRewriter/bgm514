package com.lire.baseappearance

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.view.children
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.OrientationHelper
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.lire.baseappearance.databinding.FragmentTimelineBinding
import com.lire.calendarview.BangumiMsgManager
import com.lire.calendarview.CalendarViewAdapter
import com.lire.netdatahandler.CalendarJsonHandler
import com.lire.restful.BgmAPI
import com.lire.restful.BgmDataViewModel
import com.lire.restful.BgmDataViewModelFactory
import com.lire.restful.BgmRepositoryImpl
import java.util.*

/**
 * 每日放送的Fragment相关代码
 * @author lire
 *
 */

class TimelineFragment:Fragment() {

    private lateinit var binding : FragmentTimelineBinding
    private lateinit var bgmViewModel : BgmDataViewModel
    private var selectedDate : Int = 0

    /**
     * 获取每一周的第一天是哪一天
     * @return 第一天
     */

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

    /**
     * 获取Button中的String
     *
     * @param id 第几天
     * @return 对应的字符串
     */

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

    /**
     * 更新Button的名字，并设置当前的选择
     *
     * @param firstDay 第一天
     * @param adapter 用于RecyclerView更新
     */

    fun updateBottomName(firstDay : Calendar, adapter: CalendarViewAdapter) {
        with(binding) {
            val children : Sequence<View> = TimeTable.children
            var t = 1
            // 对每一个按钮进行遍历
            for ((idx, ele) in children.withIndex()) {
                val pattern = getTargetString(t)
                (ele as Button).text = String.format(pattern, firstDay.get(Calendar.MONTH)+1, firstDay.get(Calendar.DAY_OF_MONTH))
                // 设置点击事件
                ele.setOnClickListener {
                    if (idx != selectedDate) {
                        selectedDate = idx
                        adapter.resetData(BangumiMsgManager.getInstance().getMsgsForWeekDay(idx))
                    }
                }
                // 获取当前按钮
                if (firstDay.get(Calendar.DAY_OF_MONTH) == Calendar.getInstance().get(Calendar.DAY_OF_MONTH)) {
                    TimeTable.check(ele.id)
                    selectedDate = idx
                    binding.timetableBtnGroupScroll.post {
                        binding.timetableBtnGroupScroll.scrollTo(ele.left, ele.top)
                    }
                }
                firstDay.add(Calendar.DATE, 1)
                ++t
            }
        }
    }

    /**
     * View Create时的事件，初始化Binding
     *
     */

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {


        binding = FragmentTimelineBinding.inflate(layoutInflater)
//        binding.week1.text = "qaq"
//        val root = inflater.inflate(R.layout.fragment_timeline, container, false)
        return binding.root
    }

    /**
     * 完成各种初始化
     *
     */

    override fun onStart() {
        super.onStart()

        val d = getFirstDayOfWeek()

//        Log.d("TAG", getString(R.string.bangumi_calender_list_ranking))
        bgmViewModel = ViewModelProvider(requireActivity(), BgmDataViewModelFactory(
        BgmRepositoryImpl(BgmAPI.service))).get(BgmDataViewModel::class.java)
//        binding.timelineRecycleView.layoutManager = LinearLayoutManager(this.context)
        // this is just for test
        val adapter = CalendarViewAdapter(CalendarViewAdapter.createObjs(), requireContext())
        binding.timelineRecycleView.layoutManager = StaggeredGridLayoutManager(2, OrientationHelper.VERTICAL)
        binding.timelineRecycleView.adapter = adapter

        updateBottomName(d, adapter)

        bgmViewModel.loadCalendarAsync()
        bgmViewModel.calendar.observe(this, {
            val handler = CalendarJsonHandler(it)
            handler.parseJson()
            adapter.resetData(BangumiMsgManager.getInstance().getMsgsForWeekDay(day=((Calendar.getInstance().get(Calendar.DAY_OF_WEEK))+5)%7))
        })
    }
}