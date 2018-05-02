package com.example.mrrobot.customernew.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bignerdranch.expandablerecyclerview.Model.ParentObject;
import com.example.mrrobot.customernew.R;
import com.example.mrrobot.customernew.adapter.SalonDtlReviewViewAdapter;
import com.example.mrrobot.customernew.model.SalonDtlReview;
import com.example.mrrobot.customernew.model.expandable.SalonReviewParent;
import com.example.mrrobot.customernew.utility.SystemDateUtil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;


public class ReviewProfilFragment extends Fragment {
    private List<SalonDtlReview> salonDtlReviews = new ArrayList<>();
    private List<ParentObject> parentObject = new ArrayList<>();

    private RecyclerView salonReviewListView;
    private SalonDtlReviewViewAdapter salonDtlReviewViewAdapter;
    private Context context;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        ViewGroup viewGroup = (ViewGroup)inflater.inflate(R.layout.salon_dtl_review_fragment,container, false);


        for (int i = 0; i < 10; i++){
            SalonDtlReview salonDtlReview = new SalonDtlReview.Builder()
                    .salonId(UUID.randomUUID().toString())
                    .reviewId(UUID.randomUUID().toString())
                    .customerName("Mr Kobochan" + " " + i)
                    .customerImageUrl("http://") //TODO
                    .customerReviewTotal("40 Reviews")
                    .reviewRate("Rated 4.5/5")
                    .reviewDesc("Awesome place for my hair style\n" +
                            "\n" +
                            "# cappuccino\n")
                    .build();

            SalonReviewParent salonReviewParent = new SalonReviewParent(salonDtlReview);
            parentObject.add(salonReviewParent);
        }

        salonReviewListView = (RecyclerView) viewGroup.findViewById(R.id.salon_review_container);
        salonReviewListView.setLayoutManager(new LinearLayoutManager(getActivity()));
        salonDtlReviewViewAdapter = new SalonDtlReviewViewAdapter(this.getContext(), parentObject);


        salonReviewListView.setAdapter(salonDtlReviewViewAdapter);
        return viewGroup;
    }
}
