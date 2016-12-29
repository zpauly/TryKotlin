package com.zpauly.firstkotlinapp.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.zpauly.firstkotlinapp.R

/**
 * Created by zpauly on 2016/12/28.
 */

class LoadingDelegateAdapter : ViewTypeDelegateAdapter {
    override fun onCreateViewHolder(parent: ViewGroup?): RecyclerView.ViewHolder
        = LoadingViewHolder(LayoutInflater.from(parent?.context).inflate(R.layout.loading, parent, false))

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, item: DataType) {

    }

    class LoadingViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView)
}
