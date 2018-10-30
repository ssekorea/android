package com.ssekorea.sse.sseproject.main.lecture;

import android.arch.lifecycle.ViewModelProvider;
import android.support.v7.widget.LinearLayoutManager;

import com.ssekorea.sse.sseproject.ViewModelProviderFactory;
import com.ssekorea.sse.sseproject.data.remote.ApiHelper;
import com.ssekorea.sse.sseproject.util.rx.SchedulerProvider;

import java.util.ArrayList;

import dagger.Module;
import dagger.Provides;

@Module
public class LectureFragmentModule {
    @Provides
    LectureViewModel provideLectureViewModel(SchedulerProvider schedulerProvider, ApiHelper apiHelper){
        return new LectureViewModel(schedulerProvider,apiHelper);
    }

    @Provides
    ViewModelProvider.Factory provideLectureViewModelFactory(LectureViewModel lectureViewModel){
        return new ViewModelProviderFactory<>(lectureViewModel);
    }

    @Provides
    LectureAdapter provideLectureAdapter(){
        return new LectureAdapter(new ArrayList<>());
    }
    @Provides
    LinearLayoutManager provideLinearLayoutManager(LectureFragment fragment) {
        return new LinearLayoutManager(fragment.getActivity());
    }
}
