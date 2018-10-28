package com.ssekorea.sse.sseproject.login;

import android.arch.lifecycle.ViewModelProvider;

import com.facebook.CallbackManager;
import com.facebook.login.LoginManager;
import com.ssekorea.sse.sseproject.ViewModelProviderFactory;
import com.ssekorea.sse.sseproject.util.rx.SchedulerProvider;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class LoginActivityModule {
//    @Provides
//    CallbackManager provideFacebookCallbackManager(){
//        return CallbackManager.Factory.create();
//    }
//
//    @Provides
//    FacebookLoginCallback provideFacebookLoginCallback(){
//        return new FacebookLoginCallback();
//    }
//
//    @Provides
//    LoginManager provideFacebookLoginManager(){
//        return LoginManager.getInstance();
//    }

    @Provides
    LoginViewModel provideLoginViewModel(SchedulerProvider schedulerProvider){
        return new LoginViewModel(schedulerProvider);
    }

    @Provides
    ViewModelProvider.Factory provideLoginViewModelFactory(LoginViewModel loginViewModel){
        return new ViewModelProviderFactory<>(loginViewModel);
    }
}
