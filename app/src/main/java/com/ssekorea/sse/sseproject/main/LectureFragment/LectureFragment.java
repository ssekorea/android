package com.ssekorea.sse.sseproject.main.LectureFragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ssekorea.sse.sseproject.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class LectureFragment extends Fragment {


    public LectureFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_lecture, container, false);
    }

}
