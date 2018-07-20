package com.peterkim.androidplayground.entity;

import android.support.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class Media implements Comparable<Media> {
    @SerializedName("datetime")
    private String datetime;
    private boolean isFavorite = false;
    private String id;
    private Date date;

    public String getDatetime() {
        return datetime;
    }

    public void setFavorite(boolean favorite) {
        isFavorite = favorite;
    }

    public boolean isFavorite() {
        return isFavorite;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public int compareTo(@NonNull Media o) {
        Date lhs = o.getDate();
        Date rhs = getDate();
        if(lhs != null && rhs != null) {
            return lhs.compareTo(rhs);
        } else {
            return 0;
        }
    }
}
