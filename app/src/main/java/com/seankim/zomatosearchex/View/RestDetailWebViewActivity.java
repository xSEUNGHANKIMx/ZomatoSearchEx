package com.seankim.zomatosearchex.View;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.seankim.zomatosearchex.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RestDetailWebViewActivity extends AppCompatActivity {
    private String mUrl = null;

    @BindView(R.id.webview)
    WebView mWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_restaurant_detail_webview);
        ButterKnife.bind(this);
        mUrl = getIntent().getStringExtra("RESTAURANT_URL");
        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.setWebViewClient(new WebViewClient());
        mWebView.loadUrl(mUrl);
        mWebView.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if ((i == keyEvent.KEYCODE_BACK) && mWebView.canGoBack()){
                    mWebView.goBack();
                    return true;
                }
                return false;
            }
        });
    }
}
