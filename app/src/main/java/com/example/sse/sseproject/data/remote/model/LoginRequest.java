package com.example.sse.sseproject.data.remote.model;

public class LoginRequest {
    private LoginRequest(){
        // 객체 금지
    }

    public static class BasicLoginRequest{
        private String id;
        private String pw;

        public BasicLoginRequest(String id, String pw){
            this.id = id;
            this.pw = pw;
        }
    }

    public static class FacebookLoginRequest {

    }


    public static class KakaoLoginRequest {

    }
}
