package com.ssekorea.sse.sseproject.di;

import android.app.Application;
import android.content.Context;

import com.ssekorea.sse.sseproject.common.Config;
import com.ssekorea.sse.sseproject.data.local.AppPreferencesHelper;
import com.ssekorea.sse.sseproject.data.local.PreferencesHelper;
import com.ssekorea.sse.sseproject.data.remote.ApiHelper;
import com.ssekorea.sse.sseproject.data.remote.ApiHelperImpl;
import com.ssekorea.sse.sseproject.domain.lecture.AppLectureRepository;
import com.ssekorea.sse.sseproject.domain.lecture.LectureRepository;
import com.ssekorea.sse.sseproject.domain.user.AppUserRepository;
import com.ssekorea.sse.sseproject.domain.user.UserRepository;
import com.ssekorea.sse.sseproject.util.rx.AppSchedulerProvider;
import com.ssekorea.sse.sseproject.util.rx.SchedulerProvider;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    @Provides
    Context providesContext(Application application){
        return application;
    }

    @Provides
    @Singleton
    UserRepository providesUserRepository(PreferencesHelper preferencesHelper){
        return new AppUserRepository(preferencesHelper);
    }

    @Provides
    @Singleton
    LectureRepository provideLectureRepository(){
        return new AppLectureRepository();
    }

    @Provides
    PreferencesHelper providePreferenceHelper(Context context, @PreferenceInfo String prefInfo){
        return new AppPreferencesHelper(context,prefInfo);
    }

    @Provides
    @PreferenceInfo
    String providePreferenceName() {
        return Config.PREF_NAME;
    }

    @Provides
    SchedulerProvider provideSchedulerProvider() {
        return new AppSchedulerProvider();
    }

    @Provides
    @Singleton
    ApiHelper provideApiHelper(){
        return new ApiHelperImpl();
    }

}
