package com.example.sse.sseproject.data.remote;

import com.example.sse.sseproject.data.remote.model.LoginRequest;
import com.example.sse.sseproject.data.remote.model.LoginResponse;
import com.rx2androidnetworking.Rx2AndroidNetworking;

import io.reactivex.Single;

public class ApiHelperImpl implements ApiHelper {

    @Override
    public Single<LoginResponse> loginWithBasic(LoginRequest.BasicLoginRequest request) {
        return Rx2AndroidNetworking.post(ApiEndpoint.ENDPOINT_LOGIN_BASIC)
                .addApplicationJsonBody(request)
                .build()
                .getObjectSingle(LoginResponse.class);
    }

    @Override
    public Single<LoginResponse> loginWithFacebook(LoginRequest.FacebookLoginRequest request) {
        return Rx2AndroidNetworking.post(ApiEndpoint.ENDPOINT_LOGIN_BASIC)
                .addApplicationJsonBody(request)
                .build()
                .getObjectSingle(LoginResponse.class);
    }

    @Override
    public Single<LoginResponse> loginWithKakao(LoginRequest.KakaoLoginRequest request) {
        return Rx2AndroidNetworking.post(ApiEndpoint.ENDPOINT_LOGIN_BASIC)
                .addApplicationJsonBody(request)
                .build()
                .getObjectSingle(LoginResponse.class);
    }
}
