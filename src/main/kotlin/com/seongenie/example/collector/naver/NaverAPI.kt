package com.seongenie.example.collector.naver

import io.reactivex.Observable
import org.springframework.web.bind.annotation.RequestParam
import retrofit2.Call
import retrofit2.http.POST
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET


interface NaverAPI {

  @GET("search/local.json")
  fun getStores(@RequestParam("query") query: String,
          @RequestParam("display") display: Int = 10): Observable<NaverSearchResult>
}

