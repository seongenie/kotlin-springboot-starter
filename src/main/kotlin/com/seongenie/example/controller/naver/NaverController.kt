package com.seongenie.example.controller.naver

import com.seongenie.example.collector.naver.NaverStoreCrawler
import com.seongenie.example.domain.naver.NaverStore
import com.seongenie.example.service.NaverStoreService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/naver")
class NaverController {

  @Autowired
  lateinit var service: NaverStoreService

  @RequestMapping(value = "/crawl", method = [RequestMethod.GET])
  fun crawlNaverStore(@RequestParam("text") text: String) {
    var crawler = NaverStoreCrawler()
    crawler.crawl(text, { naverSearchResult ->
      naverSearchResult.items?.forEach {
        service.insertNaverStore(it)
      }
    })
  }

  @RequestMapping(value ="/stores", method = [RequestMethod.GET])
  fun getNaverStores(): List<NaverStore> {
    return service.getNaverStores()
  }

}