package com.zpauly.firstkotlinapp.entities

import com.zpauly.firstkotlinapp.adapter.DataType
import com.zpauly.trykotlin.Constants

/**
 * Created by zpauly on 2016/12/28.
 */
data class Data(var error: Boolean,
                var results: List<DataResult>)

data class DataResult(var _id: String,
                      var createAt: String,
                      var desc: String,
                      var images: List<String>,
                      var publishedAt: String,
                      var source: String,
                      var type: String,
                      var url: String,
                      var used: Boolean,
                      var who: String) : DataType {
    override fun getViewType(): Int = Constants.VIEW_TYPE_DATA
}