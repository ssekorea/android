package com.ssekorea.sse.sseproject;

import com.androidnetworking.AndroidNetworking;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;
import com.kakao.auth.KakaoSDK;
import com.ssekorea.sse.sseproject.common.KakaoSDKAdapter;
import com.ssekorea.sse.sseproject.di.DaggerAppComponent;

import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;

public class SseApp extends DaggerApplication {

    @Override
    public void onCreate() {
        super.onCreate();
        AndroidNetworking.initialize(getApplicationContext());
        KakaoSDK.init(new KakaoSDKAdapter(this));
        AppEventsLogger.activateApp(this);
    }

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        return DaggerAppComponent.builder().application(this).build();
    }
}
