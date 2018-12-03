package com.ssekorea.sse.sseproject.data.remote.model;

import com.ssekorea.sse.sseproject.domain.user.User;

public class RegisterRequest {
    private RegisterRequest() {
        // 객체 금지
    }

    public static class BasicRegisterRequest {


        public int arthritis;
        public String birthDate;
        public int cancer;
        public int dementia;
        public int diabetes;
        public int heartDisease;
        public int highBloodPressure;
        public String name;
        public String password;
        public String phoneNumber;
        public String registerType;
        public String sex;
        public String userId;
        public String userType;

        public BasicRegisterRequest(User user) {
            arthritis = user.getArthritis();
            birthDate = user.getBirthday();
            cancer = user.getCancer();
            dementia = user.getDementia();
            diabetes = user.getDiabetes();
            heartDisease = user.getHeartDisease();
            highBloodPressure = user.getHighBloodPressure();
            name = user.getName();
            password = user.getPw();
            phoneNumber = user.getPhoneNumber();
            registerType = user.getJoinType();
            sex = user.getGender();
            userId = user.getId();
            userType = user.getUserType();
        }

    }

    public static class FacebookRegisterRequest {
        public FacebookRegisterRequest(User user) {
            arthritis = user.getArthritis();
            birthDate = user.getBirthday();
            cancer = user.getCancer();
            dementia = user.getDementia();
            diabetes = user.getDiabetes();
            heartDisease = user.getHeartDisease();
            highBloodPressure = user.getHighBloodPressure();
            name = user.getName();
            password = user.getPw();
            phoneNumber = user.getPhoneNumber();
            registerType = user.getJoinType();
            sex = user.getGender();
            userId = user.getId();
            userType = user.getUserType();
        }
        public int arthritis;
        public String birthDate;
        public int cancer;
        public int dementia;
        public int diabetes;
        public int heartDisease;
        public int highBloodPressure;
        public String name;
        public String password;
        public String phoneNumber;
        public String registerType;
        public String sex;
        public String userId;
        public String userType;
    }

    public static class KakaokRegisterRequest {
        public KakaokRegisterRequest(User user) {
            arthritis = user.getArthritis();
            birthDate = user.getBirthday();
            cancer = user.getCancer();
            dementia = user.getDementia();
            diabetes = user.getDiabetes();
            heartDisease = user.getHeartDisease();
            highBloodPressure = user.getHighBloodPressure();
            name = user.getName();
            password = user.getPw();
            phoneNumber = user.getPhoneNumber();
            registerType = user.getJoinType();
            sex = user.getGender();
            userId = user.getId();
            userType = user.getUserType();
        }
        public int arthritis;
        public String birthDate;
        public int cancer;
        public int dementia;
        public int diabetes;
        public int heartDisease;
        public int highBloodPressure;
        public String name;
        public String password;
        public String phoneNumber;
        public String registerType;
        public String sex;
        public String userId;
        public String userType;
    }
}
