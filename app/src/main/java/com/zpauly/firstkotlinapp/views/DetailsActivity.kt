package com.zpauly.firstkotlinapp.views

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import com.zpauly.firstkotlinapp.R
import kotlinx.android.synthetic.main.activity_details.*

/**
 * Created by zpauly on 2016/12/29.
 */
class DetailsActivity : AppCompatActivity() {

    companion object {
        val DETAILS_LINK = "DETAILS_LINK"
    }

    private var detail_link: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        detail_link = getLink()

        setContentView(R.layout.activity_details)

        setSupportActionBar(detail_toolbar)
        detail_toolbar.setNavigationOnClickListener {
            onBackPressed()
        }
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        webView.apply {
            loadUrl(detail_link)
            setWebViewClient(DetailsWebClient())
            settings.javaScriptEnabled = true
        }
    }


    private fun getLink(): String? = intent.getStringExtra(DETAILS_LINK)

    inner class DetailsWebClient : WebViewClient() {
        override fun onPageFinished(view: WebView?, url: String?) {
            progress.visibility = View.GONE
            webView.visibility = View.VISIBLE
        }

        override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(intent)
            return true
        }
    }
}