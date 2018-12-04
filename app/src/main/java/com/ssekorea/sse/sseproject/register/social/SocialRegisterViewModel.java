package com.ssekorea.sse.sseproject.register.social;

import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;

import com.ssekorea.sse.sseproject.base.BaseViewModel;
import com.ssekorea.sse.sseproject.data.remote.ApiHelper;
import com.ssekorea.sse.sseproject.domain.user.UserRepository;
import com.ssekorea.sse.sseproject.util.rx.SchedulerProvider;

public class SocialRegisterViewModel extends BaseViewModel<SocialRegisterNavigator> {
    public final UserRepository userRepository;
    public final ApiHelper apiHelper;
    public ObservableField<String> phoneNumber = new ObservableField<>();
    public ObservableField<String> birthday = new ObservableField<>();
    public ObservableBoolean isHeartDisease = new ObservableBoolean();
    public ObservableBoolean isCancer = new ObservableBoolean();
    public ObservableBoolean isHighBloodPressure= new ObservableBoolean();
    public ObservableBoolean isDiabetes= new ObservableBoolean();
    public ObservableBoolean isArthritis= new ObservableBoolean();
    public ObservableBoolean isDementia = new ObservableBoolean();
    public ObservableBoolean isPhoneAuthed = new ObservableBoolean(true);
    public SocialRegisterViewModel(SchedulerProvider mSchedulerProvider, ApiHelper apiHelper, UserRepository userRepository) {
        super(mSchedulerProvider);
        this.apiHelper = apiHelper;
        this.userRepository = userRepository;
    }
    public ObservableField<String> getPhoneNumber(){
        return phoneNumber;
    }
    public void onAuthPhoneClick(){

    }

    public void onPrivacyTermClick(){

    }

    public void onServiceTermClick(){

    }

    public void onRegisterClick(){

    }
}
