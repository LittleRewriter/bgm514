package com.lire.calendarview

/**
 * Bangumi信息的管理类（单例）
 * 可能写这个类的时候忘了Object的存在...
 *
 */

class BangumiMsgManager private constructor(){
    private val dayBangumiMsg = List(7){
        mutableListOf<BangumiMsg>()
    }

    /**
     * @param day 星期几的编号，星期一是0
     * @return 某一天的番剧信息
     */

    fun getMsgsForWeekDay(day : Int) : MutableList<BangumiMsg> {
        return dayBangumiMsg[day]
    }

    /**
     * 用来添加日期
     * @param day 星期几的编号，星期一是0
     * @param msg 番剧信息
     */

    fun addMsgForWeekDay(day : Int, msg : BangumiMsg) {
        dayBangumiMsg[day].add(msg)
    }

    companion object {
        val manager = BangumiMsgManager()
        fun getInstance() : BangumiMsgManager {
            return manager
        }
    }
}