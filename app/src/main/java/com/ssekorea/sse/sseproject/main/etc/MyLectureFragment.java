package com.ssekorea.sse.sseproject.main.etc;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ssekorea.sse.sseproject.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MyLectureFragment extends Fragment {


    public MyLectureFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_my_lecture, container, false);
    }

}
