package com.ssekorea.sse.sseproject.register.social;

import android.arch.lifecycle.ViewModelProvider;

import com.ssekorea.sse.sseproject.ViewModelProviderFactory;
import com.ssekorea.sse.sseproject.data.remote.ApiHelper;
import com.ssekorea.sse.sseproject.domain.user.UserRepository;
import com.ssekorea.sse.sseproject.util.rx.SchedulerProvider;

import dagger.Module;
import dagger.Provides;

@Module
public class SocialRegisterActivityModule {

    @Provides
    ViewModelProvider.Factory socialRegisterViewModelProvider(SocialRegisterViewModel socialRegisterViewModel){
        return new ViewModelProviderFactory<>(socialRegisterViewModel);
    }

    @Provides
    SocialRegisterViewModel provideSocialRegisterViewModel(SchedulerProvider schedulerProvider, ApiHelper apiHelper, UserRepository userRepository){
        return new SocialRegisterViewModel(schedulerProvider,apiHelper,userRepository);
    }
}
