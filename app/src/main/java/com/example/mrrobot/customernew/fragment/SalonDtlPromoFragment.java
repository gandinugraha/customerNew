package com.example.mrrobot.customernew.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.example.mrrobot.customernew.R;
import com.example.mrrobot.customernew.adapter.SalonDtlPromosPagerAdapter;
import com.google.android.gms.maps.MapView;



public class SalonDtlPromoFragment extends Fragment {

    private ViewPager viewPager;
    private Context context;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        ViewGroup viewGroup = (ViewGroup)inflater.inflate(R.layout.salon_dtl_promos_fragment,container, false);
        viewPager = (ViewPager) viewGroup.findViewById(R.id.view_pager);

        SalonDtlPromosPagerAdapter salonDtlPromosPagerAdapter = new SalonDtlPromosPagerAdapter(this.getContext());
        viewPager.setAdapter(salonDtlPromosPagerAdapter);

        return viewGroup;
    }

}
