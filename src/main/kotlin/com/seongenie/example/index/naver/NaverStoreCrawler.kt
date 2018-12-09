package com.seongenie.example.index.naver

import com.seongenie.example.index.infra.Crawler
import io.reactivex.schedulers.Schedulers
import org.elasticsearch.client.RestHighLevelClient

class NaverStoreCrawler(val client: RestHighLevelClient) : Crawler<NaverSearchResult> {

  var total: Int = 0
  var start: Int = 1
  val display: Int = 30
  val api: NaverAPI = NaverRequestBuilder.build()

  override fun crawl(text: String, success: ((NaverSearchResult) -> Unit)) {
    var result= api.getStores(query = text, start = start, display = display)
    result.subscribeOn(Schedulers.io()).subscribe({it ->
      total = it.total!!
      start = it.start!!
      success(it)
    },{ it.printStackTrace() }, {
//      if (start * display < total) {
//        start++
//        this.crawl(text, success)
//      } else {
//        client.close()
//      }
    })
  }

  private fun crawl(start: Int) {

  }

}