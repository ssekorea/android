package com.ssekorea.sse.sseproject.data.remote.model;

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
