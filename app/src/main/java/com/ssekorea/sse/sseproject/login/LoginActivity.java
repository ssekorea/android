package com.ssekorea.sse.sseproject.login;

import android.app.Activity;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.annotation.Nullable;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

import com.facebook.CallbackManager;
import com.facebook.GraphResponse;
import com.facebook.login.LoginManager;
import com.ssekorea.sse.sseproject.BR;
import com.ssekorea.sse.sseproject.R;
import com.ssekorea.sse.sseproject.base.BaseActivity;
import com.ssekorea.sse.sseproject.databinding.ActivityLoginBinding;

import org.json.JSONObject;

import java.util.Arrays;

import javax.inject.Inject;
import io.reactivex.disposables.Disposable;


public class LoginActivity extends BaseActivity<ActivityLoginBinding,LoginViewModel> implements LoginNavigator {

    @Inject
    LoginManager loginManager;

    @Inject
    CallbackManager fbCallbackManager;
//
    @Inject
    FacebookLoginCallback fbLoginCallback;

    @Inject
    ViewModelProvider.Factory mViewModelFactory;

    private ActivityLoginBinding mActivityLoginBinding;
    private LoginViewModel mLoginViewModel;
    private Button btnFbLogin;
    private Disposable fbDisposable;
    @Override
    public LoginViewModel getViewModel() {
        mLoginViewModel = ViewModelProviders.of(this, mViewModelFactory).get(LoginViewModel.class);
        return mLoginViewModel;
    }

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivityLoginBinding = getViewDataBinding();
        mLoginViewModel.setNavigator(this);
        btnFbLogin = findViewById(R.id.login_btnFacebook);
        btnFbLogin.setOnClickListener((v)->{
            loginManager.logInWithReadPermissions(LoginActivity.this, Arrays.asList("public_profile","email"));
            loginManager.registerCallback(fbCallbackManager,fbLoginCallback);
            fbDisposable = fbLoginCallback.getObservable()
                   // .doOnSubscribe(d-> loginViewModel.setIsLoading(true))
                    .subscribe(data->{
                        if (!data.getStatus().equals(FacebookLoginCallback.Status.GET_TOKEN))mLoginViewModel.setIsLoading(false);
                        if (data.getStatus().equals(FacebookLoginCallback.Status.ON_ERROR)) {
                            Toast.makeText(this, "Error in facebook login", Toast.LENGTH_SHORT).show();
                        }
                        if (data.getStatus().equals(FacebookLoginCallback.Status.GET_USER)) {
                            mLoginViewModel.LoginWithFacebook(((GraphResponse)(data.getResultData())).getJSONObject());
                        }
                    },e->{
                        mLoginViewModel.setIsLoading(false);
                        Log.e("loginActivity","error while facebook Observable "+e.getMessage());
                    });
        });

    }

    @Override
    public void makeTestToast(String str) {
        Toast.makeText(this, ""+str, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        fbCallbackManager.onActivityResult(requestCode,resultCode,data);
        super.onActivityResult(requestCode, resultCode, data);
    }
}
