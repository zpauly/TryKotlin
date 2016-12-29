package com.zpauly.trykotlin.views

import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.zpauly.firstkotlinapp.BaseFragment
import com.zpauly.firstkotlinapp.R
import com.zpauly.firstkotlinapp.adapter.DataAdapter
import com.zpauly.firstkotlinapp.entities.Data
import com.zpauly.firstkotlinapp.net.Apis
import com.zpauly.firstkotlinapp.utils.LoadMoreScrollListener
import com.zpauly.firstkotlinapp.views.DetailsActivity
import com.zpauly.trykotlin.utils.inflate
import com.zpauly.trykotlin.utils.showSnackbar
import kotlinx.android.synthetic.main.recyclerview.*
import rx.Subscriber
import rx.Subscription

/**
 * Created by zpauly on 2016/12/27.
 */
class DataFragment : BaseFragment() {
    companion object {

        val DATA_TYPE_KEY = "DATA_TYPE"

        val DATA_FULI = 0
        val DATA_ANDROID = 1
        val DATA_IOS = 2
        val DATA_XIUXISHIPIN = 3
        val DATA_TUOZHANZIYUAN = 4
        val DATA_QIANDUAN = 5
        val DATA_ALL = 6

        fun create(type: Int): DataFragment {
            val f = DataFragment()
            val bundle = Bundle()
            bundle.putInt(DATA_TYPE_KEY, type)
            f.arguments = bundle
            return f
        }
    }

    private var dataType: Int = -1

    private var api = Apis()
    private var pageId = 1

    private var data: Data? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataType = arguments.getInt(DATA_TYPE_KEY)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? = container?.inflate(R.layout.recyclerview)

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        recyclerView.apply {
            setHasFixedSize(true)
            val linearLayoutManager = LinearLayoutManager(context)
            layoutManager = linearLayoutManager
            clearOnScrollListeners()
            addOnScrollListener(LoadMoreScrollListener(
                    { getData() },
                    linearLayoutManager
            ))
        }

        initAdapter()

        getData()
    }

    private fun getData() {
        val subscription: Subscription = when(dataType) {
            DATA_FULI -> api.getFuliData(createSubscriber(), pageId)
            DATA_ANDROID -> api.getAndroidData(createSubscriber(), pageId)
            DATA_IOS -> api.getIOSData(createSubscriber(), pageId)
            DATA_XIUXISHIPIN -> api.getXiuxishipinData(createSubscriber(), pageId)
            DATA_TUOZHANZIYUAN -> api.getTuozhanziyuanData(createSubscriber(), pageId)
            DATA_QIANDUAN -> api.getQianduanData(createSubscriber(), pageId)
            DATA_ALL -> api.getAllData(createSubscriber(), pageId)

            else -> {
                throw IllegalArgumentException("Illegal input type of data type")
            }
        }

        subscriptions.add(subscription)
    }

    private fun createSubscriber(): Subscriber<Data> = object : Subscriber<Data>() {
            override fun onCompleted() {
                pageId++
            }

            override fun onError(e: Throwable?) {
                showSnackbar(recyclerView, "error")
                e?.printStackTrace()
            }

            override fun onNext(t: Data?) {
                data = t
                (recyclerView.adapter as DataAdapter).add(data?.results)
            }
        }

    private fun initAdapter() {
        recyclerView.adapter = DataAdapter {
            view, url ->
            val intent = Intent()
            intent.setClass(context, DetailsActivity::class.java)
            intent.putExtra(DetailsActivity.DETAILS_LINK, url)
            startActivity(intent)
        }
    }
}