package com.example.mrrobot.customernew.model.expandable;

/**
 * Created by Mr Robot on 11/15/2017.
 */

public class SalonReviewChild  {
    private String salonReviewerReview;

    public SalonReviewChild(String salonReviewerReview){
        this.salonReviewerReview = salonReviewerReview;
    }

    public String getSalonReviewerReview(){
        return salonReviewerReview;
    }

    public void setSalonReviewerReview(String salonReviewerReview) {
        this.salonReviewerReview = salonReviewerReview;
    }
}
