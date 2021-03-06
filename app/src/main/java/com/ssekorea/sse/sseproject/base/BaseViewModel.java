package com.ssekorea.sse.sseproject.base;


import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.databinding.ObservableBoolean;

import com.ssekorea.sse.sseproject.util.rx.SchedulerProvider;

import java.lang.ref.WeakReference;

import io.reactivex.disposables.CompositeDisposable;

public abstract class BaseViewModel<N> extends ViewModel {

    private final SchedulerProvider mSchedulerProvider;

    private final ObservableBoolean mIsLoading=new ObservableBoolean(false);

    private CompositeDisposable mCompositeDisposable;

    private WeakReference<N> mNavigator;
    private MutableLiveData<Throwable> uiHandleError;

    public BaseViewModel(SchedulerProvider mSchedulerProvider) {
        this.mSchedulerProvider = mSchedulerProvider;
        this.mCompositeDisposable = new CompositeDisposable();
        this.uiHandleError = new MutableLiveData<>();
    }

    @Override
    protected void onCleared() {
        mCompositeDisposable.dispose();
        super.onCleared();
    }

    public CompositeDisposable getCompositeDisposable() {
        return mCompositeDisposable;
    }

    public SchedulerProvider getSchedulerProvider() {
        return mSchedulerProvider;
    }

    public ObservableBoolean getIsLoading() {
        return mIsLoading;
    }

    public void setIsLoading(boolean isLoading) {
        mIsLoading.set(isLoading);
    }

    public N getNavigator() {
        return mNavigator.get();
    }

    public MutableLiveData<Throwable> getUiHandleError(){
        return uiHandleError;
    }
    public void setNavigator(N navigator) {
        this.mNavigator = new WeakReference<>(navigator);
    }
}
