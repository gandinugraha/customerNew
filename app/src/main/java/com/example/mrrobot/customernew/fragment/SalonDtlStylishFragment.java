package com.example.mrrobot.customernew.fragment;


import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.example.mrrobot.customernew.R;
import com.example.mrrobot.customernew.adapter.SalonDtlStylishViewAdapter;
import com.example.mrrobot.customernew.listener.OnLoadSalonStylishListener;
import com.example.mrrobot.customernew.model.SalonDtlReview;
import com.example.mrrobot.customernew.model.SalonDtlStylish;
import com.example.mrrobot.customernew.model.expandable.SalonReviewParent;
import com.example.mrrobot.customernew.utility.SystemDateUtil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.util.UUID;

/**
 * Created by Mr Robot on 11/15/2017.
 */

public class SalonDtlStylishFragment extends Fragment {
    private List<SalonDtlStylish> salonDtlStylishes = new ArrayList<>();

    private RecyclerView salonStylishListView;
    private SalonDtlStylishViewAdapter salonDtlStylishViewAdapter;
    private Context context;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        ViewGroup viewGroup = (ViewGroup)inflater.inflate(R.layout.salon_dtl_stylish_fragment,container, false);

        //Create Dummy Data for list item ==========================================================
        for (int i = 0; i < 10; i++) {
            SalonDtlStylish salonDtlStylish = new SalonDtlStylish.Builder()
                    .stylishId(UUID.randomUUID().toString())
                    .salonId(UUID.randomUUID().toString())
                    .stylishName("Stylish Name" + " " + i)
                    .stylishAvailablity(true)
                    .stylishMondayHours("10.00 to 21.00")
                    .stylishTuesdayHours("10.00 to 21.00")
                    .stylishWednesdayHours("10.00 to 21.00")
                    .stylishThursdayHours("10.00 to 21.00")
                    .stylishFridayHours("10.00 to 21.00")
                    .stylishSaturdayHours("10.00 to 21.00")
                    .stylishSundayHours("10.00 to 21.00")
                    .build();
            salonDtlStylishes.add(salonDtlStylish);
        }
        //==========================================================================================

        salonStylishListView = (RecyclerView) viewGroup.findViewById(R.id.salon_stylish_container);
        salonStylishListView.setLayoutManager(new LinearLayoutManager(getActivity()));
        salonDtlStylishViewAdapter = new SalonDtlStylishViewAdapter(salonStylishListView, salonDtlStylishes, getActivity(), getActivity());

        salonDtlStylishViewAdapter.setOnLoadMoreListener(new OnLoadSalonStylishListener(){
            @Override
            public void onLoadMore() {
                salonStylishListView.post(new Runnable() {
                    @Override
                    public void run() {
                        salonDtlStylishes.add(null);
                        salonDtlStylishViewAdapter.notifyItemInserted(salonDtlStylishes.size() - 1);

                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                Log.e("haint", "Load More 2");

                                //Remove loading item
                                salonDtlStylishes.remove(salonDtlStylishes.size() - 1);
                                salonDtlStylishViewAdapter.notifyItemRemoved(salonDtlStylishes.size());

                                //Load data =================================================================================
                                int index = salonDtlStylishes.size();
                                int end = index + 10;
                                for (int i = index; i < end; i++) {
                                    SalonDtlStylish salonDtlStylish = new SalonDtlStylish.Builder()
                                            .stylishId(UUID.randomUUID().toString())
                                            .salonId(UUID.randomUUID().toString())
                                            .stylishName("Stylish Name" + " " + i)
                                            .stylishAvailablity(true)
                                            .stylishMondayHours("10.00 to 21.00")
                                            .stylishTuesdayHours("10.00 to 21.00")
                                            .stylishWednesdayHours("10.00 to 21.00")
                                            .stylishThursdayHours("10.00 to 21.00")
                                            .stylishFridayHours("10.00 to 21.00")
                                            .stylishSaturdayHours("10.00 to 21.00")
                                            .stylishSundayHours("10.00 to 21.00")
                                            .build();
                                    salonDtlStylishes.add(salonDtlStylish);
                                }
                                // ==========================================================================================

                                salonDtlStylishViewAdapter.notifyDataSetChanged();
                                salonDtlStylishViewAdapter.setLoaded();
                            }
                        }, 3000);
                    }
                });
            }
        });

        salonStylishListView.setAdapter(salonDtlStylishViewAdapter);

        return viewGroup;
    }

}
