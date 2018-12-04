package com.ssekorea.sse.sseproject.main.feed;

import android.arch.lifecycle.ViewModelProvider;
import android.support.v7.widget.LinearLayoutManager;

import com.ssekorea.sse.sseproject.ViewModelProviderFactory;
import com.ssekorea.sse.sseproject.data.remote.ApiHelper;
import com.ssekorea.sse.sseproject.util.rx.SchedulerProvider;

import java.util.ArrayList;

import dagger.Module;
import dagger.Provides;

@Module
public class FeedFragmentModule {
    @Provides
    FeedViewModel provideFeedViewModel(SchedulerProvider schedulerProvider, ApiHelper apiHelper){
        return new FeedViewModel(schedulerProvider,apiHelper);
    }

    @Provides
    ViewModelProvider.Factory provideFeedViewModelFactory(FeedViewModel feedViewModel){
        return new ViewModelProviderFactory<>(feedViewModel);
    }

    @Provides
    FeedAdapter provideFeedAdapter(){
        return new FeedAdapter(new ArrayList<>());
    }
    @Provides
    LinearLayoutManager provideLinearLayoutManager(FeedFragment fragment) {
        return new LinearLayoutManager(fragment.getActivity());
    }
}
