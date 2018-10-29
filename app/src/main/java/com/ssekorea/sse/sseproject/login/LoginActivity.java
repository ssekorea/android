package com.ssekorea.sse.sseproject.login;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;
import com.facebook.CallbackManager;
import com.facebook.GraphResponse;
import com.facebook.login.LoginManager;
import com.kakao.auth.AuthType;
import com.kakao.auth.ISessionCallback;
import com.kakao.auth.Session;
import com.kakao.network.ErrorResult;
import com.kakao.usermgmt.UserManagement;
import com.kakao.usermgmt.callback.MeResponseCallback;
import com.kakao.usermgmt.response.model.UserProfile;
import com.kakao.util.exception.KakaoException;
import com.ssekorea.sse.sseproject.BR;
import com.ssekorea.sse.sseproject.R;
import com.ssekorea.sse.sseproject.base.BaseActivity;
import com.ssekorea.sse.sseproject.databinding.ActivityLoginBinding;
import com.ssekorea.sse.sseproject.register.BasicRegisterActivity;
import com.ssekorea.sse.sseproject.util.UIUtil;

import java.util.Arrays;

import javax.inject.Inject;

import io.reactivex.disposables.Disposable;


public class LoginActivity extends BaseActivity<ActivityLoginBinding, LoginViewModel> implements LoginNavigator {

    @Inject
    LoginManager loginManager;
    @Inject
    CallbackManager fbCallbackManager;
    @Inject
    FacebookLoginCallback fbLoginCallback;
    @Inject
    ViewModelProvider.Factory mViewModelFactory;

    //todo LoginActivity 는 써드파티때문에 지저분함. 리펙토링 필요.
    private ActivityLoginBinding mActivityLoginBinding;
    private LoginViewModel mLoginViewModel;
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
        mLoginViewModel.getUiHandleError().observe(this,throwable -> UIUtil.showToast(throwable != null ? throwable.getMessage() : "null message"));
        mActivityLoginBinding.loginBtnFacebook.setOnClickListener((v) -> {
            loginManager.logInWithReadPermissions(LoginActivity.this, Arrays.asList("public_profile", "email"));
            loginManager.registerCallback(fbCallbackManager, fbLoginCallback);
            fbDisposable = fbLoginCallback.getObservable()
                    // .doOnSubscribe(d-> loginViewModel.setIsLoading(true))
                    .subscribe(data -> {
                        if (!data.getStatus().equals(FacebookLoginCallback.Status.GET_TOKEN))
                            mLoginViewModel.setIsLoading(false);
                        if (data.getStatus().equals(FacebookLoginCallback.Status.ON_ERROR)) {
                            Toast.makeText(this, "Error in facebook login", Toast.LENGTH_SHORT).show();
                        }
                        if (data.getStatus().equals(FacebookLoginCallback.Status.GET_USER)) {
                            mLoginViewModel.tryLoginWithFacebook(((GraphResponse) (data.getResultData())).getJSONObject());
                        }
                    }, e -> {
                        mLoginViewModel.setIsLoading(false);
                        Log.e("loginActivity", "error while facebook Observable " + e.getMessage());
                    });
        });
        mActivityLoginBinding.loginBtnKakao.setOnClickListener((v)->{
            Session session = Session.getCurrentSession();
            session.addCallback(new ISessionCallback() {
                @Override
                public void onSessionOpened() {
                    UserManagement.requestMe(new MeResponseCallback() {
                        @Override
                        public void onSessionClosed(ErrorResult errorResult) {
                            Toast.makeText(LoginActivity.this, "Error : Session Closed", Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void onNotSignedUp() {
                            Toast.makeText(LoginActivity.this, "카카오톡 계정이 없습니다.", Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void onSuccess(UserProfile result) {

                            mLoginViewModel.tryLoginWithKakao(result,session.getTokenInfo().getAccessToken());
                        }
                    });
                }

                @Override
                public void onSessionOpenFailed(KakaoException exception) {
                    Log.e("LoginActivity",exception.getMessage());
                }
            });
            session.open(AuthType.KAKAO_TALK,LoginActivity.this);
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        fbCallbackManager.onActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    protected void onDestroy() {
        if (fbDisposable != null)
            fbDisposable.dispose();
        super.onDestroy();
    }

    @Override
    public void navigateToBasicRegister() {
        startActivity(new Intent(LoginActivity.this,BasicRegisterActivity.class));
        finish();
    }
}
