package com.ssekorea.sse.sseproject.main.lecture;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import com.ssekorea.sse.sseproject.base.BaseViewModel;
import com.ssekorea.sse.sseproject.data.remote.ApiHelper;
import com.ssekorea.sse.sseproject.domain.lecture.Lecture;
import com.ssekorea.sse.sseproject.util.rx.SchedulerProvider;

import java.util.List;

public class LectureViewModel extends BaseViewModel<LectureNavigator> {
    private final ApiHelper apiHelper;
    private final MutableLiveData<List<Lecture>> lectureListLiveData;

    public LectureViewModel(SchedulerProvider mSchedulerProvider, ApiHelper apiHelper) {
        super(mSchedulerProvider);
        this.apiHelper = apiHelper;
        this.lectureListLiveData = new MutableLiveData<>();
        fetchLectures();
    }

    public void fetchLectures() {
        setIsLoading(true);
        getCompositeDisposable().add(apiHelper.getLectures()
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(response->{
                    setIsLoading(false);
                    if (response.lectures != null)
                        getLectureListLiveData().setValue(response.lectures);
                },throwable ->{
                    setIsLoading(false);
                    getUiHandleError().setValue(throwable);
                }));

    }

    public MutableLiveData<List<Lecture>> getLectureListLiveData() {
        return lectureListLiveData;
    }
}
