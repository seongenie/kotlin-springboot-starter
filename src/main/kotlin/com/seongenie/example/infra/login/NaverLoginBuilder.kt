package com.seongenie.example.index.naver

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class NaverLoginBuilder {
  companion object {

    fun build(): NaverAPI {
      val logInterceptor = HttpLoggingInterceptor()
      val client = OkHttpClient.Builder()
              .addInterceptor(logInterceptor).build()
      logInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
      var retrofit = Retrofit.Builder()
              .baseUrl("https://openapi.naver.com/v1/")
              .addConverterFactory(GsonConverterFactory.create())
              .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
              .client(client)
              .build();
      return retrofit.create(NaverAPI::class.java)
    }
  }

}