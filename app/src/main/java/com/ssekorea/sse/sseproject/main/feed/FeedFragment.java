package com.ssekorea.sse.sseproject.main.feed;


import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.ssekorea.sse.sseproject.R;
import com.ssekorea.sse.sseproject.BR;
import com.ssekorea.sse.sseproject.base.BaseFragment;
import com.ssekorea.sse.sseproject.databinding.FragmentFeedBinding;

import javax.inject.Inject;

public class FeedFragment extends BaseFragment<FragmentFeedBinding, FeedViewModel> implements FeedNavigator {

    @Inject
    FeedAdapter feedAdapter;
    @Inject
    ViewModelProvider.Factory viewModelFactory;
    @Inject
    LinearLayoutManager mLayoutManager;
    private FragmentFeedBinding fragmentFeedBinding;
    private FeedViewModel feedViewModel;

    public static FeedFragment newInstance(){
        Bundle args = new Bundle();
        FeedFragment fragment = new FeedFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getBindingVariable(){
        return BR.viewModel;
    }

    @Override
    public int getLayoutId(){
        return R.layout.fragment_feed;
    }

    @Override
    public FeedViewModel getViewModel(){
        feedViewModel = ViewModelProviders.of(this,viewModelFactory).get(FeedViewModel.class);
        return feedViewModel;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        feedViewModel.setNavigator(this);
    }

    @Override
    public void onViewCreated(@NonNull View view,Bundle savedInstanceState){
        super.onViewCreated(view,savedInstanceState);
        fragmentFeedBinding = getViewDataBinding();
        setUp();
        subscribeLiveData();
    }

    private void setUp(){
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        fragmentFeedBinding.feedRecyclerview.setLayoutManager(mLayoutManager);
        fragmentFeedBinding.feedRecyclerview.setItemAnimator(new DefaultItemAnimator());
        fragmentFeedBinding.feedRecyclerview.setAdapter(feedAdapter);

    }

    private void subscribeLiveData(){
        feedViewModel.getFeedListLiveData().observe(this,feedList -> {
            feedAdapter.clearItems();
            feedAdapter.addItems(feedList);
        });
    }

}
