package com.ssekorea.sse.sseproject.domain.user;

import com.google.gson.annotations.SerializedName;

public class User {
    @SerializedName("id")
    String id;
    @SerializedName("pw")
    String pw;
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
}