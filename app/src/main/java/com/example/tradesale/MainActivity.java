package com.example.tradesale;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;



public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button b_open_browser,share,b_send_email;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }
    void initView(){
        b_open_browser = findViewById(R.id.b_open_browser);
        b_open_browser.setOnClickListener(this);
        share = findViewById(R.id.b_share);
        share.setOnClickListener(this);
        b_send_email = findViewById(R.id.b_send_email);
        b_send_email.setOnClickListener(this);
    }


    void openBrowserActivity(){
        Intent intent = new Intent(this,BrowserActivity.class);
        startActivity(intent);
    }
    void shareLinkWith(String url){
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, url);
        startActivity(Intent.createChooser(intent, "Share"));
    }
    @Override
    public void onClick(View view) {
        Button btn = (Button)view;
        if (btn.getId() == b_open_browser.getId()){
            openBrowserActivity();
        }
        if (btn.getId() == share.getId()){
            shareLinkWith("https://www.google.co.uz/");
        }
        if (btn.getId() == b_send_email.getId()){
            Intent intent = new Intent(this,SendEmailActivity.class);
            startActivity(intent);
        }
    }
}