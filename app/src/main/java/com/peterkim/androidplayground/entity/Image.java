package com.peterkim.androidplayground.entity;

import com.google.gson.annotations.SerializedName;

public class Image extends Media {
    @SerializedName("collection")
    private String collection;

    @SerializedName("thumbnail_url")
    private String thumbnailUrl;

    @SerializedName("image_url")
    private String imageUrl;

    @SerializedName("width")
    private int width;

    @SerializedName("height")
    private int height;

    @SerializedName("display_sitename")
    private String displaySitename;

    @SerializedName("doc_url")
    private String docUrl;

    public String getCollection() {
        return collection;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public String getDisplaySitename() {
        return displaySitename;
    }

    public String getDocUrl() {
        return docUrl;
    }
}
