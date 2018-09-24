package com.example.sendbadstory;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.ImageView;

public class mystory extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mystory);
        WebView webView=findViewById(R.id.webview);
        Intent data=getIntent();
        int page=data.getExtras().getInt("page");
        page++;
        webView.loadUrl("file:///android_asset/html/"+page+".html");
    }

}
