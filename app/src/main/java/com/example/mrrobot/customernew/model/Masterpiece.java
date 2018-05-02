package com.example.mrrobot.customernew.model;

/**
 * Created by Mr Robot on 12/19/2017.
 */

public class Masterpiece {

    private String id;
    private String title;
    private String imgUrl;
    private String imgThumbnailUrl;

    public Masterpiece() {
    }

    public Masterpiece(String id, String title, String imgUrl, String imgThumbnailUrl) {
        this.id = id;
        this.title = title;
        this.imgUrl = imgUrl;
        this.imgThumbnailUrl = imgThumbnailUrl;
    }

    private Masterpiece(Builder builder) {
        setId(builder.id);
        setTitle(builder.title);
        setImgUrl(builder.imgUrl);
        setImgThumbnailUrl(builder.imgThumbnailUrl);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getImgThumbnailUrl() {
        return imgThumbnailUrl;
    }

    public void setImgThumbnailUrl(String imgThumbnailUrl) {
        this.imgThumbnailUrl = imgThumbnailUrl;
    }

    public static final class Builder {
        private String id;
        private String title;
        private String imgUrl;
        private String imgThumbnailUrl;

        public Builder() {
        }

        public Builder id(String val) {
            id = val;
            return this;
        }

        public Builder title(String val) {
            title = val;
            return this;
        }

        public Builder imgUrl(String val) {
            imgUrl = val;
            return this;
        }

        public Builder imgThumbnailUrl(String val) {
            imgThumbnailUrl = val;
            return this;
        }

        public Masterpiece build() {
            return new Masterpiece(this);
        }
    }
}
