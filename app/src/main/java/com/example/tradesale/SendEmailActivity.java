package com.example.tradesale;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SendEmailActivity extends AppCompatActivity {
    EditText etTo,etSubject,etMessage;
    Button btSend;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_email);
        initView();
    }
    void initView(){
        etTo = findViewById(R.id.ed_to);
        etSubject = findViewById(R.id.ed_subject);
        etMessage = findViewById(R.id.ed_message);
        btSend = findViewById(R.id.btn_send);
        btSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW
                , Uri.parse("mailto:" + etTo.getText().toString()));
                intent.putExtra(Intent.EXTRA_SUBJECT,etSubject.getText().toString());
                intent.putExtra(Intent.EXTRA_TEXT,etMessage.getText().toString());
                startActivity(intent);
            }
        });
    }
}