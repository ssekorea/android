package com.ssekorea.sse.sseproject.data.remote.model;

public class LoginRequest {
    private LoginRequest(){
        // 객체 금지
    }

    public static class BasicLoginRequest{
        private String userId;
        private String password;

        public BasicLoginRequest(String id, String pw){
            this.userId = id;
            this.password = pw;
        }
    }

    public static class FacebookLoginRequest {
        private String accessToken;
        private String userId;

        public FacebookLoginRequest(String id, String token){
            this.userId = id;
            this.accessToken = token;
        }
    }


    public static class KakaoLoginRequest {
        private String accessToken;
        private String userId;

        public KakaoLoginRequest(String id, String token){
            this.userId = id;
            this.accessToken = token;
        }
    }
}
