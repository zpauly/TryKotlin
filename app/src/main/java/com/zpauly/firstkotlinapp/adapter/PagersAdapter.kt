package com.zpauly.firstkotlinapp.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import java.util.*

/**
 * Created by zpauly on 2016/12/29.
 */
class PagersAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm) {
    private val fragments = ArrayList<Fragment>()

    private val titles = ArrayList<String>()

    override fun getItem(position: Int): Fragment = fragments[position]

    override fun getCount(): Int = fragments.size

    override fun getPageTitle(position: Int): CharSequence = titles[position]

    fun addFragment(f: Fragment?, t: String?) {
        f?.let { fragments.add(it) }
        t?.let { titles.add(it) }
    }
}