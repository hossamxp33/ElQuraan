package com.codesroots.elquraan;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import com.codesroots.elquraan.Helpers.ConnectivityReceiver;

public class AboutApp extends AppCompatActivity {

    TextView textView;
    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_app);
        WebView webView =   findViewById(R.id.webview);
        textView =   findViewById(R.id.textviewAbout);
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                return false;
            }
        });

            webView.loadUrl("file:///android_asset/aboutApp.html");
        webView.getSettings().setJavaScriptEnabled(true);

    }





}
