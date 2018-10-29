package com.ssekorea.sse.sseproject.login;

import com.ssekorea.sse.sseproject.base.BaseViewModel;
import com.ssekorea.sse.sseproject.util.rx.SchedulerProvider;

import org.json.JSONObject;

public class LoginViewModel extends BaseViewModel<LoginNavigator> {
    public LoginViewModel(SchedulerProvider mSchedulerProvider) {
        super(mSchedulerProvider);
    }

    public void LoginWithFacebook(JSONObject fbJsonData){
        getNavigator().makeTestToast(fbJsonData.toString());
    }

    public void FalseFunction(){
        setIsLoading(false);
    }

    public void TrueFunction(){
        setIsLoading(true);
    }
}
