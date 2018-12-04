package com.ssekorea.sse.sseproject.main.myinfo;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ssekorea.sse.sseproject.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MyInfoFragment extends Fragment {


    public MyInfoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_my_info, container, false);
        CardView cardCard = v.findViewById(R.id.card_card);
        CardView buyCard = v.findViewById(R.id.card_buy);
        cardCard.setOnClickListener((ve)->{
            buyCard.setVisibility(View.VISIBLE);
        });
        return v;
    }

}
