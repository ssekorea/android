package com.ssekorea.sse.sseproject.main.shop.detail;

import android.arch.lifecycle.ViewModelProvider;

import com.ssekorea.sse.sseproject.ViewModelProviderFactory;
import com.ssekorea.sse.sseproject.data.remote.ApiHelper;
import com.ssekorea.sse.sseproject.domain.user.UserRepository;
import com.ssekorea.sse.sseproject.util.rx.SchedulerProvider;

import dagger.Module;
import dagger.Provides;

@Module
public class ShopDetailActivityModule {

    @Provides
    ViewModelProvider.Factory shopDetailViewModelProvider(ShopDetailViewModel shopDetailViewModel){
        return new ViewModelProviderFactory<>(shopDetailViewModel);
    }

    @Provides
    ShopDetailViewModel provideShopDetailViewModel(SchedulerProvider schedulerProvider, ApiHelper apiHelper, UserRepository userRepository){
        return new ShopDetailViewModel(schedulerProvider,apiHelper,userRepository);
    }
}
