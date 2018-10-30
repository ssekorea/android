package com.ssekorea.sse.sseproject.register.basic;

import android.arch.lifecycle.ViewModelProvider;

import com.ssekorea.sse.sseproject.ViewModelProviderFactory;
import com.ssekorea.sse.sseproject.data.remote.ApiHelper;
import com.ssekorea.sse.sseproject.domain.user.UserRepository;
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
    BasicRegisterViewModel provideBasicRegisterViewModel(SchedulerProvider schedulerProvider, ApiHelper apiHelper, UserRepository userRepository){
        return new BasicRegisterViewModel(schedulerProvider,apiHelper,userRepository);
    }
}
