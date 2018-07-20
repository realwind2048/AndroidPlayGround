package com.peterkim.androidplayground.networking

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class KakaoApi private constructor() {

    companion object {
        private const val KD_REST_API_KEY = "20031fb5a43403c69932656ed2a71551"
        private const val KAKAO_API_BASE_URL = "https://dapi.kakao.com/"
        private var retrofit: Retrofit? = null
        private var kakaoService: KakaoService? = null

        fun getInstance() : KakaoService? {
            if(kakaoService != null) {
                return kakaoService
            }
            if(retrofit == null) {
                initializeRetrofit()
            }
            kakaoService = retrofit?.create(KakaoService::class.java)
            return kakaoService
        }

        private fun initializeRetrofit() {
            val okHttpClient = OkHttpClient().newBuilder().addInterceptor { chain ->
                val originalRequest = chain.request()
                val builder = originalRequest.newBuilder()
                        .header("Authorization", "KakaoAK " + KD_REST_API_KEY)
                val newRequest = builder.build()
                chain.proceed(newRequest)
            }.build()

            retrofit = Retrofit.Builder()
                    .baseUrl(KAKAO_API_BASE_URL)
                    .client(okHttpClient)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
        }
    }
}