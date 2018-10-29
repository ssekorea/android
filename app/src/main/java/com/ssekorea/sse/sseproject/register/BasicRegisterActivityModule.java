package com.ssekorea.sse.sseproject.register;

import android.arch.lifecycle.ViewModelProvider;

import com.ssekorea.sse.sseproject.ViewModelProviderFactory;
import com.ssekorea.sse.sseproject.util.rx.SchedulerProvider;

import dagger.Module;
import dagger.Provides;

@Module
public class BasicRegisterActivityModule {

    @Provides
    ViewModelProvider.Factory basicRegisterViewModelProvider(BasicRegisterViewModel basicRegisterViewModel){
        return new ViewModelProviderFactory<>(basicRegisterViewModel);
    }

    @Provides
    BasicRegisterViewModel provideBasicRegisterViewModel(SchedulerProvider schedulerProvider){
        return new BasicRegisterViewModel(schedulerProvider);
    }
}
