package com.ssekorea.sse.sseproject.main;

import com.ssekorea.sse.sseproject.util.rx.SchedulerProvider;

import dagger.Module;
import dagger.Provides;

@Module
public class MainActivityModule {
    @Provides
    MainViewModel provideMainViewModel(SchedulerProvider schedulerProvider){
        return new MainViewModel(schedulerProvider);
    }
}
