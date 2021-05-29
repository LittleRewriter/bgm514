package com.lire.netdatahandler

import com.google.gson.JsonParser
import com.lire.userinfo.UserInfo
import com.lire.utils.getAsNullableJsonObject
import com.lire.utils.getAsNullableString
import java.lang.Exception

/**
 * User Info
 *
 * @property JSONStr JsonStr
 */

class UserInfoJsonParser(val JSONStr : String) {
    fun parseJson() : UserInfo? {
        try {
            val obj = JsonParser.parseString(JSONStr).getAsNullableJsonObject()
            if (obj?.get("code")?.getAsNullableString()?:"" == "404") return null
            val nickName = obj?.get("nickname")?.getAsNullableString()?:""
            val pic = obj?.get("avatar")?.getAsNullableJsonObject()?.get("large")?.getAsNullableString()?:""
            val sign = obj?.get("sign")?.getAsNullableString()?:"这个人什么都没说……"
            println(nickName + " " + pic + " " + sign)
            return UserInfo(
                name = nickName,
                profile = pic,
                hitokoto = sign
            )
        } catch (e : Exception) {
            return null
        }
    }
}