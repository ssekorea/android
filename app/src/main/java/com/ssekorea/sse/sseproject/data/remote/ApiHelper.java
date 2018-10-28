package com.ssekorea.sse.sseproject.data.remote;

import com.ssekorea.sse.sseproject.data.remote.model.LoginRequest;
import com.ssekorea.sse.sseproject.data.remote.model.LoginResponse;

import io.reactivex.Single;

public interface ApiHelper {
    Single<LoginResponse> loginWithBasic(LoginRequest.BasicLoginRequest basicLoginRequest);

    Single<LoginResponse> loginWithFacebook(LoginRequest.FacebookLoginRequest request);

    Single<LoginResponse> loginWithKakao(LoginRequest.KakaoLoginRequest request);
}
