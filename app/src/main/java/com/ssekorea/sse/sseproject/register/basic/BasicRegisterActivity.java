package com.ssekorea.sse.sseproject.register.basic;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.ssekorea.sse.sseproject.BR;
import com.ssekorea.sse.sseproject.R;
import com.ssekorea.sse.sseproject.base.BaseActivity;
import com.ssekorea.sse.sseproject.databinding.ActivityBasicRegisterBinding;
import com.ssekorea.sse.sseproject.main.MainActivity;
import com.ssekorea.sse.sseproject.util.UIUtil;

import javax.inject.Inject;

public class BasicRegisterActivity extends BaseActivity<ActivityBasicRegisterBinding,BasicRegisterViewModel> implements BasicRegisterNavigator {

    @Inject
    ViewModelProvider.Factory mViewModelFactory;

    private ActivityBasicRegisterBinding mActivityBasicRegisterBinding;
    private BasicRegisterViewModel mBasicRegisterViewModel;
    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_basic_register;
    }

    @Override
    public BasicRegisterViewModel getViewModel() {
        mBasicRegisterViewModel = ViewModelProviders.of(this, mViewModelFactory).get(BasicRegisterViewModel.class);
        return mBasicRegisterViewModel;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivityBasicRegisterBinding = getViewDataBinding();
        mBasicRegisterViewModel.setNavigator(this);
        mBasicRegisterViewModel.getUiHandleError().observe(this,throwable -> UIUtil.showToast(throwable != null ? throwable.getMessage() : "null message"));
        subscribeToLiveData();
    }

    private void subscribeToLiveData() {
        mBasicRegisterViewModel.getGender().observe(this,gender->{
            if ("M".equals(gender)){
                mActivityBasicRegisterBinding.basicRegisterBtnMale.setEnabled(false);
                mActivityBasicRegisterBinding.basicRegisterBtnFemale.setEnabled(true);
            }else if("F".equals(gender)){
                mActivityBasicRegisterBinding.basicRegisterBtnMale.setEnabled(true);
                mActivityBasicRegisterBinding.basicRegisterBtnFemale.setEnabled(false);
            }else{
                Log.e("BasicRegisterActivity","error while get gender : "+gender);
            }
        });
    }

    @Override
    public void navigateToMain() {
        startActivity(new Intent(BasicRegisterActivity.this,MainActivity.class));
        finish();
    }
}
