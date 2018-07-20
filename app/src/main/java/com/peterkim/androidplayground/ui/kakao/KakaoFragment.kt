package com.peterkim.androidplayground.ui.kakao

import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.peterkim.androidplayground.R
import com.peterkim.androidplayground.entity.Media
import kotlinx.android.synthetic.main.kakao_fragment.*

class KakaoFragment : Fragment() {
    private val TAG = KakaoFragment::class.java.simpleName
    companion object {
        fun newInstance() = KakaoFragment()
    }
    private lateinit var viewModel: KakaoViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.kakao_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(KakaoViewModel::class.java)
        viewModel.getImages()?.observe(this, Observer {
            Log.d(TAG, "viewModel.getImages() !! updated " + viewModel.getImages())
        })

        Log.d(TAG, "viewModel.getImages() = " + viewModel.getImages())
    }

}

private fun <T> LiveData<T>.observe(kakaoFragment: KakaoFragment, observer: Observer<T>) {

}
