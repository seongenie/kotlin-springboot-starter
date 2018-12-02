package com.seongenie.example.collector.naver

import com.seongenie.example.collector.infra.Crawler
import io.reactivex.schedulers.Schedulers

class NaverStoreCrawler : Crawler<NaverSearchResult> {
  var api: NaverAPI
  constructor() {
    api = NaverRequestBuilder.build()
  }

  override fun crawl(text: String, success: ((NaverSearchResult) -> Unit)) {
    var result= api.getStores(query = text)
    result.subscribeOn(Schedulers.io()).subscribe { success(it) }
  }

}