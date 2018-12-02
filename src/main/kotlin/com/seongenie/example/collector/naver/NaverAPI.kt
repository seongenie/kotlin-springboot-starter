package com.seongenie.example.collector.naver

import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query


interface NaverAPI {

  @GET("search/local.json")
  fun getStores(@Query("query") query: String,
                @Query("display") display: Int = 30,
                @Query("start") start: Int = 1): Observable<NaverSearchResult>
}

