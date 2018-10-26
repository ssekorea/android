package com.example.sse.sseproject.register;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.sse.sseproject.R;

public class TermWebViewActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_term_web_view);
        WebView web = (WebView)findViewById(R.id.termWebView_webView);

        web.getSettings().setJavaScriptEnabled(true);  //자바스크립트 허용

        web.loadUrl("http://165.194.104.92:4402/%EA%B0%9C%EC%9D%B8%EC%A0%95%EB%B3%B4%EC%B2%98%EB%A6%AC%EB%B0%A9%EC%B9%A8.html");  //보여줄 사이트 url

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
