package com.ssekorea.sse.sseproject.main.shop.detail;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;

import com.ssekorea.sse.sseproject.R;
import com.ssekorea.sse.sseproject.base.BaseActivity;
import com.ssekorea.sse.sseproject.BR;
import com.ssekorea.sse.sseproject.databinding.ActivityShopDetailBinding;

import javax.inject.Inject;

public class ShopDetailActivity extends BaseActivity<ActivityShopDetailBinding,ShopDetailViewModel> implements ShopDetailNavigator {
    @Inject
    ViewModelProvider.Factory viewModelFactory;

    private ActivityShopDetailBinding activityShopDetailBinding;
    private ShopDetailViewModel viewModel;

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_shop_detail;
    }

    @Override
    public ShopDetailViewModel getViewModel() {
        viewModel = ViewModelProviders.of(this,viewModelFactory).get(ShopDetailViewModel.class);
        return viewModel;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
