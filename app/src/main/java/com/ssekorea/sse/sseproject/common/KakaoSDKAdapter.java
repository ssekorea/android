package com.ssekorea.sse.sseproject.common;

import android.content.Context;

import com.kakao.auth.IApplicationConfig;
import com.kakao.auth.KakaoAdapter;
import com.ssekorea.sse.sseproject.SseApp;

public class KakaoSDKAdapter extends KakaoAdapter {
    private Context context;

    public KakaoSDKAdapter(Context appContext){
        this.context = appContext;
    }
    @Override
    public IApplicationConfig getApplicationConfig() {
        return new IApplicationConfig() {
            @Override
            public Context getApplicationContext() {
                return context;
            }
        };
    }
}
