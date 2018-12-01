package com.seongenie.example.collector.naver

import com.seongenie.example.collector.infra.Crawler
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.net.URLEncoder


class NaverStoreCrawler : Crawler {
  private val HEADER_CLIENT_ID = "X-Naver-Client-Id"
  private val HEADER_CLIENT_SECRET = "X-Naver-Client-Id"
  private val CLIENT_ID: String = "t1c6XYNjTkEfZA89Z8Fz"
  private val CLIENT_SECRET: String = "FnBYvMTZ"

  fun requestBuild(): NaverAPI? {
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
            .client(client)
            .build();
    return retrofit.create(NaverAPI::class.java)
  }

  override fun crawl() {
    val api = requestBuild()
    var result = api?.getStores(query = textEncoding("대방어"))
  }

  fun textEncoding(text: String) : String {
    return URLEncoder.encode(text, "UTF-8");
  }

}