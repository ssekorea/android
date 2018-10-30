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
        private String token;
        private String id;

        public FacebookLoginRequest(String id, String token){
            this.id = id;
            this.token = token;
        }
    }


    public static class KakaoLoginRequest {
        private String token;
        private String id;

        public KakaoLoginRequest(String id, String token){
            this.id = id;
            this.token = token;
        }
    }
}
