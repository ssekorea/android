package com.example.sse.sseproject.di;

import com.example.sse.sseproject.main.MainActivity;
import com.example.sse.sseproject.main.MainActivityModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBindingModule {
    //@ActivityScope  // Scope
    @ContributesAndroidInjector(modules = MainActivityModule.class)
    abstract MainActivity mainActivity();
}
