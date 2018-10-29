package com.ssekorea.sse.sseproject;

import android.app.Activity;
import android.app.Application;
import android.content.Context;

import com.androidnetworking.AndroidNetworking;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;
import com.kakao.auth.KakaoSDK;
import com.ssekorea.sse.sseproject.common.KakaoSDKAdapter;
import com.ssekorea.sse.sseproject.di.DaggerAppComponent;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;

public class SseApp extends Application implements HasActivityInjector {
    private static Context appContext;
    @Inject
    DispatchingAndroidInjector<Activity> activityDispatchingAndroidInjector;



    @Override
    public DispatchingAndroidInjector<Activity> activityInjector() {
        return activityDispatchingAndroidInjector;
    }
    public static Context getAppContext(){
        return appContext;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        this.appContext = getApplicationContext();
        DaggerAppComponent.builder()
                .application(this)
                .build()
                .inject(this);
        AndroidNetworking.initialize(getApplicationContext());
        KakaoSDK.init(new KakaoSDKAdapter(this));
        AppEventsLogger.activateApp(this);
    }


}
