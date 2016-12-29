package com.zpauly.firstkotlinapp.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.zpauly.firstkotlinapp.R
import com.zpauly.firstkotlinapp.entities.DataResult
import kotlinx.android.synthetic.main.data_item.view.*

/**
 * Created by zpauly on 2016/12/28.
 */
class DataDelegateAdatper(val listener: OnViewClickedListener) : ViewTypeDelegateAdapter {
    override fun onCreateViewHolder(parent: ViewGroup?): RecyclerView.ViewHolder
        = DataViewHolder(LayoutInflater.from(parent?.context).inflate(R.layout.data_item, parent, false))

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, item: DataType) {
        holder as DataViewHolder
        holder.bind(item as? DataResult)
    }

    interface OnViewClickedListener {
        fun onViewClicked(view: View)
    }

    inner class DataViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: DataResult?) = with(itemView) {
            data_title_TV.text = item?.desc
            data_time_TV.text = item?.publishedAt
            data_who_TV.text = item?.who

            setOnClickListener { view -> listener.onViewClicked(view) }
        }
    }
}
