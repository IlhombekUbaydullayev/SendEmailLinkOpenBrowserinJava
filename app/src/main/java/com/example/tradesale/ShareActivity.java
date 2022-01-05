package com.example.tradesale;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.URLUtil;
import android.webkit.WebView;

public class ShareActivity extends AppCompatActivity {
     WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share);
        intentContent();
        initViews();
    }
    void initViews(){
        webView = findViewById(R.id.share_wv);
    }
    void intentContent() {
        // Get intent, action and MIME type
        Intent intent = getIntent();
        String action = intent.getAction();
        String type = intent.getType();

        if (Intent.ACTION_SEND.equals(action) && type != null) {
            if ("text/plain".equals(type)) {
                handleWebView(intent); // Handle text being sent
            }
        } else {
            // Handle other intents, such as being started from the home screen
            Log.d("@@@","image Uri null");
        }
    }


    void handleWebView(Intent intent) {
        String url = intent.getStringExtra(Intent.EXTRA_TEXT);
        if (url != null) {
            // Update UI to reflect text being shared
            Log.d("@@@", url);
            if(url != "" && URLUtil.isValidUrl(url)) {
                webView.loadUrl(url);
            }
            else{
                webView.loadUrl("https://www.google.com/search?q="+url);
            }
        }
    }
}