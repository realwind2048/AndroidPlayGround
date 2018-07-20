package com.peterkim.myapplication.repository

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.util.Log
import com.google.gson.JsonObject
import com.peterkim.androidplayground.entity.Image
import com.peterkim.androidplayground.service.KakaoService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Singleton

@Singleton
class KakaoRepository {
    private val TAG = KakaoRepository::class.java.simpleName

    private val service: KakaoService? = null
    fun getImages() : MutableLiveData<List<Image>>? {
        Log.d(TAG, "getImages")

        val data = MutableLiveData<List<Image>>()
        service?.searchImage("blackpink", 1)?.enqueue(object : Callback<JsonObject> {
            override fun onFailure(call: Call<JsonObject>?, t: Throwable?) {
                Log.d(TAG, "onFailure")
            }

            override fun onResponse(call: Call<JsonObject>?, response: Response<JsonObject>?) {
                Log.d(TAG, "onResponse")
                data.value = ArrayList()
            }
        })

        return data
    }
}