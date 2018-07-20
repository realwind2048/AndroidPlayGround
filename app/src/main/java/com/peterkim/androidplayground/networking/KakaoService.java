package com.peterkim.androidplayground.networking;

import com.google.gson.JsonObject;
import com.peterkim.androidplayground.entity.SearchImage;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface KakaoService {
    @GET("v2/search/vclip")
    Call<JsonObject> searchVideo(@Query("query") String query, @Query("page") int page);

    @GET("v2/search/image")
    Call<SearchImage> searchImage(@Query("query") String query, @Query("page") int page);
}
