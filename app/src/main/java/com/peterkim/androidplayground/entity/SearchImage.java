package com.peterkim.androidplayground.entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SearchImage extends Search {
    @SerializedName("documents")
    private List<Image> documents;

    public List<Image> getDocument() {
        return documents;
    }
}
