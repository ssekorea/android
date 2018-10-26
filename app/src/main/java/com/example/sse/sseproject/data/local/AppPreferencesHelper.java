package com.example.sse.sseproject.data.local;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.Nullable;

import com.example.sse.sseproject.di.PreferenceInfo;
import com.example.sse.sseproject.domain.user.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.inject.Inject;

public class AppPreferencesHelper implements PreferencesHelper {

    private static final String PREF_KEY_ACCESS_TOKEN = "PREF_KEY_ACCESS_TOKEN";

    private static final String PREF_KEY_CURRENT_USER = "PREF_KEY_CURRENT_USER";

    private static final String PREF_KEY_USER_LOGGED_IN_MODE = "PREF_KEY_USER_LOGGED_IN_MODE";

    private final SharedPreferences mPrefs;

    @Inject
    public AppPreferencesHelper(Context context, @PreferenceInfo String prefFileName) {
        mPrefs = context.getSharedPreferences(prefFileName, Context.MODE_PRIVATE);
    }
    @Override
    @Nullable
    public String getAccessToken() {
        return mPrefs.getString(PREF_KEY_ACCESS_TOKEN,null);
    }

    @Override
    public void setAccessToken(String accessToken) {
        mPrefs.edit().putString(PREF_KEY_ACCESS_TOKEN,accessToken).apply();
    }

    @Override
    public int getCurrentUserLoggedInMode() {
        return mPrefs.getInt(PREF_KEY_USER_LOGGED_IN_MODE,
                User.LoggedInMode.LOGGED_IN_MODE_LOGGED_OUT.getType());
    }

    @Override
    public void setCurrentUserLoggedInMode(User.LoggedInMode mode) {
        mPrefs.edit().putInt(PREF_KEY_USER_LOGGED_IN_MODE, mode.getType()).apply();
    }

    @Override
    @Nullable
    public User getCurrentUser() {
        Gson gson = new GsonBuilder().create();
        String jsonUser = mPrefs.getString(PREF_KEY_CURRENT_USER,null);
        if (jsonUser == null)
            return null;
        return gson.fromJson(jsonUser,User.class);
    }

    @Override
    public void setCurrentUser(User user) {
        Gson gson = new GsonBuilder().create();
        mPrefs.edit().putString(PREF_KEY_CURRENT_USER,gson.toJson(user)).apply();
    }
}
