package com.zpauly.firstkotlinapp.adapter

import android.support.v4.util.SparseArrayCompat
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.zpauly.firstkotlinapp.entities.Data
import com.zpauly.firstkotlinapp.entities.DataResult
import com.zpauly.trykotlin.Constants
import java.util.*

/**
 * Created by zpauly on 2016/12/28.
 */
class DataAdapter(listener: (View) -> Unit) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var items = ArrayList<DataType>()
    private var delegateAdapters = SparseArrayCompat<ViewTypeDelegateAdapter>()
    private val loadingItem = object : DataType {
        override fun getViewType(): Int = Constants.VIEW_TYPE_LOADING

    }

    init {
        delegateAdapters.put(Constants.VIEW_TYPE_LOADING, LoadingDelegateAdapter())
        delegateAdapters.put(Constants.VIEW_TYPE_DATA, DataDelegateAdatper(object : DataDelegateAdatper.OnViewClickedListener {
            override fun onViewClicked(view: View) {
                listener(view)
            }
        }))
        items.add(loadingItem)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int)
        = delegateAdapters.get(getItemViewType(position)).onBindViewHolder(holder, items[position])

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder = delegateAdapters.get(viewType).onCreateViewHolder(parent)

    override fun getItemCount(): Int = items.size

    override fun getItemViewType(position: Int): Int = items[position].getViewType()

    fun add(dataList: List<DataResult>?) {
        val initPosition = items.size - 1
        items.removeAt(initPosition)
        notifyItemRemoved(initPosition)

        dataList?.let {
            items.addAll(it)
            items.add(loadingItem)
            notifyItemRangeChanged(initPosition, dataList.size + 1)
        }
    }

    fun clear() {
        items.clear()
        notifyItemRangeChanged(0, if (items.lastIndex == -1) 0 else items.lastIndex)

        items.add(loadingItem)
        notifyItemInserted(0)
    }

    fun getData(): List<DataResult> =
            items.filter { it.getViewType() == Constants.VIEW_TYPE_DATA }
                    .map { it as DataResult }
}