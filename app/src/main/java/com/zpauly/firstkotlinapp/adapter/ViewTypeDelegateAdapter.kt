package com.zpauly.firstkotlinapp.adapter

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup

/**
 * Created by zpauly on 2016/12/28.
 */
interface ViewTypeDelegateAdapter {
    fun onCreateViewHolder(parent: ViewGroup?): RecyclerView.ViewHolder

    fun onBindViewHolder(holder: RecyclerView.ViewHolder?, item: DataType)
}