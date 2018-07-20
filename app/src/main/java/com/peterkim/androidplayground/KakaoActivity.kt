package com.peterkim.androidplayground

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.peterkim.androidplayground.ui.kakao.KakaoFragment

/**
 * Show searched image list through KakaoAPI
 */
class KakaoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.kakao_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.container, KakaoFragment.newInstance())
                    .commitNow()
        }
    }
}
