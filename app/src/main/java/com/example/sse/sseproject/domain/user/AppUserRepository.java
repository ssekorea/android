package com.example.sse.sseproject.domain.user;

import com.example.sse.sseproject.data.local.PreferencesHelper;

import javax.inject.Inject;

public class AppUserRepository implements UserRepository {
    private PreferencesHelper helper;
    private User currentUser;

    @Inject
    public AppUserRepository(PreferencesHelper helper){
        currentUser = new User();
        this.helper = helper;
    }

    @Override
    public User getUser() {
        return currentUser;
    }

    @Override
    public void setUser(User user) {
        currentUser = user;
    }
}
