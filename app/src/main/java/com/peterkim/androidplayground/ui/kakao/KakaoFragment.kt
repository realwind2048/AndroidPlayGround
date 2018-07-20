package com.peterkim.androidplayground.ui.kakao

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.peterkim.androidplayground.R
import kotlinx.android.synthetic.main.kakao_fragment.*

class KakaoFragment : Fragment() {
    private val TAG = KakaoFragment::class.java.simpleName
    companion object {
        fun newInstance() = KakaoFragment()
    }
    private lateinit var viewModel: KakaoViewModel
    private lateinit var adapter: MyAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.kakao_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(KakaoViewModel::class.java)
        observeViewModel()

        rvImageList.layoutManager = LinearLayoutManager(context)
        adapter = MyAdapter()
        rvImageList.adapter = adapter


        Log.d(TAG, "viewModel.getImages() = " + viewModel.getImages())
    }

    private fun observeViewModel() {
        viewModel.getImages()?.observe(this, Observer {
            Log.d(TAG, "viewModel.getImages() !! updated " + viewModel.getImages())
            adapter.setItems(it?.toMutableList())
        })
    }

}
