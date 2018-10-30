package com.ssekorea.sse.sseproject.main.lecture;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class LectureFragmentProvider {

    @ContributesAndroidInjector(modules = LectureFragmentModule.class)
    abstract LectureFragment provideLectureFragment();
}
