package com.ssekorea.sse.sseproject.data.remote;

import android.content.Intent;
import android.support.annotation.NonNull;

import com.androidnetworking.AndroidNetworking;
import com.ssekorea.sse.sseproject.SseApp;
import com.ssekorea.sse.sseproject.data.remote.model.BuyRequest;
import com.ssekorea.sse.sseproject.data.remote.model.CodeResponse;
import com.ssekorea.sse.sseproject.data.remote.model.FeedResponse;
import com.ssekorea.sse.sseproject.data.remote.model.LectureResponse;
import com.ssekorea.sse.sseproject.data.remote.model.LoginRequest;
import com.ssekorea.sse.sseproject.data.remote.model.LoginResponse;
import com.rx2androidnetworking.Rx2AndroidNetworking;
import com.ssekorea.sse.sseproject.data.remote.model.RegisterRequest;
import com.ssekorea.sse.sseproject.data.remote.model.RegisterResponse;
import com.ssekorea.sse.sseproject.data.remote.model.ShopResponse;
import com.ssekorea.sse.sseproject.domain.user.UserRepository;
import com.ssekorea.sse.sseproject.login.LoginActivity;

import java.io.IOException;

import io.reactivex.Single;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

public class ApiHelperImpl implements ApiHelper {
    private final UserRepository userRepository;

    public ApiHelperImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
        OkHttpClient okHttpClient = new OkHttpClient()
                .newBuilder()
                .addInterceptor(chain -> {
                    Request request = chain.request();
                    okhttp3.Response response = chain.proceed(request);
                    if (response.code() == 403) {
                        Intent loginIntent = new Intent(
                                SseApp.getAppContext(),
                                LoginActivity.class
                        );
                        loginIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        SseApp.getAppContext().startActivity(loginIntent);
                        return response;
                    }
                    return response;
                })
                .build();
        AndroidNetworking.initialize(SseApp.getAppContext(),okHttpClient);
    }

    @Override
    public Single<LoginResponse> loginWithBasic(LoginRequest.BasicLoginRequest request) {
        return Rx2AndroidNetworking.post(ApiEndpoint.ENDPOINT_LOGIN_BASIC)
                .addApplicationJsonBody(request)
                .build()
                .getObjectSingle(LoginResponse.class);
    }

    @Override
    public Single<LoginResponse> loginWithFacebook(LoginRequest.FacebookLoginRequest request) {
        return Rx2AndroidNetworking.post(ApiEndpoint.ENDPOINT_LOGIN_FACEBOOK)
                .addApplicationJsonBody(request)
                .build()
                .getObjectSingle(LoginResponse.class);
    }

    @Override
    public Single<LoginResponse> loginWithKakao(LoginRequest.KakaoLoginRequest request) {
        return Rx2AndroidNetworking.post(ApiEndpoint.ENDPOINT_LOGIN_KAKAO)
                .addApplicationJsonBody(request)
                .build()
                .getObjectSingle(LoginResponse.class);
    }

    @Override
    public Single<RegisterResponse> registerWithBasic(RegisterRequest.BasicRegisterRequest request) {
        return Rx2AndroidNetworking.post(ApiEndpoint.ENDPOINT_REGISTER_BASIC+"/{userId}")
                .addPathParameter("userId",request.userId)
                .addApplicationJsonBody(request)
                .build()
                .getObjectSingle(RegisterResponse.class);
    }


    @Override
    public Single<RegisterResponse> registerWithFacebook(RegisterRequest.FacebookRegisterRequest request) {
        request.registerType = "FACEBOOK";
        return Rx2AndroidNetworking.post(ApiEndpoint.ENDPOINT_REGISTER_FACEBOOK)
                .addPathParameter("userId",request.userId)
                .addApplicationJsonBody(request)
                .build()
                .getObjectSingle(RegisterResponse.class);
    }


    @Override
    public Single<RegisterResponse> registerWithKakao(RegisterRequest.KakaokRegisterRequest request) {
        request.registerType = "KAKAO";
        return Rx2AndroidNetworking.post(ApiEndpoint.ENDPOINT_REGISTER_KAKAO)
                .addPathParameter("userId",request.userId)
                .addApplicationJsonBody(request)
                .build()
                .getObjectSingle(RegisterResponse.class);
    }

    @Override
    public Single<LectureResponse.GetLectureLists> getLectures() {
        return Rx2AndroidNetworking.get(ApiEndpoint.ENDPOINT_LECTURE)
                .addHeaders("Authorization",userRepository.getUser().getAccessToken())
                .build()
                .getObjectSingle(LectureResponse.GetLectureLists.class);
    }

    @Override
    public Single<ShopResponse.GetShopList> getShopItems() {
        return Rx2AndroidNetworking.get(ApiEndpoint.ENDPOINT_SHOP)
                .addHeaders("Authorization",userRepository.getUser().getAccessToken())
                .build()
                .getObjectSingle(ShopResponse.GetShopList.class);
    }

    @Override
    public Single<FeedResponse.GetFeedList> getFeedList(){
        return Rx2AndroidNetworking.get(ApiEndpoint.ENDPOINT_FEED)
                .addHeaders("Authorization",userRepository.getUser().getAccessToken())
                .build()
                .getObjectSingle(FeedResponse.GetFeedList.class);
    }

    @Override
    public Single<CodeResponse> buyProduct(String userId, BuyRequest buyRequest) {
        return Rx2AndroidNetworking.post(ApiEndpoint.ENDPOINT_BUY)
                .addPathParameter("userId",userId)
                .addApplicationJsonBody(buyRequest)
                .addHeaders("Authorization",userRepository.getUser().getAccessToken())
                .build()
                .getObjectSingle(CodeResponse.class);
    }
}
