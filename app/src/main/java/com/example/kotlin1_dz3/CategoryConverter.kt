package com.example.kotlin1_dz3

import com.example.kotlin1_dz3.model.Images
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

    class CategoryConverter {

        fun fromString(value: String?): List<Images>? {

            val listType: Type = object : TypeToken<List<Images>?>() {}.type

            return Gson().fromJson(value, listType)

        }


        fun fromListCategoryModel(list: List<Images>?): String? {

            val gson = Gson()

            val listType: Type = object : TypeToken<List<Images>?>() {}.type

            return gson.toJson(list, listType)

        }

    }