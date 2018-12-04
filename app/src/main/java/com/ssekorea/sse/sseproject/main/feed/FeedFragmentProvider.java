package com.ssekorea.sse.sseproject.main.feed;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class FeedFragmentProvider {
    @ContributesAndroidInjector(modules = FeedFragmentModule.class)
    abstract FeedFragment providefeedFragment();
}
