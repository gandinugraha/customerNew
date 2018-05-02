package com.example.mrrobot.customernew.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mrrobot.customernew.R;
import com.example.mrrobot.customernew.adapter.PhotoDtlPagerAdapter;



/**
 * Created by Mr Robot on 2/8/2018.
 */

public class PhotoDtlFragment extends android.support.v4.app.Fragment {
    private ViewPager viewPager;
    private Context context;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        ViewGroup viewGroup = (ViewGroup)inflater.inflate(R.layout.business_dtl_services_fragment,container, false);
        viewPager = (ViewPager) viewGroup.findViewById(R.id.view_pager);

        PhotoDtlPagerAdapter viewPagerAdapter = new PhotoDtlPagerAdapter(this.getContext());
        viewPager.setAdapter(viewPagerAdapter);
        return viewGroup;

    }


}
