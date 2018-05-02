package com.example.mrrobot.customernew.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.example.mrrobot.customernew.R;
import com.example.mrrobot.customernew.activity.LocationActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class MasterpiecesFragment extends Fragment {


    public MasterpiecesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_masterpieces, container, false);

    }

}
