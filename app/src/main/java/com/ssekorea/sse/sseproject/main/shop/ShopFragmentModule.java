package com.ssekorea.sse.sseproject.main.shop;

import android.arch.lifecycle.ViewModelProvider;
import android.support.v7.widget.LinearLayoutManager;

import com.ssekorea.sse.sseproject.ViewModelProviderFactory;
import com.ssekorea.sse.sseproject.util.rx.SchedulerProvider;
import com.ssekorea.sse.sseproject.data.remote.ApiHelper;

import java.util.ArrayList;

import dagger.Module;
import dagger.Provides;

@Module
public class ShopFragmentModule {
    @Provides
    ShopViewModel provideShopViewModel(SchedulerProvider schedulerProvider,ApiHelper apiHelper){
        return new ShopViewModel(schedulerProvider,apiHelper);
    }

    @Provides
    ViewModelProvider.Factory provideShopViewModelFactory(ShopViewModel shopViewModel){
        return new ViewModelProviderFactory<>(shopViewModel);
    }

    @Provides
    ShopAdapter provideShopAdapter(){
        return new ShopAdapter(new ArrayList<>());
    }

    @Provides
    LinearLayoutManager provideLinearLayoutManager(ShopFragment shopFragment){
        return new LinearLayoutManager(shopFragment.getActivity());
    }
}
