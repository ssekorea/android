package com.ssekorea.sse.sseproject.register;

import android.arch.lifecycle.MutableLiveData;
import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;
import android.widget.Toast;

import com.ssekorea.sse.sseproject.base.BaseViewModel;
import com.ssekorea.sse.sseproject.data.remote.ApiHelper;
import com.ssekorea.sse.sseproject.data.remote.model.LoginRequest;
import com.ssekorea.sse.sseproject.data.remote.model.RegisterRequest;
import com.ssekorea.sse.sseproject.domain.user.User;
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
    private ObservableBoolean isPhoneAuthed = new ObservableBoolean(true);
    private ApiHelper apiHelper;
    public BasicRegisterViewModel(SchedulerProvider mSchedulerProvider) {
        super(mSchedulerProvider);

    }

    public void onMaleClick(){
        gender.setValue("M");
    }

    public void onFemaleClick(){
        gender.setValue("F");
    }

    public void onAuthPhoneClick(){
        // todo navigate onAuthPhoneClick
    }

    public void onRegisterClick(){
        if (id.get() == null || (""+id.get()).length()< 5 || (""+id.get()).length()> 15 ){
            getUiHandleError().setValue(new Throwable("아이디를 확인해주세요. 아이디는 5글자 이상, 15글자 이하 입니다."));
            return;
        }
        if (pw.get() == null || (""+pw.get()).length()< 8){
            getUiHandleError().setValue(new Throwable("비밀번호를 확인해주세요. 비밀번호는 8글자 이상입니다."));
            return;
        }
        if (confirmPw.get() == null || !(""+pw.get()).equals(confirmPw.get())){
            getUiHandleError().setValue(new Throwable("비밀번호와 비밀번호 확인란이 일치하지 않습니다"));
            return;
        }
        if (birthday.get() == null || !FormatUtil.isBirthdayFormat(birthday.get())){
            getUiHandleError().setValue(new Throwable("생일 형식을 확인해주세요 ex)19960407"));
            return;
        }
        if (!isPhoneAuthed.get()){
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
        // todo getUiHandleError().setValue(apiHelper.(new RegisterRequest.BasicRegisterRequest(registerUser)));
    }
    public void onServiceTermClick(){
        // todo navigate Term webview with url
    }
    public void onPrivacyTermClick(){
        // todo navigate Term webview with url
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
}
