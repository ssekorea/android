package com.example.sse.sseproject.data.remote;

import com.example.sse.sseproject.common.Config;

public class ApiEndpoint {
    public static final String ENDPOINT_REGISTER_BASIC = Config.BASE_URL +"/auth"; //todo
    public static final String ENDPOINT_REGISTER_FACEBOOK = Config.BASE_URL; // todo
    public static final String ENDPOINT_REGISTER_KAKAO = Config.BASE_URL; // todo
    public static final String ENDPOINT_LOGIN_BASIC = Config.BASE_URL+"/login"; // todo
    public static final String ENDPOINT_LOGIN_FACEBOOK = Config.BASE_URL; // todo
    public static final String ENDPOINT_LOGIN_KAKAO = Config.BASE_URL; // todo
    private ApiEndpoint(){
        // 객체 금지
    }
}
