package com.ssekorea.sse.sseproject.login;

import com.facebook.CallbackManager;
import com.facebook.login.LoginManager;

import dagger.Module;
import dagger.Provides;

@Module
public class LoginActivityModule {
    @Provides
    CallbackManager provideFacebookCallbackManager(){
        return CallbackManager.Factory.create();
    }
    @Provides
    FacebookLoginCallback provideFacebookLoginCallback(){
        return new FacebookLoginCallback();
    }
    @Provides
    LoginManager provideFacebookLoginnManager(){
        return LoginManager.getInstance();
    }
}
