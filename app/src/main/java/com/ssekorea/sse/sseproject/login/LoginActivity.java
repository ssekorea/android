package com.ssekorea.sse.sseproject.login;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

import com.facebook.CallbackManager;
import com.ssekorea.sse.sseproject.BR;
import com.ssekorea.sse.sseproject.R;
import com.ssekorea.sse.sseproject.base.BaseActivity;
import com.ssekorea.sse.sseproject.databinding.ActivityLoginBinding;

import javax.inject.Inject;
import io.reactivex.disposables.Disposable;


public class LoginActivity extends BaseActivity<ActivityLoginBinding,LoginViewModel> implements LoginNavigator {

//    @Inject
//    LoginManager loginManager;
//
//    @Inject
//    CallbackManager fbCallbackManager;
////
//    @Inject
//    FacebookLoginCallback fbLoginCallback;

    @Inject
    ViewModelProvider.Factory viewModelFactory;
    private LoginViewModel loginViewModel;
    private Button btnFbLogin;
    private Disposable fbDisposable;
    @Override
    public LoginViewModel getViewModel() {
        loginViewModel = ViewModelProviders.of(this,viewModelFactory).get(LoginViewModel.class);
        return loginViewModel;
    }

    @Override
    public int getBindingVariable() {
        return BR.vm;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
//        loginViewModel.setIsLoading(false);
//        btnFbLogin = findViewById(R.id.login_btnFacebook);
//        btnFbLogin.setOnClickListener((v)->{
//            loginManager.logInWithReadPermissions(LoginActivity.this, Arrays.asList("public_profile","email"));
//            loginManager.registerCallback(fbCallbackManager,fbLoginCallback);
////            fbDisposable = fbLoginCallback.getObservable()
////                   // .doOnSubscribe(d-> loginViewModel.setIsLoading(true))
////                    .subscribe(data->{
////                        if (!data.getStatus().equals(Status.GET_TOKEN))loginViewModel.setIsLoading(false);
////                        if (data.getStatus().equals(Status.ON_ERROR)) {
////                            Toast.makeText(this, "Error in facebook login", Toast.LENGTH_SHORT).show();
////                        }
////                        if (data.getStatus().equals(Status.GET_USER)) {
////                            loginViewModel.LoginWithFacebook((JSONObject)(data.getResultData()));
////                        }
////                    },e->{
////                        loginViewModel.setIsLoading(false);
////                        Log.e("loginActivity","error while facebook Observable ");
////                    });
//        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        fbCallbackManager.onActivityResult(requestCode,resultCode,data);
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void makeTestToast(String str) {
        Toast.makeText(this, ""+str, Toast.LENGTH_SHORT).show();
    }
}
