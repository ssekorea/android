package com.ssekorea.sse.sseproject.data.remote;

import com.ssekorea.sse.sseproject.common.Config;

public class ApiEndpoint {
    public static final String ENDPOINT_REGISTER_BASIC = Config.BASE_URL +"/users"; 
    public static final String ENDPOINT_REGISTER_FACEBOOK = Config.BASE_URL+"/users"; 
    public static final String ENDPOINT_REGISTER_KAKAO = Config.BASE_URL+"/users"; 
    public static final String ENDPOINT_LOGIN_BASIC = Config.BASE_URL+"/oauth"; 
    public static final String ENDPOINT_LOGIN_FACEBOOK = Config.BASE_URL+"/oauth/third_party"; 
    public static final String ENDPOINT_LOGIN_KAKAO = Config.BASE_URL+"/oauth/third_party"; 
    public static final String ENDPOINT_LECTURE = Config.BASE_URL + "/lectures";
    public static final String ENDPOINT_SHOP = Config.BASE_URL + "/products";
    public static final String ENDPOINT_FEED = Config.BASE_URL + "/feeds";
    public static final String ENDPOINT_COURSE = Config.BASE_URL + "/courses";

    private ApiEndpoint(){
        // 객체 금지
    }
}
