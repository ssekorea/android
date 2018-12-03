package com.ssekorea.sse.sseproject.register.social;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;

import com.ssekorea.sse.sseproject.BR;
import com.ssekorea.sse.sseproject.R;
import com.ssekorea.sse.sseproject.base.BaseActivity;
import com.ssekorea.sse.sseproject.databinding.ActivitySocialRegisterBinding;

import javax.inject.Inject;

public class SocialRegisterActivity extends BaseActivity<ActivitySocialRegisterBinding,SocialRegisterViewModel> {

    @Inject
    ViewModelProvider.Factory mViewModelFactory;

    private ActivitySocialRegisterBinding mActivitySocialRegisterBinding;
    private SocialRegisterViewModel mBasicRegisterViewModel;
    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }


    @Override
    public int getLayoutId() {
        return R.layout.activity_social_register;
    }

    @Override
    public SocialRegisterViewModel getViewModel() {
        mBasicRegisterViewModel = ViewModelProviders.of(this, mViewModelFactory).get(SocialRegisterViewModel.class);
        return mBasicRegisterViewModel ;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
