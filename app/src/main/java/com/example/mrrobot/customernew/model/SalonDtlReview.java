package com.example.mrrobot.customernew.model;

import java.util.Date;

/**
 * Created by Mr Robot on 12/19/2017.
 */

public class SalonDtlReview {

    private String salonId;
    private String reviewId;
    private String customerName;
    private String customerImageUrl;
    private String customerReviewTotal;
    private String reviewRate;
    private Date reviewDate;
    private String reviewDesc;

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    private String month;

    public SalonDtlReview() {
    }


    public SalonDtlReview(String salonId, String reviewId, String customerName, String customerImageUrl, String customerReviewTotal, String reviewRate, Date reviewDate, String reviewDesc, String month) {
        this.salonId = salonId;
        this.reviewId = reviewId;
        this.customerName = customerName;
        this.customerImageUrl = customerImageUrl;
        this.customerReviewTotal = customerReviewTotal;
        this.reviewRate = reviewRate;
        this.reviewDate = reviewDate;
        this.reviewDesc = reviewDesc;
        this.month = month;
    }

    private SalonDtlReview(Builder builder) {
        setSalonId(builder.salonId);
        setReviewId(builder.reviewId);
        setCustomerName(builder.customerName);
        setCustomerImageUrl(builder.customerImageUrl);
        setCustomerReviewTotal(builder.customerReviewTotal);
        setReviewRate(builder.reviewRate);
        setReviewDate(builder.reviewDate);
        setReviewDesc(builder.reviewDesc);
    }




    public String getSalonId() {
        return salonId;
    }

    public void setSalonId(String salonId) {
        this.salonId = salonId;
    }

    public String getReviewId() {
        return reviewId;
    }

    public void setReviewId(String reviewId) {
        this.reviewId = reviewId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerImageUrl() {
        return customerImageUrl;
    }

    public void setCustomerImageUrl(String customerImageUrl) {
        this.customerImageUrl = customerImageUrl;
    }

    public String getCustomerReviewTotal() {
        return customerReviewTotal;
    }

    public void setCustomerReviewTotal(String customerReviewTotal) {
        this.customerReviewTotal = customerReviewTotal;
    }

    public String getReviewRate() {
        return reviewRate;
    }

    public void setReviewRate(String reviewRate) {
        this.reviewRate = reviewRate;
    }

    public Date getReviewDate() {
        return reviewDate;
    }

    public void setReviewDate(Date reviewDate) {
        this.reviewDate = reviewDate;
    }

    public String getReviewDesc() {
        return reviewDesc;
    }

    public void setReviewDesc(String reviewDesc) {
        this.reviewDesc = reviewDesc;
    }

    public static final class Builder {
        private String salonId;
        private String reviewId;
        private String customerName;
        private String customerImageUrl;
        private String customerReviewTotal;
        private String reviewRate;
        private Date reviewDate;
        private String reviewDesc;

        public Builder() {
        }

        public Builder salonId(String val) {
            salonId = val;
            return this;
        }

        public Builder reviewId(String val) {
            reviewId = val;
            return this;
        }

        public Builder customerName(String val) {
            customerName = val;
            return this;
        }

        public Builder customerImageUrl(String val) {
            customerImageUrl = val;
            return this;
        }

        public Builder customerReviewTotal(String val) {
            customerReviewTotal = val;
            return this;
        }

        public Builder reviewRate(String val) {
            reviewRate = val;
            return this;
        }

        public Builder reviewDate(Date val) {
            reviewDate = val;
            return this;
        }

        public Builder reviewDesc(String val) {
            reviewDesc = val;
            return this;
        }

        public SalonDtlReview build() {
            return new SalonDtlReview(this);
        }
    }
}
