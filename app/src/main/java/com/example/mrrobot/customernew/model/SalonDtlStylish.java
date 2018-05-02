package com.example.mrrobot.customernew.model;

/**
 * Created by Mr Robot on 12/19/2017.
 */

public class SalonDtlStylish {

    private String salonId;
    private String stylishId;
    private String stylishName;
    private boolean stylishAvailablity;
    private String stylishMondayHours;
    private String stylishTuesdayHours;
    private String stylishWednesdayHours;
    private String stylishThursdayHours;
    private String stylishFridayHours;
    private String stylishSaturdayHours;
    private String stylishSundayHours;

    public SalonDtlStylish() {
    }

    public SalonDtlStylish(String salonId, String stylishId, String stylishName, boolean stylishAvailablity, String stylishMondayHours, String stylishTuesdayHours, String stylishWednesdayHours, String stylishThursdayHours, String stylishFridayHours, String stylishSaturdayHours, String stylishSundayHours) {
        this.salonId = salonId;
        this.stylishId = stylishId;
        this.stylishName = stylishName;
        this.stylishAvailablity = stylishAvailablity;
        this.stylishMondayHours = stylishMondayHours;
        this.stylishTuesdayHours = stylishTuesdayHours;
        this.stylishWednesdayHours = stylishWednesdayHours;
        this.stylishThursdayHours = stylishThursdayHours;
        this.stylishFridayHours = stylishFridayHours;
        this.stylishSaturdayHours = stylishSaturdayHours;
        this.stylishSundayHours = stylishSundayHours;
    }

    private SalonDtlStylish(Builder builder) {
        setSalonId(builder.salonId);
        setStylishId(builder.stylishId);
        setStylishName(builder.stylishName);
        setStylishAvailablity(builder.stylishAvailablity);
        setStylishMondayHours(builder.stylishMondayHours);
        setStylishTuesdayHours(builder.stylishTuesdayHours);
        setStylishWednesdayHours(builder.stylishWednesdayHours);
        setStylishThursdayHours(builder.stylishThursdayHours);
        setStylishFridayHours(builder.stylishFridayHours);
        setStylishSaturdayHours(builder.stylishSaturdayHours);
        setStylishSundayHours(builder.stylishSundayHours);
    }

    public String getSalonId() {
        return salonId;
    }

    public void setSalonId(String salonId) {
        this.salonId = salonId;
    }

    public String getStylishId() {
        return stylishId;
    }

    public void setStylishId(String stylishId) {
        this.stylishId = stylishId;
    }

    public String getStylishName() {
        return stylishName;
    }

    public void setStylishName(String stylishName) {
        this.stylishName = stylishName;
    }

    public boolean isStylishAvailablity() {
        return stylishAvailablity;
    }

    public void setStylishAvailablity(boolean stylishAvailablity) {
        this.stylishAvailablity = stylishAvailablity;
    }

    public String getStylishMondayHours() {
        return stylishMondayHours;
    }

    public void setStylishMondayHours(String stylishMondayHours) {
        this.stylishMondayHours = stylishMondayHours;
    }

    public String getStylishTuesdayHours() {
        return stylishTuesdayHours;
    }

    public void setStylishTuesdayHours(String stylishTuesdayHours) {
        this.stylishTuesdayHours = stylishTuesdayHours;
    }

    public String getStylishWednesdayHours() {
        return stylishWednesdayHours;
    }

    public void setStylishWednesdayHours(String stylishWednesdayHours) {
        this.stylishWednesdayHours = stylishWednesdayHours;
    }

    public String getStylishThursdayHours() {
        return stylishThursdayHours;
    }

    public void setStylishThursdayHours(String stylishThursdayHours) {
        this.stylishThursdayHours = stylishThursdayHours;
    }

    public String getStylishFridayHours() {
        return stylishFridayHours;
    }

    public void setStylishFridayHours(String stylishFridayHours) {
        this.stylishFridayHours = stylishFridayHours;
    }

    public String getStylishSaturdayHours() {
        return stylishSaturdayHours;
    }

    public void setStylishSaturdayHours(String stylishSaturdayHours) {
        this.stylishSaturdayHours = stylishSaturdayHours;
    }

    public String getStylishSundayHours() {
        return stylishSundayHours;
    }

    public void setStylishSundayHours(String stylishSundayHours) {
        this.stylishSundayHours = stylishSundayHours;
    }


    public static final class Builder {
        private String salonId;
        private String stylishId;
        private String stylishName;
        private boolean stylishAvailablity;
        private String stylishMondayHours;
        private String stylishTuesdayHours;
        private String stylishWednesdayHours;
        private String stylishThursdayHours;
        private String stylishFridayHours;
        private String stylishSaturdayHours;
        private String stylishSundayHours;

        public Builder() {
        }

        public Builder salonId(String val) {
            salonId = val;
            return this;
        }

        public Builder stylishId(String val) {
            stylishId = val;
            return this;
        }

        public Builder stylishName(String val) {
            stylishName = val;
            return this;
        }

        public Builder stylishAvailablity(boolean val) {
            stylishAvailablity = val;
            return this;
        }

        public Builder stylishMondayHours(String val) {
            stylishMondayHours = val;
            return this;
        }

        public Builder stylishTuesdayHours(String val) {
            stylishTuesdayHours = val;
            return this;
        }

        public Builder stylishWednesdayHours(String val) {
            stylishWednesdayHours = val;
            return this;
        }

        public Builder stylishThursdayHours(String val) {
            stylishThursdayHours = val;
            return this;
        }

        public Builder stylishFridayHours(String val) {
            stylishFridayHours = val;
            return this;
        }

        public Builder stylishSaturdayHours(String val) {
            stylishSaturdayHours = val;
            return this;
        }

        public Builder stylishSundayHours(String val) {
            stylishSundayHours = val;
            return this;
        }

        public SalonDtlStylish build() {
            return new SalonDtlStylish(this);
        }
    }
}
