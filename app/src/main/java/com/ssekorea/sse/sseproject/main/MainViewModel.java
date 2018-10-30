package com.ssekorea.sse.sseproject.main;

import android.arch.lifecycle.MutableLiveData;
import android.databinding.ObservableField;
import android.support.v4.app.Fragment;

import com.ssekorea.sse.sseproject.base.BaseFragment;
import com.ssekorea.sse.sseproject.base.BaseViewModel;
import com.ssekorea.sse.sseproject.main.home.HomeFragment;
import com.ssekorea.sse.sseproject.main.lecture.LectureFragment;
import com.ssekorea.sse.sseproject.util.rx.SchedulerProvider;

public class MainViewModel extends BaseViewModel {
    private MutableLiveData<Fragment> selectedFragment= new MutableLiveData<>();
    HomeFragment homeFragment;
    LectureFragment lectureFragment;
    public MainViewModel(SchedulerProvider mSchedulerProvider) {
        super(mSchedulerProvider);
        homeFragment = new HomeFragment();
        lectureFragment = LectureFragment.newInstance();
        selectedFragment.setValue(homeFragment);
    }

    public MutableLiveData<Fragment> getSelectedFragment() {
        return selectedFragment;
    }

    public void onHomeClick(){
        selectedFragment.setValue(homeFragment);
    }

    public void onLectureClick(){
        selectedFragment.setValue(lectureFragment);
    }

    public void onShopClick(){

    }

    public void onMyInfoClick(){

    }

    public void onEtcClick(){

    }
}
