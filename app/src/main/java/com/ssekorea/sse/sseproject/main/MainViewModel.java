package com.ssekorea.sse.sseproject.main;

import android.arch.lifecycle.MutableLiveData;
import android.databinding.ObservableField;
import android.support.v4.app.Fragment;

import com.ssekorea.sse.sseproject.base.BaseFragment;
import com.ssekorea.sse.sseproject.base.BaseViewModel;
import com.ssekorea.sse.sseproject.main.etc.EtcFragment;
import com.ssekorea.sse.sseproject.main.home.HomeFragment;
import com.ssekorea.sse.sseproject.main.lecture.LectureFragment;
import com.ssekorea.sse.sseproject.main.myinfo.MyInfoFragment;
import com.ssekorea.sse.sseproject.main.shop.ShopFragment;
import com.ssekorea.sse.sseproject.util.rx.SchedulerProvider;

public class MainViewModel extends BaseViewModel {
    public ObservableField<String> title;
    private MutableLiveData<Fragment> selectedFragment = new MutableLiveData<>();
    private HomeFragment homeFragment;
    private LectureFragment lectureFragment;
    private ShopFragment shopFragment;
    private MyInfoFragment myInfoFragment;
    private EtcFragment etcFragment;

    public MainViewModel(SchedulerProvider mSchedulerProvider) {
        super(mSchedulerProvider);
        title = new ObservableField<>();
        homeFragment = new HomeFragment();
        lectureFragment = LectureFragment.newInstance();
        shopFragment = ShopFragment.newInstance();
        myInfoFragment = new MyInfoFragment();
        etcFragment = new EtcFragment();
        selectedFragment.setValue(homeFragment);
    }

    public MutableLiveData<Fragment> getSelectedFragment() {
        return selectedFragment;
    }

    public void onHomeClick() {
        selectedFragment.setValue(homeFragment);
    }

    public void onLectureClick() {
        selectedFragment.setValue(lectureFragment);
    }

    public void onShopClick() {
        selectedFragment.setValue(shopFragment);
    }

    public void onMyInfoClick() {
        selectedFragment.setValue(myInfoFragment);
    }

    public void onEtcClick() {
        selectedFragment.setValue(etcFragment);
    }
}
