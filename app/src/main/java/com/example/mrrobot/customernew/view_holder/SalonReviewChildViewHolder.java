package com.example.mrrobot.customernew.view_holder;

import android.view.View;
import android.widget.TextView;

import com.bignerdranch.expandablerecyclerview.ViewHolder.ChildViewHolder;
import com.example.mrrobot.customernew.R;

/**
 * Created by Mr Robot on 11/15/2017.
 */

public class SalonReviewChildViewHolder extends ChildViewHolder {
    private TextView reviewerReview;

    public SalonReviewChildViewHolder(View itemView) {
        super(itemView);
        this.reviewerReview = (TextView) itemView.findViewById(R.id.reviewer_review);
    }

    public void setReviewerReview (String review){
        reviewerReview.setText(review);
    }



}
