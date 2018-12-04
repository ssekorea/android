package com.ssekorea.sse.sseproject.main.shop.detail;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.ssekorea.sse.sseproject.R;
import com.ssekorea.sse.sseproject.base.BaseActivity;
import com.ssekorea.sse.sseproject.BR;
import com.ssekorea.sse.sseproject.common.GlideApp;
import com.ssekorea.sse.sseproject.common.SSECode;
import com.ssekorea.sse.sseproject.databinding.ActivityShopDetailBinding;
import com.ssekorea.sse.sseproject.domain.shop.Product;

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
        Intent intent = getIntent();
        Product product = (Product)intent.getSerializableExtra("product");
        viewModel.onProductLoad(product);
        viewModel.setNavigator(this);
        activityShopDetailBinding = getViewDataBinding();
        activityShopDetailBinding.imgSmall1.setVisibility(View.INVISIBLE);
        activityShopDetailBinding.imgSmall2.setVisibility(View.INVISIBLE);
        if(product.getProductImageUrls().size()>0) {
            GlideApp.with(activityShopDetailBinding.imgMain)
                    .load(product.getProductImageUrls().get(0))
                    .centerCrop()
                    .into(activityShopDetailBinding.imgMain);
            GlideApp.with(activityShopDetailBinding.imgMainBig)
                    .load(product.getProductImageUrls().get(0))
                    .centerCrop()
                    .into(activityShopDetailBinding.imgMainBig);
        }
        if(product.getProductImageUrls().size()>1){
            GlideApp.with(activityShopDetailBinding.imgSmall1)
                    .load(product.getProductImageUrls().get(1))
                    .centerCrop()
                    .into(activityShopDetailBinding.imgSmall1);
            activityShopDetailBinding.imgSmall1.setVisibility(View.VISIBLE);
        }else{
            activityShopDetailBinding.imgSmall1.setVisibility(View.GONE);
            activityShopDetailBinding.imgSmall2.setVisibility(View.GONE);
        }
        if(product.getProductImageUrls().size()>2){
            GlideApp.with(activityShopDetailBinding.imgSmall2)
                    .load(product.getProductImageUrls().get(2))
                    .centerCrop()
                    .into(activityShopDetailBinding.imgSmall2);
            activityShopDetailBinding.imgSmall2.setVisibility(View.VISIBLE);
        }
        viewModel.getPayMethodLiveData().observe(this,data->{
            switch (data){
                case SSECode.PAYMENT_BANK:
                    activityShopDetailBinding.btnBank.setEnabled(false);
                    break;
                case SSECode.PAYMENT_CARD:
                    Toast.makeText(this, "현재 무통장 입금만 지원됩니다.", Toast.LENGTH_SHORT).show();
                    break;
            }
        });

        activityShopDetailBinding.btnBank.performClick();
    }

    @Override
    public void finishBuyWithSuccess() {
        Toast.makeText(this, "구매요청에 성공했습니다. 계좌번호로 입금해주세요.", Toast.LENGTH_SHORT).show();
        finish();
    }
}
