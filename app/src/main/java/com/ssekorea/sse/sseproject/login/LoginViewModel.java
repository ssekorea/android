package com.ssekorea.sse.sseproject.login;

import android.util.Log;

import com.bumptech.glide.load.HttpException;
import com.facebook.AccessToken;
import com.kakao.usermgmt.response.model.UserProfile;
import com.ssekorea.sse.sseproject.base.BaseViewModel;
import com.ssekorea.sse.sseproject.data.remote.ApiHelper;
import com.ssekorea.sse.sseproject.data.remote.model.LoginRequest;
import com.ssekorea.sse.sseproject.data.remote.model.ResponseStatus;
import com.ssekorea.sse.sseproject.domain.user.User;
import com.ssekorea.sse.sseproject.domain.user.UserRepository;
import com.ssekorea.sse.sseproject.util.rx.SchedulerProvider;

import org.json.JSONException;
import org.json.JSONObject;

public class LoginViewModel extends BaseViewModel<LoginNavigator> {
    private UserRepository userRepository;
    private ApiHelper apiHelper;


    public LoginViewModel(SchedulerProvider mSchedulerProvider, ApiHelper apiHelper, UserRepository userRepository) {
        super(mSchedulerProvider);
        this.apiHelper = apiHelper;
        this.userRepository = userRepository;
    }

    public void tryLoginWithFacebook(JSONObject fbJsonData) {
        setIsLoading(true);
        String id;
        String token = AccessToken.getCurrentAccessToken().getToken();
        String firstName = "";
        String lastName = "";
        if (token == null || token.equals("")) {
            getUiHandleError().setValue(new Throwable("페이스북 로그인 오류. 다른 방법을 이용해 주세요"));
            Log.e("LoginViewModel", "statusCode while get current token in tryLoginWithFacebook");
            return;
        }
        try {
            id = fbJsonData.getString("id");
        } catch (JSONException e) {
            e.printStackTrace();
            getUiHandleError().setValue(new Throwable("페이스북 로그인 오류. 다른 방법을 이용해 주세요"));
            Log.e("LoginViewModel", "statusCode while get facebook Id in tryLoginWithFacebook");
            return;
        }
        try {
            firstName = fbJsonData.getString("first_name");
        } catch (JSONException e) {

        }
        try {
            lastName = fbJsonData.getString("last_name");
        } catch (JSONException e) {

        }
        Log.e("LoginViewModel", fbJsonData.toString());
        String finalFirstName = firstName;
        String finalLastName = lastName;
        getCompositeDisposable().add(apiHelper.loginWithFacebook(new LoginRequest.FacebookLoginRequest(id, token))
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(
                        loginResponse -> {
                            setIsLoading(false);
                            userRepository.setUser(loginResponse.userInfoDTO);
                            Log.e("와우", "잘됨");
                            Log.e("와우", loginResponse.userInfoDTO.toString());
                            getNavigator().navigateToMain();

                        }, throwable -> {
                            setIsLoading(false);
                            HttpException exception = (HttpException) throwable;
                            switch (exception.getStatusCode()) {
                                case 400:
                                    User user = new User();
                                    user.setId(String.valueOf(id));
                                    user.setAccessToken(token);
                                    user.setName(finalFirstName + finalLastName);
                                    userRepository.setUser(user);
                                    getUiHandleError().setValue(throwable);
                                    getNavigator().navigateToRegisterSocial();
                                default:
                                    getUiHandleError().setValue(new Throwable("요청오류 . ERROR CODE : " + exception.getStatusCode()));
                                    Log.e("LoginViewModel", "invalid response code " + exception.getStatusCode());
                                    break;
                            }
                        }));
    }

    public void tryLoginWithBasic(String id, String pw) {
        setIsLoading(true);
        getCompositeDisposable().add(apiHelper.loginWithBasic(new LoginRequest.BasicLoginRequest(id, pw))
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .doOnSuccess(response -> {
                    if (response.statusCode.equals(ResponseStatus.CODE_SUCCESS))
                        userRepository.setUser(response.userInfoDTO);
                })
                .subscribe(response -> {
                    setIsLoading(false);
                    userRepository.setUser(response.userInfoDTO);
                    Log.e("와우", "잘됨");
                    Log.e("와우", response.userInfoDTO.toString());
                    getNavigator().navigateToMain();

                }, error -> {
                    setIsLoading(false);
                    getUiHandleError().setValue(error);
                    HttpException exception = (HttpException) error;
                    switch (String.valueOf(exception.getStatusCode())) {

                        case ResponseStatus.CODE_INVALID_USER:
                            getUiHandleError().setValue(new Throwable("존재하지 않는 유저입니다."));
                            Log.e("LoginViewModel", "invalid userInfoDTO , " + id + pw);
                            break;
                        case ResponseStatus.CODE_INVALID_REQUEST_BODY:
                            getUiHandleError().setValue(new Throwable("아이디와 비밀번호 입력 형식을 확인해주세요"));
                            Log.e("LoginViewModel", "invalid request, " + id + pw);
                            break;
                        default:
                            getUiHandleError().setValue(new Throwable("요청오류 . ERROR CODE : " + exception.getStatusCode()));
                            Log.e("LoginViewModel", "invalid response code " + exception.getStatusCode());
                            break;
                    }
                }));
    }

    public void tryLoginWithKakao(UserProfile userProfile, String accessToken) {
        setIsLoading(true);
        Log.d("LoginModel", "tryLoginWithKakao: " + userProfile.getId() + "," + userProfile.getNickname());
        getCompositeDisposable().add(apiHelper.loginWithKakao(new LoginRequest.KakaoLoginRequest(String.valueOf(userProfile.getId()), accessToken))
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(
                        loginResponse -> {
                            setIsLoading(false);
                            userRepository.setUser(loginResponse.userInfoDTO);
                            getNavigator().navigateToMain();
                        },
                        throwable -> {
                            setIsLoading(false);
                            HttpException exception = (HttpException) throwable;
                            switch (exception.getStatusCode()) {
                                case 400:
                                    User user = new User();
                                    user.setId(String.valueOf(userProfile.getId()));
                                    user.setAccessToken(accessToken);
                                    user.setName(userProfile.getNickname());
                                    userRepository.setUser(user);
                                    getUiHandleError().setValue(throwable);
                                    getNavigator().navigateToRegisterSocial();
                                default:
                                    getUiHandleError().setValue(new Throwable("요청오류 . ERROR CODE : " + exception.getStatusCode()));
                                    Log.e("LoginViewModel", "invalid response code " + exception.getStatusCode());
                                    break;
                            }
                        }
                ));
    }

    public void onRegisterClick() {
        getNavigator().navigateToBasicRegister();
    }
}
