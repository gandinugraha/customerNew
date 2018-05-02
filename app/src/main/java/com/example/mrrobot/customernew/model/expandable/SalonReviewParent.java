package com.example.mrrobot.customernew.model.expandable;

import com.bignerdranch.expandablerecyclerview.Model.ParentObject;
import com.example.mrrobot.customernew.model.SalonDtlReview;
import com.example.mrrobot.customernew.utility.SystemDateUtil;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by Mr Robot on 11/15/2017.
 */

public class SalonReviewParent implements ParentObject {

    private List<Object> mReviewList;
    private UUID id;

    private String customerName;
    private String customerImageUrl;
    private String customerReviewTotal;
    private String reviewRate;
    private String reviewDuration;

    public SalonReviewParent(SalonDtlReview salonDtlReview){
        id = UUID.randomUUID();
        customerName = salonDtlReview.getCustomerName();
        customerImageUrl = salonDtlReview.getCustomerImageUrl();
        customerReviewTotal = salonDtlReview.getCustomerReviewTotal();
        reviewRate = salonDtlReview.getReviewRate();

        Date reviewDate = salonDtlReview.getReviewDate();
        Date currentDate = new Date();

        try {
            long diffDays = SystemDateUtil.GET_DAY_BETWEEN(reviewDate, currentDate);
            long diffHours = SystemDateUtil.GET_HOUR_BETWEEN(reviewDate, currentDate)%24;
            long diffMinutes = SystemDateUtil.GET_MIN_BETWEEN(reviewDate, currentDate)%60;
            long diffSeconds = SystemDateUtil.GET_SEC_BETWEEN(reviewDate, currentDate)%60;

            if (diffDays > 0){
                reviewDuration =String.valueOf(diffDays) + (diffDays > 1 ?"days ago":"day ago");
            }else if (diffHours > 0){
                reviewDuration =String.valueOf(diffHours) + (diffHours > 1 ?"Hours ago":"hour ago");
            }else if (diffMinutes > 0){
                reviewDuration =String.valueOf(diffMinutes) + (diffMinutes > 1 ?"minutes ago":"minute ago");
            }else if (diffSeconds > 0){
                reviewDuration =String.valueOf(diffSeconds) + (diffSeconds > 1 ?"seconds ago":"second ago");
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        //set Childlist
        List<Object> childList = new ArrayList<>();
        childList.add(new SalonReviewChild(salonDtlReview.getReviewDesc()));
        setChildObjectList(childList);
    }

    public UUID get_id() {
        return id;
    }

    public void set_id(UUID _id) {
        this.id = _id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerImageUrl() {
        return customerImageUrl;
    }

    public String getCustomerReviewTotal() {
        return customerReviewTotal;
    }

    public String getReviewRate() {
        return reviewRate;
    }

    public String getReviewDuration() {
        return reviewDuration;
    }

    @Override
    public List<Object> getChildObjectList() {
        return mReviewList;
    }

    @Override
    public void setChildObjectList(List<Object> list) {
        mReviewList = list;
    }


}
