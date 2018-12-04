package com.ssekorea.sse.sseproject.main;

import android.arch.lifecycle.MutableLiveData;
import android.databinding.ObservableField;
import android.support.v4.app.Fragment;

import com.ssekorea.sse.sseproject.base.BaseViewModel;
import com.ssekorea.sse.sseproject.main.etc.EtcFragment;
import com.ssekorea.sse.sseproject.main.feed.FeedFragment;
import com.ssekorea.sse.sseproject.main.lecture.LectureFragment;
import com.ssekorea.sse.sseproject.main.myinfo.MyInfoFragment;
import com.ssekorea.sse.sseproject.main.shop.ShopFragment;
import com.ssekorea.sse.sseproject.util.rx.SchedulerProvider;

public class MainViewModel extends BaseViewModel {
    public ObservableField<String> title;
    private MutableLiveData<Fragment> selectedFragment = new MutableLiveData<>();
    private FeedFragment feedFragment;
    private LectureFragment lectureFragment;
    private ShopFragment shopFragment;
    private MyInfoFragment myInfoFragment;
    private EtcFragment etcFragment;

    public MainViewModel(SchedulerProvider mSchedulerProvider) {
        super(mSchedulerProvider);
        title = new ObservableField<>();
        feedFragment = new FeedFragment();
        lectureFragment = LectureFragment.newInstance();
        shopFragment = ShopFragment.newInstance();
        myInfoFragment = new MyInfoFragment();
        etcFragment = new EtcFragment();
        selectedFragment.setValue(feedFragment);
        title.set("피드");
    }

    public MutableLiveData<Fragment> getSelectedFragment() {
        return selectedFragment;
    }

    public void onHomeClick() {
        selectedFragment.setValue(feedFragment);
        title.set("피드");
    }

    public void onLectureClick() {
        selectedFragment.setValue(lectureFragment);
        title.set("강의목록");
    }

    public void onShopClick() {
        selectedFragment.setValue(shopFragment);
        title.set("쇼핑몰");
    }

    public void onMyInfoClick() {
        selectedFragment.setValue(myInfoFragment);
        title.set("내정보");
    }

    public void onEtcClick() {
        selectedFragment.setValue(etcFragment);
        title.set("기타");
    }
}
