package com.example.mrrobot.customernew.model;

import java.util.Date;

/**
 * Created by C-US on 11/25/2017.
 */

public class Salon {
    private String salonId;
    private String salonName;
    private String salonAddress;
    private String salonManagerName;
    private String salonManagerUser;
    private String salonRating;
    private String salonTotalReview;
    private String salonTotalStylish;
    private boolean salonSubscriptionStatus;
    private String salonImageUrl;

    private String createdBy;
    private String updatedBy;
    private Date createdDate;
    private Date updatedDate;

    public Salon() {
    }

    public Salon(String salonId, String salonName, String salonAddress, String salonManagerName, String salonManagerUser, String salonRating, String salonTotalReview, String salonTotalStylish, boolean salonSubscriptionStatus, String salonImageUrl, String createdBy, String updatedBy, Date createdDate, Date updatedDate) {
        this.salonId = salonId;
        this.salonName = salonName;
        this.salonAddress = salonAddress;
        this.salonManagerName = salonManagerName;
        this.salonManagerUser = salonManagerUser;
        this.salonRating = salonRating;
        this.salonTotalReview = salonTotalReview;
        this.salonTotalStylish = salonTotalStylish;
        this.salonSubscriptionStatus = salonSubscriptionStatus;
        this.salonImageUrl = salonImageUrl;
        this.createdBy = createdBy;
        this.updatedBy = updatedBy;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
    }

    private Salon(Builder builder) {
        setSalonId(builder.salonId);
        setSalonName(builder.salonName);
        setSalonAddress(builder.salonAddress);
        setSalonManagerName(builder.salonManagerName);
        setSalonManagerUser(builder.salonManagerUser);
        setSalonRating(builder.salonRating);
        setSalonTotalReview(builder.salonTotalReview);
        setSalonTotalStylish(builder.salonTotalStylish);
        setSalonSubscriptionStatus(builder.salonSubscriptionStatus);
        setSalonImageUrl(builder.salonImageUrl);
        setCreatedBy(builder.createdBy);
        setUpdatedBy(builder.updatedBy);
        setCreatedDate(builder.createdDate);
        setUpdatedDate(builder.updatedDate);
    }

    public String getSalonId() {
        return salonId;
    }

    public void setSalonId(String salonId) {
        this.salonId = salonId;
    }

    public String getSalonName() {
        return salonName;
    }

    public void setSalonName(String salonName) {
        this.salonName = salonName;
    }

    public String getSalonAddress() {
        return salonAddress;
    }

    public void setSalonAddress(String salonAddress) {
        this.salonAddress = salonAddress;
    }

    public String getSalonManagerName() {
        return salonManagerName;
    }

    public void setSalonManagerName(String salonManagerName) {
        this.salonManagerName = salonManagerName;
    }

    public String getSalonManagerUser() {
        return salonManagerUser;
    }

    public void setSalonManagerUser(String salonManagerUser) {
        this.salonManagerUser = salonManagerUser;
    }

    public String getSalonRating() {
        return salonRating;
    }

    public void setSalonRating(String salonRating) {
        this.salonRating = salonRating;
    }

    public String getSalonTotalReview() {
        return salonTotalReview;
    }

    public void setSalonTotalReview(String salonTotalReview) {
        this.salonTotalReview = salonTotalReview;
    }

    public String getSalonTotalStylish() {
        return salonTotalStylish;
    }

    public void setSalonTotalStylish(String salonTotalStylish) {
        this.salonTotalStylish = salonTotalStylish;
    }

    public boolean isSalonSubscriptionStatus() {
        return salonSubscriptionStatus;
    }

    public void setSalonSubscriptionStatus(boolean salonSubscriptionStatus) {
        this.salonSubscriptionStatus = salonSubscriptionStatus;
    }

    public String getSalonImageUrl() {
        return salonImageUrl;
    }

    public void setSalonImageUrl(String salonImageUrl) {
        this.salonImageUrl = salonImageUrl;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }


    public static final class Builder {
        private String salonId;
        private String salonName;
        private String salonAddress;
        private String salonManagerName;
        private String salonManagerUser;
        private String salonRating;
        private String salonTotalReview;
        private String salonTotalStylish;
        private boolean salonSubscriptionStatus;
        private String salonImageUrl;
        private String createdBy;
        private String updatedBy;
        private Date createdDate;
        private Date updatedDate;

        public Builder() {
        }

        public Builder salonId(String val) {
            salonId = val;
            return this;
        }

        public Builder salonName(String val) {
            salonName = val;
            return this;
        }

        public Builder salonAddress(String val) {
            salonAddress = val;
            return this;
        }

        public Builder salonManagerName(String val) {
            salonManagerName = val;
            return this;
        }

        public Builder salonManagerUser(String val) {
            salonManagerUser = val;
            return this;
        }

        public Builder salonRating(String val) {
            salonRating = val;
            return this;
        }

        public Builder salonTotalReview(String val) {
            salonTotalReview = val;
            return this;
        }

        public Builder salonTotalStylish(String val) {
            salonTotalStylish = val;
            return this;
        }

        public Builder salonSubscriptionStatus(boolean val) {
            salonSubscriptionStatus = val;
            return this;
        }

        public Builder salonImageUrl(String val) {
            salonImageUrl = val;
            return this;
        }

        public Builder createdBy(String val) {
            createdBy = val;
            return this;
        }

        public Builder updatedBy(String val) {
            updatedBy = val;
            return this;
        }

        public Builder createdDate(Date val) {
            createdDate = val;
            return this;
        }

        public Builder updatedDate(Date val) {
            updatedDate = val;
            return this;
        }

        public Salon build() {
            return new Salon(this);
        }
    }
}

