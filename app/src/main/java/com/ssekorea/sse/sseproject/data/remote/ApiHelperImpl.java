package com.ssekorea.sse.sseproject.data.remote;

import com.ssekorea.sse.sseproject.data.remote.model.LectureResponse;
import com.ssekorea.sse.sseproject.data.remote.model.LoginRequest;
import com.ssekorea.sse.sseproject.data.remote.model.LoginResponse;
import com.rx2androidnetworking.Rx2AndroidNetworking;
import com.ssekorea.sse.sseproject.data.remote.model.RegisterRequest;
import com.ssekorea.sse.sseproject.data.remote.model.RegisterResponse;
import com.ssekorea.sse.sseproject.data.remote.model.ShopResponse;

import io.reactivex.Single;
import okhttp3.RequestBody;

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
    public Single<RegisterResponse> registerWithBasic(RegisterRequest.BasicRegisterRequest request) {
        return Rx2AndroidNetworking.post(ApiEndpoint.ENDPOINT_REGISTER_BASIC)
                .addApplicationJsonBody(request.getUser())
                .build()
                .getObjectSingle(RegisterResponse.class);
    }

    @Override
    public Single<LectureResponse.GetLectureLists> getLectures() {
        return Rx2AndroidNetworking.get(ApiEndpoint.ENDPOINT_LECTURE)
                .build()
                .getObjectSingle(LectureResponse.GetLectureLists.class);
    }

    @Override
    public Single<ShopResponse.GetShopList> getShopItems() {
        return Rx2AndroidNetworking.get(ApiEndpoint.ENDPOINT_SHOP)
                .build()
                .getObjectSingle(ShopResponse.GetShopList.class);
    }
}
