package com.peterkim.androidplayground.service;

import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface KakaoService {
    @GET("v2/search/vclip")
    Call<JsonObject> searchVideo(@Query("query") String query, @Query("page") int page);

    @GET("v2/search/image")
    Call<JsonObject> searchImage(@Query("query") String query, @Query("page") int page);
}
