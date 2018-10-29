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
    @SerializedName("join_type")
    String joinType;
    @SerializedName("user_type")
    String userType;
    @SerializedName("name")
    String name;
    @SerializedName("birthDate")
    String birthday;
    @SerializedName("phoneNumber")
    String phoneNumber;
    @SerializedName("sex")
    String gender;

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
}
