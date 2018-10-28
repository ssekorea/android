package com.ssekorea.sse.sseproject.login;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.facebook.login.LoginManager;
import com.ssekorea.sse.sseproject.R;

import javax.inject.Inject;

public class LoginActivity extends AppCompatActivity {

    @Inject
    LoginManager facebookLoginManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }
}
