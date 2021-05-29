package com.lire.utils

import com.google.gson.JsonArray
import com.google.gson.JsonElement
import com.google.gson.JsonObject

/**
 * Gson扩展函数
 * 用来回避JsonNull的问题，在有JsonNull的时候直接返回null
 *
 */

fun JsonElement.getAsNullableString() : String? {
    if (isJsonNull) return null
    return asString
}

fun JsonElement.getAsNullableJsonArray() : JsonArray? {
    if (isJsonNull) return null
    return asJsonArray
}

fun JsonElement.getAsNullableJsonObject() : JsonObject? {
    if (isJsonNull) return null
    return asJsonObject
}

fun JsonElement.getAsNullableInt() : Int? {
    if (isJsonNull) return null
    return asInt
}

fun JsonElement.getAsNullableDouble() : Double? {
    if (isJsonNull) return null
    return asDouble
}