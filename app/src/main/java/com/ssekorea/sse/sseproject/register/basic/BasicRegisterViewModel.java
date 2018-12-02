package com.ssekorea.sse.sseproject.register.basic;

import android.arch.lifecycle.MutableLiveData;
import android.content.Intent;
import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;
import android.util.Log;

import com.ssekorea.sse.sseproject.base.BaseViewModel;
import com.ssekorea.sse.sseproject.data.remote.ApiHelper;
import com.ssekorea.sse.sseproject.data.remote.model.RegisterRequest;
import com.ssekorea.sse.sseproject.data.remote.model.ResponseStatus;
import com.ssekorea.sse.sseproject.domain.user.User;
import com.ssekorea.sse.sseproject.domain.user.UserRepository;
import com.ssekorea.sse.sseproject.util.FormatUtil;
import com.ssekorea.sse.sseproject.util.rx.SchedulerProvider;

public class BasicRegisterViewModel extends BaseViewModel<BasicRegisterNavigator> {

    private ObservableField<String> id = new ObservableField<>();
    private ObservableField<String> pw = new ObservableField<>();
    private ObservableField<String> name = new ObservableField<>();
    private ObservableField<String> confirmPw = new ObservableField<>();
    private ObservableField<String> birthday = new ObservableField<>();
    private ObservableField<String> phoneNumber = new ObservableField<>();
    private MutableLiveData<String> gender = new MutableLiveData<>();
    private ObservableBoolean isHeartDisease = new ObservableBoolean();
    private ObservableBoolean isCancer = new ObservableBoolean();
    private ObservableBoolean isHighBloodPressure= new ObservableBoolean();
    private ObservableBoolean isDiabetes= new ObservableBoolean();
    private ObservableBoolean isArthritis= new ObservableBoolean();
    private ObservableBoolean isDementia = new ObservableBoolean();
    private ObservableBoolean isPhoneAuthed = new ObservableBoolean(true);
    private ApiHelper apiHelper;
    private UserRepository userRepository;

    public BasicRegisterViewModel(SchedulerProvider mSchedulerProvider, ApiHelper apiHelper, UserRepository userRepository) {
        super(mSchedulerProvider);
        this.userRepository = userRepository;
        this.apiHelper = apiHelper;

    }

    public void onMaleClick() {
        gender.setValue("M");
    }

    public void onFemaleClick() {
        gender.setValue("F");
    }

    public void onAuthPhoneClick() {
        // todo navigate onAuthPhoneClick
    }

    public void onRegisterClick() {
        if (id.get() == null || ("" + id.get()).length() < 5 || ("" + id.get()).length() > 15) {
            getUiHandleError().setValue(new Throwable("아이디를 확인해주세요. 아이디는 5글자 이상, 15글자 이하 입니다."));
            return;
        }
        if (pw.get() == null || ("" + pw.get()).length() < 8) {
            getUiHandleError().setValue(new Throwable("비밀번호를 확인해주세요. 비밀번호는 8글자 이상입니다."));
            return;
        }
        if (name.get() == null || ("" + name.get()).length() < 1) {
            getUiHandleError().setValue(new Throwable("이름을 입력해주세요"));
            return;
        }
        if (confirmPw.get() == null || !("" + pw.get()).equals(confirmPw.get())) {
            getUiHandleError().setValue(new Throwable("비밀번호와 비밀번호 확인란이 일치하지 않습니다"));
            return;
        }
        if (birthday.get() == null || !FormatUtil.isBirthdayFormat(birthday.get())) {
            getUiHandleError().setValue(new Throwable("생일 형식을 확인해주세요 ex)19960407"));
            return;
        }
        if (!isPhoneAuthed.get()) {
            getUiHandleError().setValue(new Throwable("휴대폰 인증을 진행해주세요."));
            return;
        }
        User registerUser = new User();
        registerUser.setId(id.get());
        registerUser.setPw(pw.get());
        registerUser.setName(name.get());
        registerUser.setBirthday(birthday.get());
        registerUser.setPhoneNumber(phoneNumber.get());
        registerUser.setGender(gender.getValue());
        if(isHeartDisease.get()) registerUser.setHeartDisease(1);
        if(isCancer.get())registerUser.setCancer(1);
        if (isHighBloodPressure.get())registerUser.setHighBloodPressure(1);
        if (isDiabetes.get())registerUser.setDiabetes(1);
        if(isArthritis.get())registerUser.setArthritis(1);
        if(isDementia.get())registerUser.setDementia(1);
        setIsLoading(true);
        getCompositeDisposable().add(apiHelper.registerWithBasic(new RegisterRequest.BasicRegisterRequest(registerUser))
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                //.doOnSuccess(response->userRepository.setUser(registerUser))
                .subscribe(response -> {
                            setIsLoading(false);
                            switch (response.statusCode) {
                                case ResponseStatus.CODE_SUCCESS:
                                    userRepository.setUser(response.userInfoDTO);
                                    getNavigator().navigateToMain();
                                    break;
                                case ResponseStatus.CODE_INVALID_REQUEST_BODY:
                                    getUiHandleError().setValue(new Throwable("입력형식을 확인해주세요"));
                                    break;
                                default:
                                    getUiHandleError().setValue(new Throwable("Unknown Handle Response Code : " + response.statusCode));
                                    Log.e("BasicRegisterViewModel", "Unknown Handle Response Code : " + response.statusCode);
                            }
                        },
                        throwable -> {
                            setIsLoading(false);
                            Log.e("noway",""+throwable.toString());
                            getUiHandleError().setValue(throwable);
                        })
        );
    }

    public void onServiceTermClick() {
        getNavigator().popupWebView("서비스 이용약관","http://165.194.104.92:4401/service_term.html");
    }

    public void onPrivacyTermClick() {
        // todo navigate Term webview with url
        getNavigator().popupWebView("개인정보 이용약관","http://165.194.104.92:4401/privacy_term.html");
    }

    public ObservableField<String> getPw() {
        return pw;
    }

    public ObservableField<String> getConfirmPw() {
        return confirmPw;
    }

    public ObservableField<String> getBirthday() {
        return birthday;
    }

    public ObservableField<String> getPhoneNumber() {
        return phoneNumber;
    }

    public MutableLiveData<String> getGender() {
        return gender;
    }

    public ObservableBoolean getIsPhoneAuthed() {
        return isPhoneAuthed;
    }

    public ObservableField<String> getName() {
        return name;
    }

    public ObservableField<String> getId() {
        return id;
    }

    public ObservableBoolean getIsHeartDisease() {
        return isHeartDisease;
    }

    public ObservableBoolean getIsCancer() {
        return isCancer;
    }

    public ObservableBoolean getIsHighBloodPressure() {
        return isHighBloodPressure;
    }

    public ObservableBoolean getIsDiabetes() {
        return isDiabetes;
    }

    public ObservableBoolean getIsArthritis() {
        return isArthritis;
    }

    public ObservableBoolean getIsDementia() {
        return isDementia;
    }
}
