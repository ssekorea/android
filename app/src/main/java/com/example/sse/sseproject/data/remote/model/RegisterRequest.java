package com.example.sse.sseproject.data.remote.model;

import com.example.sse.sseproject.domain.user.User;

public class RegisterRequest {
    private RegisterRequest(){
        // 객체 금지
    }

    public static class BasicRegisterRequest{
        private User user;

        public BasicRegisterRequest(User user){
            this.user = user;
        }
    }

    public static class FacebookRegisterRequest {

    }
}
