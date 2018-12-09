package com.seongenie.example.index.naver

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class NaverRequestBuilder {
  companion object {

    private val HEADER_CLIENT_ID = "X-Naver-Client-Id"
    private val HEADER_CLIENT_SECRET = "X-Naver-Client-Secret"
    private val CLIENT_ID: String = "Q0HAqaglIJbuPtDnPKo6"
    private val CLIENT_SECRET: String = "Vogzp2vZnu"

    fun build(): NaverAPI {
      val headerInterceptor = Interceptor { chain ->
        var newRequest = chain.request().newBuilder()
                .addHeader(HEADER_CLIENT_ID, CLIENT_ID)
                .addHeader(HEADER_CLIENT_SECRET, CLIENT_SECRET)
                .build()
        chain.proceed(newRequest) }
      val logInterceptor = HttpLoggingInterceptor()
      val client = OkHttpClient.Builder()
              .addInterceptor(headerInterceptor)
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