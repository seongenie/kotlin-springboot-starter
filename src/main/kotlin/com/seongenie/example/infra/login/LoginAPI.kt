package com.seongenie.example.infra.login


import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query


interface LoginAPIAPI {

  @GET("nid/me")
  fun getNaverLoginInfo(@Header("Authorization") token: String): Observable<NaverLoginResult>
}

