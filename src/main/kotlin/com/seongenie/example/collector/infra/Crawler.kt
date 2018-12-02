package com.seongenie.example.collector.infra

import com.seongenie.example.collector.naver.NaverSearchResult

interface Crawler<T> {
  open fun crawl(text: String, success: ((T) -> Unit))
}
