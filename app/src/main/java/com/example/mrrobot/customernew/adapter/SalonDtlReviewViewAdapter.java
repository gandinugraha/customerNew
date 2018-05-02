package com.example.mrrobot.customernew.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bignerdranch.expandablerecyclerview.Adapter.ExpandableRecyclerAdapter;
import com.bignerdranch.expandablerecyclerview.Model.ParentObject;
import com.example.mrrobot.customernew.R;
import com.example.mrrobot.customernew.model.expandable.SalonReviewChild;
import com.example.mrrobot.customernew.model.expandable.SalonReviewParent;
import com.example.mrrobot.customernew.view_holder.SalonReviewChildViewHolder;
import com.example.mrrobot.customernew.view_holder.SalonReviewParentViewHolder;

import java.util.List;

/**
 * Created by Mr Robot on 12/18/2017.
 */

public class SalonDtlReviewViewAdapter extends ExpandableRecyclerAdapter<SalonReviewParentViewHolder, SalonReviewChildViewHolder> {

    private LayoutInflater layoutInflater;

    public SalonDtlReviewViewAdapter(Context context, List<ParentObject> parentItemList){
        super(context, parentItemList);
        this.layoutInflater = LayoutInflater.from(context);
    }


    @Override
    public SalonReviewParentViewHolder onCreateParentViewHolder(ViewGroup viewGroup) {
        View view = layoutInflater.inflate(R.layout.viewholder_review_parent, viewGroup, false);
        return new SalonReviewParentViewHolder(view);
    }

    @Override
    public SalonReviewChildViewHolder onCreateChildViewHolder(ViewGroup viewGroup) {
        View view = layoutInflater.inflate(R.layout.viewholder_review_child, viewGroup, false);
        return new SalonReviewChildViewHolder(view);
    }

    @Override
    public void onBindParentViewHolder(SalonReviewParentViewHolder salonReviewParentViewHolder, int i, Object o) {
        SalonReviewParent salonReviewParent =(SalonReviewParent) o;
        salonReviewParentViewHolder.setReviewerName(salonReviewParent.getCustomerName());
        salonReviewParentViewHolder.setReviewerDuration(salonReviewParent.getReviewDuration());
        salonReviewParentViewHolder.setReviewerTotalReview(salonReviewParent.getCustomerReviewTotal());

    }

    @Override
    public void onBindChildViewHolder(SalonReviewChildViewHolder salonReviewChildViewHolder, int i, Object o) {

        SalonReviewChild salonReviewChild = (SalonReviewChild) o;
        salonReviewChildViewHolder.setReviewerReview(salonReviewChild.getSalonReviewerReview());

    }
}
