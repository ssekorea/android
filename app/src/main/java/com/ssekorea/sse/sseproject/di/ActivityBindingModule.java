package com.ssekorea.sse.sseproject.di;

import com.ssekorea.sse.sseproject.login.LoginActivity;
import com.ssekorea.sse.sseproject.login.LoginActivityModule;
import com.ssekorea.sse.sseproject.main.MainActivity;
import com.ssekorea.sse.sseproject.main.MainActivityModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBindingModule {
    //@ActivityScope  // Scope
    @ContributesAndroidInjector(modules = MainActivityModule.class)
    abstract MainActivity mainActivity();

    @ContributesAndroidInjector(modules = LoginActivityModule.class)
    abstract LoginActivity loginActivity();


}
