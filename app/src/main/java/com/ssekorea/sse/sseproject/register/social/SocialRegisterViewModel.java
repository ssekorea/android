package com.ssekorea.sse.sseproject.register.social;

import android.databinding.ObservableField;

import com.ssekorea.sse.sseproject.base.BaseViewModel;
import com.ssekorea.sse.sseproject.data.remote.ApiHelper;
import com.ssekorea.sse.sseproject.domain.user.UserRepository;
import com.ssekorea.sse.sseproject.util.rx.SchedulerProvider;

public class SocialRegisterViewModel extends BaseViewModel<SocialRegisterNavigator> {
    private final UserRepository userRepository;
    private final ApiHelper apiHelper;
    private ObservableField<String> phoneNumber = new ObservableField<>();

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
