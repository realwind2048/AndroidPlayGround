package com.peterkim.androidplayground.entity;

import com.google.gson.annotations.SerializedName;

public class Search {

    @SerializedName("meta")
    private Meta meta;

    public Meta getMeta() {
        return meta;
    }
}
