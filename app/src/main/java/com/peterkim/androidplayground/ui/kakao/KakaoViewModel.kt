package com.peterkim.androidplayground.ui.kakao

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.util.Log
import com.peterkim.androidplayground.entity.Image
import com.peterkim.myapplication.repository.KakaoRepository
import javax.inject.Inject

class KakaoViewModel() : ViewModel() {
    private val TAG = KakaoViewModel::class.java.simpleName
    private var repository: KakaoRepository? = null
    private val images: MutableLiveData<List<Image>> = MutableLiveData()

//    @Inject
//    constructor(repository: KakaoRepository) : this() {
//        this.repository = repository
//    }

    init {
        repository = KakaoRepository()
    }

    fun getImages() : MutableLiveData<List<Image>>? {
        Log.d(TAG, "getImages")
        return repository?.getImages()
    }
}
