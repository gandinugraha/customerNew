package com.example.mrrobot.customernew.model;

/**
 * Created by Mr Robot on 12/19/2017.
 */

public class StylishLocation {

    private String stylishId;
    private String stylishName;
    private String stylishThumbnailImgUrl;
    private String salonId;

    public StylishLocation() {
    }

    public StylishLocation(String stylishId, String stylishName, String stylishThumbnailImgUrl, String salonId) {
        this.stylishId = stylishId;
        this.stylishName = stylishName;
        this.stylishThumbnailImgUrl = stylishThumbnailImgUrl;
        this.salonId = salonId;
    }

    private StylishLocation(Builder builder) {
        setStylishId(builder.stylishId);
        setStylishName(builder.stylishName);
        setStylishThumbnailImgUrl(builder.stylishThumbnailImgUrl);
        setSalonId(builder.salonId);
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

    public String getStylishThumbnailImgUrl() {
        return stylishThumbnailImgUrl;
    }

    public void setStylishThumbnailImgUrl(String stylishThumbnailImgUrl) {
        this.stylishThumbnailImgUrl = stylishThumbnailImgUrl;
    }

    public String getSalonId() {
        return salonId;
    }

    public void setSalonId(String salonId) {
        this.salonId = salonId;
    }


    public static final class Builder {
        private String stylishId;
        private String stylishName;
        private String stylishThumbnailImgUrl;
        private String salonId;

        public Builder() {
        }

        public Builder stylishId(String val) {
            stylishId = val;
            return this;
        }

        public Builder stylishName(String val) {
            stylishName = val;
            return this;
        }

        public Builder stylishThumbnailImgUrl(String val) {
            stylishThumbnailImgUrl = val;
            return this;
        }

        public Builder salonId(String val) {
            salonId = val;
            return this;
        }

        public StylishLocation build() {
            return new StylishLocation(this);
        }
    }
}
