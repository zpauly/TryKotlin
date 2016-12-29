package com.zpauly.firstkotlinapp

import android.support.v4.app.Fragment
import rx.subscriptions.CompositeSubscription

/**
 * Created by zpauly on 2016/12/28.
 */
open class BaseFragment : Fragment() {
    protected var subscriptions = CompositeSubscription()

    override fun onResume() {
        super.onResume()
        subscriptions = CompositeSubscription()
    }

    override fun onPause() {
        super.onPause()
        subscriptions.clear()
    }
}