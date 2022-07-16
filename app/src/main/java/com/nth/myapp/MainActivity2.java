package com.nth.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    Button buttonBack, buttonNext, buttonReload, buttonSearch;
    EditText editTextUrl;
    WebView web;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        AnhXa();

        web.setWebViewClient(new WebViewClient()); // Không bị out ra khi mà vào trang web
        // Nhớ cấp quyền truy cập Internet

        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (web.canGoBack()){
                    web.goBack();
                    editTextUrl.setText(web.getUrl());
                    Toast.makeText(MainActivity2.this, "Trang trước",Toast.LENGTH_SHORT).show(); // Thông báo đã vào trang trước
                } else {
                    Toast.makeText(MainActivity2.this, " Không có dữ liệu trang trước", Toast.LENGTH_SHORT).show();
                }

            }
        });

        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (web.canGoForward()){
                    web.goForward();
                    editTextUrl.setText(web.getUrl());
                    Toast.makeText(MainActivity2.this, "Đã vào trang sau", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity2.this, " Không có dữ liệu trang sau", Toast.LENGTH_SHORT).show();
                }
            }
        });

        buttonReload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                web.reload();
                editTextUrl.setText(web.getUrl());
            }
        });

        buttonSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String url = editTextUrl.getText().toString().trim();
                web.loadUrl("http://" + url);
                editTextUrl.setText(web.getUrl());
            }
        });

        // Cài đặt Web
        WebSettings settings = web.getSettings();
        settings.setJavaScriptEnabled(true); // Mở các chức năng của web lên
        settings.setBuiltInZoomControls(true); // Mở chức năng Zoom lên
        settings.setDisplayZoomControls(false); // Đóng thanh zoom

    }

    public void AnhXa (){
        buttonBack = (Button) findViewById(R.id.btBack);
        buttonNext = (Button) findViewById(R.id.btNext);
        buttonReload = (Button) findViewById(R.id.btReload);
        buttonSearch =(Button) findViewById(R.id.btSearch);

        editTextUrl = (EditText) findViewById(R.id.url);
        web = (WebView) findViewById(R.id.webView);
    }


}