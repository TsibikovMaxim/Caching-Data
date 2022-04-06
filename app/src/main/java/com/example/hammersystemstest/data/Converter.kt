package com.example.hammersystemstest.data

import androidx.room.TypeConverter
import com.example.hammersystemstest.data.model.PizzaItem
import com.example.hammersystemstest.data.model.Support
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type
import java.util.*
import java.util.stream.Collectors

class Converter {
    @TypeConverter
    fun stringToListServer(data: String?): List<PizzaItem?>? {
        if (data == null) {
            return Collections.emptyList()
        }
        val listType: Type = object :
            TypeToken<List<PizzaItem?>?>() {}.type
        return Gson().fromJson<List<PizzaItem?>>(data, listType)
    }

    @TypeConverter
    fun listServerToString(someObjects: List<PizzaItem?>?): String? {
        return Gson().toJson(someObjects)
    }

    @TypeConverter
    fun stringToListSupport(data: String?): Support? {
        //Needed be fixed
        return Support("a","b")
    }

    @TypeConverter
    fun listServerToSupport(someObjects: Support?): String? {
        return Gson().toJson(someObjects)
    }
}