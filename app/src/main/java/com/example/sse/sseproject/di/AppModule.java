package com.example.sse.sseproject.di;

import android.app.Application;
import android.content.Context;

import com.example.sse.sseproject.data.local.AppPreferencesHelper;
import com.example.sse.sseproject.data.local.PreferencesHelper;
import com.example.sse.sseproject.domain.user.AppUserRepository;
import com.example.sse.sseproject.domain.user.UserRepository;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {
    @Provides
    Context providesContext(Application application){
        return application;
    }

    @Provides
    UserRepository providesUserRepository(PreferencesHelper preferencesHelper){
        return new AppUserRepository(preferencesHelper);
    }


    @Provides
    PreferencesHelper providePreferenceHelper(Context context, @PreferenceInfo String prefInfo){
        return new AppPreferencesHelper(context,prefInfo);
    }
}
