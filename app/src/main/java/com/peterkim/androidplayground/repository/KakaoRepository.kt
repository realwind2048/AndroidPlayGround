package com.peterkim.myapplication.repository

import android.arch.lifecycle.MutableLiveData
import android.util.Log
import com.peterkim.androidplayground.entity.Image
import com.peterkim.androidplayground.entity.SearchImage
import com.peterkim.androidplayground.networking.KakaoApi
import com.peterkim.androidplayground.networking.KakaoService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Singleton

@Singleton
class KakaoRepository(val images: MutableLiveData<List<Image>>) {
    private val TAG = KakaoRepository::class.java.simpleName

    private var kakaoService: KakaoService? = null

    init {
        kakaoService = KakaoApi.getInstance()
    }
    fun getImages() {
        Log.d(TAG, "getImages")

//        val data = MutableLiveData<List<Image>>()
        kakaoService?.searchImage("blackpink", 1)?.enqueue(object : Callback<SearchImage> {
            override fun onFailure(call: Call<SearchImage>?, t: Throwable?) {
                Log.d(TAG, "onFailure")
            }

            override fun onResponse(call: Call<SearchImage>?, response: Response<SearchImage>?) {
                Log.d(TAG, "onResponse response = " + response?.body())

                images.value = response?.body()?.document
            }
        })

//        return data
    }
}