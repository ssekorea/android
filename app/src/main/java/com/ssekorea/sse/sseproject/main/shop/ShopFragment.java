package com.ssekorea.sse.sseproject.main.shop;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.ssekorea.sse.sseproject.BR;
import com.ssekorea.sse.sseproject.R;
import com.ssekorea.sse.sseproject.base.BaseFragment;
import com.ssekorea.sse.sseproject.base.BaseViewModel;
import com.ssekorea.sse.sseproject.databinding.FragmentShopBinding;

import javax.inject.Inject;

public class ShopFragment extends BaseFragment<FragmentShopBinding,ShopViewModel> implements ShopNavigator {
    @Inject
    ShopAdapter shopAdapter;
    @Inject
    ViewModelProvider.Factory viewModelFactory;
    @Inject
    LinearLayoutManager layoutManager;

    private FragmentShopBinding fragmentShopBinding;
    private ShopViewModel shopViewModel;

    public static ShopFragment newInstance(){
        Bundle args = new Bundle();
        ShopFragment fragment = new ShopFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_shop;
    }

    @Override
    public ShopViewModel getViewModel() {
        shopViewModel = ViewModelProviders.of(this,viewModelFactory).get(ShopViewModel.class);
        return shopViewModel;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        shopViewModel.setNavigator(this);
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        fragmentShopBinding = getViewDataBinding();
        setUp();
        subscribeLiveData();
    }

    private void subscribeLiveData() {
        shopViewModel.getShopItemsLiveData().observe(this,shopList->{
            shopAdapter.clearItems();
            shopAdapter.addItems(shopList);
        });
    }

    private void setUp() {
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        fragmentShopBinding.lectureRecyclerview.setLayoutManager(layoutManager);
        fragmentShopBinding.lectureRecyclerview.setItemAnimator(new DefaultItemAnimator());
        fragmentShopBinding.lectureRecyclerview.setAdapter(shopAdapter);
    }
}
