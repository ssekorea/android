package com.ssekorea.sse.sseproject.di;

import com.ssekorea.sse.sseproject.login.LoginActivity;
import com.ssekorea.sse.sseproject.login.LoginActivityModule;
import com.ssekorea.sse.sseproject.main.lecture.LectureFragmentProvider;
import com.ssekorea.sse.sseproject.main.MainActivity;
import com.ssekorea.sse.sseproject.main.MainActivityModule;
import com.ssekorea.sse.sseproject.register.basic.BasicRegisterActivity;
import com.ssekorea.sse.sseproject.register.basic.BasicRegisterActivityModule;
import com.ssekorea.sse.sseproject.register.social.SocialRegisterActivity;
import com.ssekorea.sse.sseproject.register.social.SocialRegisterActivityModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBindingModule {
    //@ActivityScope  // Scope
    @ContributesAndroidInjector(modules = {
            MainActivityModule.class,
            LectureFragmentProvider.class
    })
    abstract MainActivity mainActivity();

    @ContributesAndroidInjector(modules = LoginActivityModule.class)
    abstract LoginActivity loginActivity();

    @ContributesAndroidInjector(modules = BasicRegisterActivityModule.class)
    abstract BasicRegisterActivity basicRegisterActivity();

    @ContributesAndroidInjector(modules = SocialRegisterActivityModule.class)
    abstract SocialRegisterActivity socialRegisterActivity();
}
