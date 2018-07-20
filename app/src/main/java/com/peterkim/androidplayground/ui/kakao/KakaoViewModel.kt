package com.peterkim.androidplayground.ui.kakao

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.util.Log
import com.peterkim.androidplayground.entity.Image
import com.peterkim.androidplayground.entity.SearchImage
import com.peterkim.myapplication.repository.KakaoRepository

class KakaoViewModel : ViewModel() {
    private val TAG = KakaoViewModel::class.java.simpleName
    private var repository: KakaoRepository? = null
    private val images = MutableLiveData<List<Image>>()
    private val loading = MutableLiveData<Boolean>()

    init {
        repository = KakaoRepository(images)
        repository?.getImages()
    }

    fun getImages() : MutableLiveData<List<Image>>? {
        Log.d(TAG, "getImages")
        return images
    }
}
