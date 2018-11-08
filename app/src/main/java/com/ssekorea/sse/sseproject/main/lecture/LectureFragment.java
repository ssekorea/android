package com.ssekorea.sse.sseproject.main.lecture;


import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.ssekorea.sse.sseproject.R;
import com.ssekorea.sse.sseproject.BR;
import com.ssekorea.sse.sseproject.base.BaseFragment;
import com.ssekorea.sse.sseproject.databinding.FragmentLectureBinding;

import java.util.List;

import javax.inject.Inject;

/**
 * A simple {@link Fragment} subclass.
 */
public class LectureFragment extends BaseFragment<FragmentLectureBinding,LectureViewModel> implements LectureNavigator {
    @Inject
    LectureAdapter lectureAdapter;
    @Inject
    ViewModelProvider.Factory viewModelFactory;
    @Inject
    LinearLayoutManager mLayoutManager;
    private FragmentLectureBinding fragmentLectureBinding;
    private LectureViewModel lectureViewModel;


    public static LectureFragment newInstance(){
        Bundle args = new Bundle();
        LectureFragment fragment = new LectureFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_lecture;
    }

    @Override
    public LectureViewModel getViewModel() {
        lectureViewModel = ViewModelProviders.of(this,viewModelFactory).get(LectureViewModel.class);
        return lectureViewModel;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        lectureViewModel.setNavigator(this);
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        fragmentLectureBinding = getViewDataBinding();
        setUp();
        subscribeLiveData();
    }

    private void setUp(){
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        fragmentLectureBinding.lectureRecyclerview.setLayoutManager(mLayoutManager);
        fragmentLectureBinding.lectureRecyclerview.setItemAnimator(new DefaultItemAnimator());
        fragmentLectureBinding.lectureRecyclerview.setAdapter(lectureAdapter);
    }

    private void subscribeLiveData(){
        lectureViewModel.getLectureListLiveData().observe(this,lectureList -> {
            lectureAdapter.clearItems();
            lectureAdapter.addItems(lectureList);
        });
    }

}
