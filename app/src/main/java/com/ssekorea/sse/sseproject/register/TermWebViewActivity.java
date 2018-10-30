package com.ssekorea.sse.sseproject.register;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.ssekorea.sse.sseproject.R;
import com.ssekorea.sse.sseproject.generated.callback.OnClickListener;

public class TermWebViewActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_term_web_view);
        WebView web = (WebView)findViewById(R.id.termWebView_webView);

        web.getSettings().setJavaScriptEnabled(true);  //자바스크립트 허용
        Intent intent = getIntent();
        String name = intent.getStringExtra("title");
        String url = intent.getStringExtra("url");

        TextView tv = findViewById(R.id.tv_webviewTitle);
        ImageButton b = findViewById(R.id.termWebView_back);
        b.setOnClickListener(v->finish());
        tv.setText(name);
        web.loadUrl(url);  //보여줄 사이트 url

//        web.setWebViewClient(new WebViewClient(){   //현재의 엑티비티 내에서 url을 보여주고자 할 경우 설정.
//
//            @Override
//
//            public boolean shouldOverrideUrlLoading(WebView view, String url) {
//
//                // TODO Auto-generated method stub
//
//                view.loadUrl(url); //다른 url링크를 클릭했을때 url을 다시 로드
//
//                return true;
//
//            }
//
//        });

    }
}
