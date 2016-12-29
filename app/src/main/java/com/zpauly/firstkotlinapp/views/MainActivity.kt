package com.zpauly.firstkotlinapp.views

import android.os.Bundle
import android.support.v4.app.FragmentStatePagerAdapter
import android.support.v7.app.AppCompatActivity
import com.zpauly.firstkotlinapp.R
import com.zpauly.firstkotlinapp.adapter.PagersAdapter
import com.zpauly.trykotlin.views.DataFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbar)
        toolbar.setTitle(R.string.gank_io)

        initViewPager()
    }

    private fun initViewPager() {
        viewPager.adapter = initAdapter()

        tabLayout.setupWithViewPager(viewPager)
    }

    private fun initAdapter(): FragmentStatePagerAdapter {
        val adapter = PagersAdapter(supportFragmentManager)

        adapter.apply {
            addFragment(DataFragment.create(DataFragment.DATA_FULI), getString(R.string.fuli))
            addFragment(DataFragment.create(DataFragment.DATA_ANDROID), getString(R.string.android))
            addFragment(DataFragment.create(DataFragment.DATA_IOS), getString(R.string.ios))
            addFragment(DataFragment.create(DataFragment.DATA_XIUXISHIPIN), getString(R.string.xiuxishipin))
            addFragment(DataFragment.create(DataFragment.DATA_TUOZHANZIYUAN), getString(R.string.tuozhanziyuan))
            addFragment(DataFragment.create(DataFragment.DATA_QIANDUAN), getString(R.string.qianduan))
            addFragment(DataFragment.create(DataFragment.DATA_ALL), getString(R.string.all))
        }

        return adapter
    }
}
