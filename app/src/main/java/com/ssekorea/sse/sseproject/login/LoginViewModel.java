package com.ssekorea.sse.sseproject.login;

import android.util.Log;

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
        String id;
        String token = AccessToken.getCurrentAccessToken().getToken();
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
        Log.e("LoginViewModel",fbJsonData.toString());
        getCompositeDisposable().add(apiHelper.loginWithFacebook(new LoginRequest.FacebookLoginRequest(id, token))
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(
                        loginResponse -> {
                            switch (loginResponse.statusCode) {
                                case ResponseStatus.CODE_SUCCESS:
                                    userRepository.setUser(loginResponse.userInfoDTO);
                                    Log.e("와우","잘됨");
                                    Log.e("와우",loginResponse.userInfoDTO.toString());
                                    //todo navigate to main
                                    break;
                                case ResponseStatus.CODE_INVALID_USER:
                                    User user = new User();
                                    user.setId(id);
                                    user.setAccessToken(token);
                                    user.setName(fbJsonData.getString("name"));
                                    userRepository.setUser(user);
                                    //todo navigate to register_for_social
                                    break;
                                default:
                                    getUiHandleError().setValue(new Throwable("요청오류 . ERROR CODE : " + loginResponse.statusCode));
                                    Log.e("LoginViewModel", "invalid response code " + loginResponse.statusCode);
                                    break;
                            }
                        }, throwable -> getUiHandleError().setValue(throwable)));
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
                    switch (response.statusCode) {
                        case ResponseStatus.CODE_SUCCESS:
                            userRepository.setUser(response.userInfoDTO);
                            Log.e("와우","잘됨");
                            Log.e("와우",response.userInfoDTO.toString());
                            getNavigator().navigateToBasicRegister();
                            break;
                        case ResponseStatus.CODE_INVALID_USER:
                            getUiHandleError().setValue(new Throwable("존재하지 않는 유저입니다."));
                            Log.e("LoginViewModel", "invalid userInfoDTO , " + id + pw);
                            break;
                        case ResponseStatus.CODE_INVALID_REQUEST_BODY:
                            getUiHandleError().setValue(new Throwable("아이디와 비밀번호 입력 형식을 확인해주세요"));
                            Log.e("LoginViewModel", "invalid request, " + id + pw);
                            break;
                        default:
                            getUiHandleError().setValue(new Throwable("요청오류 . ERROR CODE : " + response.statusCode));
                            Log.e("LoginViewModel", "invalid response code " + response.statusCode);
                            break;
                    }
                }, error -> {
                    setIsLoading(false);
                    getUiHandleError().setValue(error);
                }));
    }

    public void tryLoginWithKakao(UserProfile userProfile,String accessToken) {
        Log.d("LoginModel", "tryLoginWithKakao: " + userProfile.getId() + "," + userProfile.getNickname());
        getCompositeDisposable().add(apiHelper.loginWithKakao(new LoginRequest.KakaoLoginRequest(String.valueOf(userProfile.getId()), accessToken))
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(
                        loginResponse -> {
                            switch (loginResponse.statusCode) {
                                case ResponseStatus.CODE_SUCCESS:
                                    userRepository.setUser(loginResponse.userInfoDTO);
                                    //todo navigate to main
                                    break;
                                case ResponseStatus.CODE_INVALID_USER:
                                    User user = new User();
                                    user.setId(String.valueOf(userProfile.getId()));
                                    user.setAccessToken(accessToken);
                                    user.setName(userProfile.getNickname());
                                    userRepository.setUser(user);
                                    //todo navigate to register_for_social
                                    break;
                                default:
                                    getUiHandleError().setValue(new Throwable("요청오류 . ERROR CODE : " + loginResponse.statusCode));
                                    Log.e("LoginViewModel", "invalid response code " + loginResponse.statusCode);
                                    break;
                            }
                        },
                        throwable ->getUiHandleError().setValue(throwable)
                ));
    }

    public void onRegisterClick(){
        getNavigator().navigateToBasicRegister();
    }
}
