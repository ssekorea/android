package com.ssekorea.sse.sseproject.main;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;

import com.ssekorea.sse.sseproject.R;

import com.ssekorea.sse.sseproject.BR;
import com.ssekorea.sse.sseproject.base.BaseActivity;
import com.ssekorea.sse.sseproject.databinding.ActivityMainBinding;
import com.ssekorea.sse.sseproject.main.etc.EtcFragment;
import com.ssekorea.sse.sseproject.main.feed.FeedFragment;
import com.ssekorea.sse.sseproject.main.lecture.LectureFragment;
import com.ssekorea.sse.sseproject.main.myinfo.MyInfoFragment;
import com.ssekorea.sse.sseproject.main.shop.ShopFragment;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;

public class MainActivity extends BaseActivity<ActivityMainBinding,MainViewModel> implements HasSupportFragmentInjector {
    @Inject
    DispatchingAndroidInjector<Fragment> fragmentDispatchingAndroidInjector;
    @Inject
    MainViewModel mainViewModel;

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public MainViewModel getViewModel() {
        return mainViewModel;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        subscribeLiveData();
    }

    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return fragmentDispatchingAndroidInjector;
    }

    private void subscribeLiveData() {
        getViewModel().getSelectedFragment().observe(this,fragment -> {
            if (fragment!=null) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.fragment_place, fragment);
                transaction.commit();
            }
            if(fragment instanceof FeedFragment)
                setButtonDisabled(findViewById(R.id.btn_home));
            if(fragment instanceof LectureFragment)
                setButtonDisabled(findViewById(R.id.btn_lecture));
            if(fragment instanceof ShopFragment)
                setButtonDisabled(findViewById(R.id.btn_shop));
            if(fragment instanceof MyInfoFragment)
                setButtonDisabled(findViewById(R.id.btn_myInfo));
            if(fragment instanceof EtcFragment)
                setButtonDisabled(findViewById(R.id.btn_etc));
        });
    }

    private void setButtonDisabled(View view) {
        findViewById(R.id.btn_home).setEnabled(true);
        findViewById(R.id.btn_lecture).setEnabled(true);
        findViewById(R.id.btn_shop).setEnabled(true);
        findViewById(R.id.btn_myInfo).setEnabled(true);
        findViewById(R.id.btn_etc).setEnabled(true);
        view.setEnabled(false);
    }

}
