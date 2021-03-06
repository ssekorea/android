package com.ssekorea.sse.sseproject.data.remote;

import com.ssekorea.sse.sseproject.data.remote.model.BuyRequest;
import com.ssekorea.sse.sseproject.data.remote.model.CodeResponse;
import com.ssekorea.sse.sseproject.data.remote.model.FeedResponse;
import com.ssekorea.sse.sseproject.data.remote.model.LectureResponse;
import com.ssekorea.sse.sseproject.data.remote.model.LoginRequest;
import com.ssekorea.sse.sseproject.data.remote.model.LoginResponse;
import com.ssekorea.sse.sseproject.data.remote.model.RegisterRequest;
import com.ssekorea.sse.sseproject.data.remote.model.RegisterResponse;
import com.ssekorea.sse.sseproject.data.remote.model.ShopResponse;

import io.reactivex.Single;
import io.reactivex.disposables.Disposable;

public interface ApiHelper {
    Single<LoginResponse> loginWithBasic(LoginRequest.BasicLoginRequest basicLoginRequest);

    Single<LoginResponse> loginWithFacebook(LoginRequest.FacebookLoginRequest request);

    Single<LoginResponse> loginWithKakao(LoginRequest.KakaoLoginRequest request);

    Single<RegisterResponse> registerWithBasic(RegisterRequest.BasicRegisterRequest request);

    Single<RegisterResponse> registerWithFacebook(RegisterRequest.FacebookRegisterRequest request);

    Single<RegisterResponse> registerWithKakao(RegisterRequest.KakaokRegisterRequest request);

    Single<LectureResponse.GetLectureLists> getLectures();

    Single<ShopResponse.GetShopList> getShopItems();

    Single<FeedResponse.GetFeedList> getFeedList();

    Single<CodeResponse> buyProduct(String userId, BuyRequest buyRequest);
}
