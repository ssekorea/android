package com.ssekorea.sse.sseproject.login;

import android.os.Bundle;
import android.util.Log;

import com.facebook.AccessToken;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.login.LoginResult;

import org.json.JSONObject;

import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.Subject;


public class FacebookLoginCallback implements FacebookCallback<LoginResult> {
    private PublishSubject<Response> status;
    public FacebookLoginCallback(){
        status = PublishSubject.create();
    }
    @Override
    public void onSuccess(LoginResult loginResult) {
        status.onNext(new Response(Status.GET_TOKEN,loginResult));
        requestMe(loginResult.getAccessToken());
    }

    @Override
    public void onCancel() {
        status.onNext(new Response(Status.ON_CANCEL,null));
    }

    @Override
    public void onError(FacebookException error) {
        status.onNext(new Response(Status.ON_ERROR,error));
    }

    public Observable<Response> getObservable(){
        return status;
    }

    public void requestMe(AccessToken token) {
        GraphRequest graphRequest = GraphRequest.newMeRequest(token,
                (object, response) -> status.onNext(new Response(Status.GET_USER,response)));
        Bundle parameters = new Bundle();
        parameters.putString("fields", "id,name,email,gender,birthday");
        graphRequest.setParameters(parameters);
        graphRequest.executeAsync();
    }
    public class Response{
        private Status status;
        private Object resultData;
        Response(Status status, Object data){
            this.status = status;
            this.resultData = data;
        }

        public Status getStatus() {
            return status;
        }

        public Object getResultData(){
            return resultData;
        }
    }
    public enum Status{
        GET_TOKEN,
        ON_CANCEL,
        ON_ERROR,
        GET_USER
    }
}
