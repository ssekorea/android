package com.ssekorea.sse.sseproject.domain.user;

import com.google.gson.annotations.SerializedName;

public class User {
    @SerializedName("userId")
    String id;
    @SerializedName("password")
    String pw;
    @SerializedName("jwt")
    String jwtToken;
    @SerializedName("access_token")
    String accessToken;
    @SerializedName("registerType")
    String joinType;
    @SerializedName("userType;")
    String userType;
    @SerializedName("name")
    String name;
    @SerializedName("birthDate")
    String birthday;
    @SerializedName("phoneNumber")
    String phoneNumber;
    @SerializedName("sex")
    String gender;

    @SerializedName("heartDisease")
    int heartDisease;
    @SerializedName("cancer")
    int cancer;
    @SerializedName("highBloodPressure")
    int highBloodPressure;
    @SerializedName("diabetes")
    int diabetes;
    @SerializedName("arthritis")
    int arthritis;
    @SerializedName("dementia")
    int dementia;
    @SerializedName("etc")
    String etc;

    public void setName(String name) {
        this.name = name;
    }

    public String getName(){
        return name;
    }
    public enum LoggedInMode {

        LOGGED_IN_MODE_LOGGED_OUT(0),
        LOGGED_IN_MODE_GOOGLE(1),
        LOGGED_IN_MODE_FB(2),
        LOGGED_IN_MODE_SERVER(3);

        private final int mType;

        LoggedInMode(int type) {
            mType = type;
        }

        public int getType() {
            return mType;
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public String getJwtToken() {
        return jwtToken;
    }

    public void setJwtToken(String jwtToken) {
        this.jwtToken = jwtToken;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getJoinType() {
        return joinType;
    }

    public void setJoinType(String joinType) {
        this.joinType = joinType;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getHeartDisease() {
        return heartDisease;
    }

    public void setHeartDisease(int heartDisease) {
        this.heartDisease = heartDisease;
    }

    public int getCancer() {
        return cancer;
    }

    public void setCancer(int cancer) {
        this.cancer = cancer;
    }

    public int getHighBloodPressure() {
        return highBloodPressure;
    }

    public void setHighBloodPressure(int highBloodPressure) {
        this.highBloodPressure = highBloodPressure;
    }

    public int getDiabetes() {
        return diabetes;
    }

    public void setDiabetes(int diabetes) {
        this.diabetes = diabetes;
    }

    public int getArthritis() {
        return arthritis;
    }

    public void setArthritis(int arthritis) {
        this.arthritis = arthritis;
    }

    public int getDementia() {
        return dementia;
    }

    public void setDementia(int dementia) {
        this.dementia = dementia;
    }

    public String getEtc() {
        return etc;
    }

    public void setEtc(String etc) {
        this.etc = etc;
    }
}
