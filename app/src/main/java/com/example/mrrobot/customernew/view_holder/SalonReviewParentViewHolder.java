package com.example.mrrobot.customernew.view_holder;


import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bignerdranch.expandablerecyclerview.ViewHolder.ParentViewHolder;
import com.example.mrrobot.customernew.R;

/**
 * Created by Mr Robot on 11/15/2017.
 */

public class SalonReviewParentViewHolder extends ParentViewHolder {

    private ImageView reviewerImg;

    private TextView reviewerName;
    private TextView reviewerDuration;
    private TextView reviewerTotalReview;
    private TextView reviewerRating;

    public SalonReviewParentViewHolder (View itemView){
        super(itemView);

        reviewerImg = (ImageView) itemView.findViewById(R.id.reviewer_img);

        reviewerName = (TextView) itemView.findViewById(R.id.reviewer_name);
        reviewerDuration = (TextView) itemView.findViewById(R.id.reviewer_duration);
        reviewerTotalReview = (TextView) itemView.findViewById(R.id.reviewer_total_review);
//        reviewerRating = (TextView) itemView.findViewById(R.id.reviewer_rating);
    }

    public void setReviewerImg(){
        reviewerImg.setImageResource(0);
    }

    public void setReviewerName(String strReviewerName){
        reviewerName.setText(strReviewerName);
    }

    public void setReviewerDuration (String strReviewerDuration){
        reviewerDuration.setText(strReviewerDuration);
    }

    public void setReviewerTotalReview (String strReviewerTotalReview){
        reviewerTotalReview.setText(strReviewerTotalReview);
    }

    public void setReviewerRating (String strReviewerRating){
//        reviewerRating.setText(strReviewerRating);
    }
}
