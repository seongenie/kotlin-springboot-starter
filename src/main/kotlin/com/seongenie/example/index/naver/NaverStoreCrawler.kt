package com.seongenie.example.index.naver

import com.seongenie.example.index.infra.Crawler
import io.reactivex.schedulers.Schedulers
import org.elasticsearch.client.RestHighLevelClient

class NaverStoreCrawler(val client: RestHighLevelClient) : Crawler<NaverSearchResult> {

  var total: Int = 0
  val api: NaverAPI = NaverRequestBuilder.build()

  override fun crawl(text: String, start: Int, success: ((NaverSearchResult) -> Unit)) {
    var result= api.getStores(query = text, start = start, display = NaverConstants.DISPLAY)
    var start = start
    var total = 0
    result.subscribeOn(Schedulers.newThread()).subscribe({it ->
      total = it.total
      success(it)
    },{ it.printStackTrace() }, {
      Thread.sleep(200)
      if (start * NaverConstants.DISPLAY < total) {
        this.crawl(text, ++start, success)
      } else {
        client.close();
      }
    })
  }

  private fun crawl(start: Int) {

  }
}
