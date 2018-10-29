package com.ssekorea.sse.sseproject.data.remote;

import com.ssekorea.sse.sseproject.data.remote.model.LoginRequest;
import com.ssekorea.sse.sseproject.data.remote.model.LoginResponse;
import com.rx2androidnetworking.Rx2AndroidNetworking;
import com.ssekorea.sse.sseproject.data.remote.model.RegisterRequest;
import com.ssekorea.sse.sseproject.data.remote.model.RegisterResponse;

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

    @Override
    public Single<RegisterResponse> registerWithBasic(RegisterRequest request) {
        return Rx2AndroidNetworking.post(ApiEndpoint.ENDPOINT_REGISTER_BASIC)
                .addApplicationJsonBody(request)
                .build()
                .getObjectSingle(RegisterResponse.class);
    }
}
