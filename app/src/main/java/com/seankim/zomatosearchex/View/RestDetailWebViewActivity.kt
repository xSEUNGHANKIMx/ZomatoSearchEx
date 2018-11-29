package com.seankim.zomatosearchex.View

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.KeyEvent
import android.view.KeyEvent.KEYCODE_BACK
import android.view.KeyEvent.KEYCODE_E
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient

import com.seankim.zomatosearchex.R

import butterknife.BindView
import butterknife.ButterKnife

class RestDetailWebViewActivity : AppCompatActivity() {
    private var mUrl: String? = null

    @BindView(R.id.webview)
    internal var mWebView: WebView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_restaurant_detail_webview)
        ButterKnife.bind(this)
        mUrl = intent.getStringExtra("RESTAURANT_URL")
        mWebView!!.settings.javaScriptEnabled = true
        mWebView!!.webViewClient = WebViewClient()
        mWebView!!.loadUrl(mUrl)
        mWebView!!.setOnKeyListener(View.OnKeyListener { view, i, keyEvent ->
            if (i == KeyEvent.KEYCODE_BACK && mWebView!!.canGoBack()) {
                mWebView!!.goBack()
                return@OnKeyListener true
            }
            false
        })
    }
}
