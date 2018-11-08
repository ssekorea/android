package com.ssekorea.sse.sseproject.main.shop;


import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ShopFragmentProvider {
    @ContributesAndroidInjector(modules = ShopFragmentModule.class)
    abstract ShopFragment provideShopFragment();
}
